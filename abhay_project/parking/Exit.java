

package parking;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.time.temporal.ChronoUnit;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.JTextField;
import javax.swing.JButton;
//import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
//import javax.swing.SwingConstants;

public class Exit extends JFrame implements ActionListener,WindowListener,KeyListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField text_Staffidout;
	private JTextField text_Outdate;
	private JTextField text_Outtime;
	private JTextField text_Charge;
	private JTextField text_Hour;
	private JTextField text_Status;
	private JTextField text_Indate;
	private JTextField text_Intime;
	private JTextField text_Parkingid;
	PreparedStatement psread;
    Connection con;
    ResultSet rsread;
    String userid=login_details.username;
    String indate,intime;
    long hour,charge;
    long noOfDaysBetween;
    PreparedStatement pswrite;
    String result;
    String vehicle;
    int chargeperday=0;
	
	String sqlhour;
	int chargeperhour=0,weekend_day;
	int hours,mainhour;
	long weekdays=0;
	String str_charge,checkstatus;
	String status="checkout",outdate,outtime;
	String checkparkid=null;
	private JTextField text_Token;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Exit frame = new Exit();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Exit() {
		setTitle("Departure");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Exit.class.getResource("/parking/images/icon_parking.png")));
		setResizable(false);
		con = DataBaseConnection.createConnection();
		GUI();
	}
	public void GUI()
	{
		
		
		
		
		
		setBounds(100, 100, 543, 596);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbL_STAFFIDOUT= new JLabel("STAFF ID(OUT)");
		lbL_STAFFIDOUT.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lbL_STAFFIDOUT.setForeground(new Color(128, 0, 0));
		lbL_STAFFIDOUT.setBounds(44, 165, 137, 29);
		contentPane.add(lbL_STAFFIDOUT);
		
		JLabel lbL__OUTDATE = new JLabel("CHECKOUT DATE");
		lbL__OUTDATE.setForeground(new Color(0, 250, 154));
		lbL__OUTDATE.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lbL__OUTDATE.setBounds(44, 205, 137, 29);
		contentPane.add(lbL__OUTDATE);
		
		JLabel lbL__OUTTIME = new JLabel("CHECKOUT TIME");
		lbL__OUTTIME.setForeground(new Color(0, 250, 154));
		lbL__OUTTIME.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lbL__OUTTIME.setBounds(44, 245, 137, 29);
		contentPane.add(lbL__OUTTIME);
		
		JLabel lbL__CHARGE = new JLabel("CHARGE");
		lbL__CHARGE.setForeground(new Color(0, 250, 154));
		lbL__CHARGE.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lbL__CHARGE.setBounds(44, 285, 137, 29);
		contentPane.add(lbL__CHARGE);
		
		JLabel lbL__HOUR = new JLabel("HOUR");
		lbL__HOUR.setForeground(new Color(0, 250, 154));
		lbL__HOUR.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lbL__HOUR.setBounds(44, 403, 137, 29);
		contentPane.add(lbL__HOUR);
		
		JLabel lbL__STATUS = new JLabel("STATUS");
		lbL__STATUS.setForeground(new Color(0, 250, 154));
		lbL__STATUS.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lbL__STATUS.setBounds(44, 443, 137, 29);
		contentPane.add(lbL__STATUS);
		
		text_Staffidout = new JTextField();
		text_Staffidout.setEditable(false);
		text_Staffidout.setForeground(Color.BLACK);
		text_Staffidout.setFont(new Font("Garamond", Font.BOLD, 15));
		text_Staffidout.setBounds(255, 165, 137, 29);
		contentPane.add(text_Staffidout);
		text_Staffidout.setColumns(10);
		
		text_Outdate = new JTextField();
		text_Outdate.setForeground(Color.BLACK);
		text_Outdate.setFont(new Font("Garamond", Font.BOLD, 15));
		text_Outdate.setEditable(false);
		text_Outdate.setColumns(10);
		text_Outdate.setBounds(255, 205, 137, 29);
		contentPane.add(text_Outdate);
		
		text_Outtime = new JTextField();
		text_Outtime.setForeground(Color.BLACK);
		text_Outtime.setFont(new Font("Garamond", Font.BOLD, 15));
		text_Outtime.setEditable(false);
		text_Outtime.setColumns(10);
		text_Outtime.setBounds(255, 245, 137, 29);
		contentPane.add(text_Outtime);
		
		text_Charge = new JTextField();
		text_Charge.setForeground(Color.BLACK);
		text_Charge.setFont(new Font("Garamond", Font.BOLD, 15));
		text_Charge.setEditable(false);
		text_Charge.setColumns(10);
		text_Charge.setBounds(255, 285, 137, 29);
		contentPane.add(text_Charge);
		
		text_Hour = new JTextField();
		text_Hour.setForeground(Color.BLACK);
		text_Hour.setFont(new Font("Garamond", Font.BOLD, 15));
		text_Hour.setEditable(false);
		text_Hour.setColumns(10);
		text_Hour.setBounds(255, 405, 137, 29);
		contentPane.add(text_Hour);
		
		text_Status = new JTextField();
		text_Status.setForeground(Color.BLACK);
		text_Status.setFont(new Font("Garamond", Font.BOLD, 15));
		text_Status.setEditable(false);
		text_Status.setColumns(10);
		text_Status.setBounds(255, 445, 137, 29);
		contentPane.add(text_Status);
		
		JLabel lbL_INTIME = new JLabel("CHECKIN TIME");
		lbL_INTIME.setForeground(new Color(0, 250, 154));
		lbL_INTIME.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lbL_INTIME.setBounds(44, 363, 137, 29);
		contentPane.add(lbL_INTIME);
		
		JLabel lbL__INDATE = new JLabel("CHECKIN DATE");
		lbL__INDATE.setForeground(new Color(0, 250, 154));
		lbL__INDATE.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lbL__INDATE.setBounds(44, 323, 137, 29);
		contentPane.add(lbL__INDATE);
		
		text_Indate = new JTextField();
		text_Indate.setForeground(Color.BLACK);
		text_Indate.setFont(new Font("Garamond", Font.BOLD, 15));
		text_Indate.setEditable(false);
		text_Indate.setColumns(10);
		text_Indate.setBounds(255, 325, 137, 29);
		contentPane.add(text_Indate);
		
		text_Intime = new JTextField();
		text_Intime.setForeground(Color.BLACK);
		text_Intime.setFont(new Font("Garamond", Font.BOLD, 15));
		text_Intime.setEditable(false);
		text_Intime.setColumns(10);
		text_Intime.setBounds(255, 365, 137, 29);
		contentPane.add(text_Intime);
		
		JButton btn_SEARCH = new JButton("SEARCH");
		
		btn_SEARCH.setForeground(new Color(248, 248, 255));
		btn_SEARCH.setBackground(new Color(135, 206, 235));
		
		btn_SEARCH.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 17));
		btn_SEARCH.setBounds(417, 81, 97, 35);
		btn_SEARCH.setIcon(null);
		btn_SEARCH.addActionListener(this);
		btn_SEARCH.addKeyListener(this);
		contentPane.add(btn_SEARCH);
		
		
		JLabel lbL__PARKINGID = new JLabel("PARKING ID");
		lbL__PARKINGID.setForeground(new Color(128, 0, 0));
		lbL__PARKINGID.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lbL__PARKINGID.setBounds(44, 125, 137, 29);
		contentPane.add(lbL__PARKINGID);
		
		text_Parkingid = new JTextField();
		text_Parkingid.setEditable(false);
		text_Parkingid.setForeground(Color.BLACK);
		text_Parkingid.setFont(new Font("Garamond", Font.BOLD, 15));
		text_Parkingid.setColumns(10);
		text_Parkingid.setBounds(255, 125, 137, 29);
		contentPane.add(text_Parkingid);
		
		text_Token = new JTextField();
		text_Token.setForeground(Color.BLACK);
		text_Token.setFont(new Font("Garamond", Font.BOLD, 15));
		text_Token.setColumns(10);
		text_Token.setBounds(255, 85, 137, 29);
		contentPane.add(text_Token);
		
		JLabel lbL__TOKEN = new JLabel("TOKEN");
		lbL__TOKEN.setForeground(new Color(128, 0, 0));
		lbL__TOKEN.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lbL__TOKEN.setBounds(44, 85, 137, 29);
		contentPane.add(lbL__TOKEN);
		
		JLabel lblNewLabel = new JLabel("DEPARTURE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Garamond", Font.BOLD, 31));
		lblNewLabel.setForeground(new Color(250, 128, 114));
		lblNewLabel.setBounds(171, 22, 261, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Exit.class.getResource("/parking/images/exit.jpg")));
		lblNewLabel_1.setBounds(0, 0, 538, 567);
		contentPane.add(lblNewLabel_1);
		
		clock();
		
		setLocationRelativeTo(null);
	}
    String parkid;
    long weeke = 0;
    String token;
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		clock();
		int code=e.getKeyCode();
		if(code==10)
		{
			checkToken();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		Exit_Dashboard frame=new Exit_Dashboard();
		frame.setVisible(true);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		clock();
		checkToken();
		
		
		
	}
	
	
	public void checkToken()
	{
		fetch();
		//checkparkid=text_Parkingid.getText();
		//System.out.println(checkparkid+"hey");
		if (token.isBlank())
		{
			JOptionPane.showMessageDialog(this,"please enter token");
		}
		else
		{
			
			
				
			
			searchDetails();
		}
	}
	
	
	
	public void fetch()
	{
		token=text_Token.getText();
	}
	
	
	
	public void searchDetails()
	{
	    	 
		 
		
		
		try 
		  {
			  
		      String str_read = "select * from vehicledetails where tokenid=? and status='checkin'";
			  psread = con.prepareStatement(str_read);
			  psread.setString(1,token);
			  rsread = psread.executeQuery();
			  int flag = 0;
			  while(rsread.next())
			  {
				  
				  String tokenid =rsread.getString("tokenid");
				  if(tokenid.equalsIgnoreCase(token))
				  {
					flag = 1; 
					break;
				  }
				  
			  }
			 
			 if(flag == 1)
			 {
			  text_Indate.setText(rsread.getString("indate"));
			  text_Intime.setText(rsread.getString("intime"));
			  vehicle=rsread.getString("vehicletype");
			  checkstatus=rsread.getString("status");
			  outtime=rsread.getString("outtime");
			  outdate=rsread.getString("outdate");
			  parkid=rsread.getString("parkingid");
			  
			  calculate();
			 
			  
			  }
			 else
				 JOptionPane.showMessageDialog(this,"No vehicle with this token exists", "Error", JOptionPane.ERROR_MESSAGE);
		
		  
		  } 
		
		  
		  catch (SQLException e) 
		  
		  {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
		
		  finally
		  {
			  if(psread!= null)
				try {
					psread.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  if(rsread!= null)
				try {
					rsread.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			  
		  }
		  
		
		
		
		
	}
	
	
	
	
	
	
	
	public void clock()
	{
		DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		 DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
		   LocalDateTime now = LocalDateTime.now();   
		   text_Outdate.setText(date.format(now));
		   text_Outtime.setText(time.format(now));
		   text_Staffidout.setText(userid);
		   text_Parkingid.setText(parkid);
	}
	
	public void calculate()
	{   
		 
		   
		   outdate=text_Outdate.getText();
		   
		   indate=text_Indate.getText();
		   intime=text_Intime.getText();
		   
		      LocalDate dateBefore = LocalDate.parse(indate);
		      LocalDate dateAfter = LocalDate.parse(outdate);
		   
		     noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
		   
		     System.out.println(noOfDaysBetween);
		   
		   
		    int t1 = getTotalMinutes(text_Outtime.getText());
		    int t2 = getTotalMinutes(intime);
		    int total = t1 - t2;
		    result = getResult(total);
		    System.out.println(result);
		    sqlhour=result;
		   
		    charge();
		    
		    
		}

	
	public void charge()
	{ 
	   
		try
		{String str_charge="select * from parking_charge where vehicletype=?";
		psread = con.prepareStatement(str_charge);
		  psread.setString(1, vehicle);
		  rsread = psread.executeQuery();
		  int flag = 0;
		  while(rsread.next())
		  {
			  
			  String sqlvehicle =rsread.getString("vehicletype");
			  if(vehicle.equals(sqlvehicle))
			  {
				flag = 1; 
				break;
			  }
			  
		  }
		 
		 if(flag == 1)
		 {
			 
			weeke=0; 
			 
			 
		  chargeperday=rsread.getInt("chargeday");
		  chargeperhour=rsread.getInt("chargehr");
		 // weekend_hr=rsread.getInt("weekend_chargehr");
		  weekend_day=rsread.getInt("weekend_chargeday");
		  System.out.println("hahaha"+noOfDaysBetween);
		  System.out.println(hours+"hours early");
		  if (hours<0)
		  {
			  noOfDaysBetween=noOfDaysBetween-1;
			  hours=(24-(hours*(-1)));
			  sqlhour=hours+"";
			  mainhour=hours;
		  }
		  if(hours>=10)
		  {   mainhour=hours;
			  noOfDaysBetween+=1;
			  hours=0;
			  
		  }
		  if(noOfDaysBetween>0)
		  {
			  week();
			  
			  
			  
			  
			  charge=((weeke*weekend_day)+(weekdays*chargeperday)+(hours*chargeperhour));
		  }
		  if(noOfDaysBetween==0)
		  {   System.out.println("abhay");
			  if(hours>10)
			  {
				  hours=0;
				  
				  if(endCal.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY || endCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
				    {
				    	weeke+=1;
				    }
				  else weekdays+=1;
				  
				  charge=((weeke*weekend_day)+(weekdays*chargeperday));
			  }
			  
			  else if(hours==0) 
			  {
				  charge=chargeperhour;
			  }
			  else charge=(hours*chargeperhour);
		  }
		  
		  System.out.println(charge);
		  System.out.println("hello week"+weeke);
		  System.out.println("hello weekd"+weekdays);
		  System.out.println("hey"+noOfDaysBetween);
		 }
		 updatevalues();
		 }
		 catch (SQLException e) 
		  
		  {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		  finally
		  {
			  if(psread!= null)
				try {
					psread.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  if(rsread!= null)
				try {
					rsread.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			  
		  }
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void updatevalues()
	{
		 String strinsert = "UPDATE vehicledetails SET checkoutstaffid=?, outdate=?,outtime=?,charge=?,time=?,status=? WHERE parkingid = ?";
		   try {
			   outdate=text_Outdate.getText();
			   str_charge=String.valueOf(charge);
			   text_Hour.setText(noOfDaysBetween+"d : "+sqlhour+"h");
			   text_Status.setText(status);
			   text_Charge.setText(str_charge);
			   pswrite = con.prepareStatement(strinsert);
			   pswrite.setString(1, userid);
			   pswrite.setString(2, outdate);
			   pswrite.setString(3, text_Outtime.getText());
			   pswrite.setLong(4, charge);
			   pswrite.setString(5, noOfDaysBetween+"d : "+sqlhour);
			   pswrite.setString(6, status);
			   pswrite.setString(7, text_Parkingid.getText());
			   
			   
			   
			   
			   int status2 = pswrite.executeUpdate();
			   if(status2 > 0)
			   {   
				   JOptionPane.showMessageDialog(this, str_charge,"parking charge", JOptionPane.INFORMATION_MESSAGE);
					
				   update_token();
				   
			   }
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 finally
			 {
				 if(pswrite!= null)
						try {
							pswrite.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					 
				 
				  }
			  
			  
			  }
	
	
	
	
	public void update_token()
	{ try
	{
		String sql="update tokenid set status='checkout' where idtokenid=?";
		psread=con.prepareStatement(sql);
		psread.setString(1, token);
		psread.executeUpdate();
		}
	catch(SQLException se)
	{
		se.printStackTrace();
	}


	}
	
	
	
	
	
	
		public static int getTotalMinutes(String time) {
		    String[] t = time.split(":");
		    return Integer.valueOf(t[0]) * 60 + Integer.valueOf(t[1]);
		}

		public  String getResult(int total) {
			int minutes = total % 60;
		     hours = ((total - minutes) / 60) % 24;
		    return String.format("%02d", hours);
		}
		   
	
	
	
	
	
	

	
	
	
	Calendar startCal = Calendar.getInstance();
	Calendar endCal = Calendar.getInstance();
	
	public void week()
	{
		try
		{
			
			Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(indate); // your date
			// Choose time zone in which you want to interpret your Date
			Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
			cal.setTime(date1);
			int year1 = cal.get(Calendar.YEAR);
			int month1 = cal.get(Calendar.MONTH)+1;
			int day1 = cal.get(Calendar.DAY_OF_MONTH)+1;
		    System.out.println(year1+" "+month1+" "+day1);
	
    
    
    
		    startCal.set(year1,month1,day1);
    
    
		    Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(outdate); // your date
	
		    cal.setTime(date2);
		    int year2 = cal.get(Calendar.YEAR);
		    int month2 = cal.get(Calendar.MONTH)+1;
		    int day2 = cal.get(Calendar.DAY_OF_MONTH)+1;
		    System.out.println(year2+" "+month2+" "+day2);
		    endCal.set(year2,month2,day2);

    

    
    if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
        
    }

    if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
        startCal.setTime(date1);
        endCal.setTime(date2);
    }

    do
    {
       
        startCal.add(Calendar.DAY_OF_MONTH, 1);
        if (startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            ++weeke;
        }
    } while (startCal.getTimeInMillis() < endCal.getTimeInMillis()); 
    if(mainhour<=9&&(endCal.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY || endCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY))
    {
    	weeke=weeke-1;
    }
System.out.println(mainhour);
 System.out.println("weeke"+weeke);

 System.out.println("voila"+noOfDaysBetween);
 weekdays=noOfDaysBetween-weeke;
 System.out.println("weekd"+weekdays);
}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
		finally
		{
			
		}
	}
}

