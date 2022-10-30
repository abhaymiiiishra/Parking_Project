package parking;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Object;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class Entry extends JFrame implements ActionListener,WindowListener,KeyListener
{
    public static final String a = null;
	String userid=login_details.username;
	
	private JPanel contentPane;
	private JTextField text_ParkingID;
	private JTextField text_StaffIDin;
	private JTextField text_TokenID;
	private JTextField text_VehicleNumber;
	private JTextField text_InDate;
	private JTextField text_InTime;
	private 	JComboBox<String> cmbvehicle;
	private Connection con;
	PreparedStatement psread;
	ResultSet rsread;
	PreparedStatement pswrite;
	int tokenid=0;
	String tok;
	JLabel lbl_suggest;
	
	
	static int enter = KeyEvent.VK_ENTER;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Entry frame = new Entry();
//					frame.setFocusable(true);
//					frame.setVisible(true);
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Entry() {
		setResizable(false);
		setTitle("Entry");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Entry.class.getResource("/parking/images/icon_parking.png")));
		con=DataBaseConnection.createConnection();
		this.addWindowListener(this);
		
		
		GUI();
		
	}
	public void GUI()
	{
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 601);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_ParkingID = new JLabel("PARKING ID");
		lbl_ParkingID.setForeground(new Color(0, 250, 154));
		lbl_ParkingID.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 21));
		lbl_ParkingID.setBounds(10, 86, 162, 35);
		contentPane.add(lbl_ParkingID);
		
		JLabel lbl_StaffIDin = new JLabel("STAFF ID");
		lbl_StaffIDin.setForeground(new Color(0, 250, 154));
		lbl_StaffIDin.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 21));
		lbl_StaffIDin.setBounds(10, 132, 162, 35);
		contentPane.add(lbl_StaffIDin);
		
		JLabel lbl_TokenID = new JLabel("TOKEN ID");
		lbl_TokenID.setForeground(new Color(0, 250, 154));
		lbl_TokenID.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 21));
		lbl_TokenID.setBounds(10, 178, 162, 35);
		contentPane.add(lbl_TokenID);
		
		JLabel lbl_VehicleType = new JLabel("VEHICLE TYPE");
		lbl_VehicleType.setForeground(new Color(0, 250, 154));
		lbl_VehicleType.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 21));
		lbl_VehicleType.setBounds(10, 280, 162, 35);
		contentPane.add(lbl_VehicleType);
		
		JLabel lbl_VehicleNumber = new JLabel("VEHICLE NO");
		lbl_VehicleNumber.setForeground(new Color(0, 250, 154));
		lbl_VehicleNumber.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 21));
		lbl_VehicleNumber.setBounds(10, 326, 162, 35);
		contentPane.add(lbl_VehicleNumber);
		
		JLabel lbl_InDate = new JLabel("DATE");
		lbl_InDate.setForeground(new Color(0, 250, 154));
		lbl_InDate.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 21));
		lbl_InDate.setBounds(10, 372, 162, 35);
		contentPane.add(lbl_InDate);
		
		JLabel lbl_InTime = new JLabel("TIME");
		lbl_InTime.setForeground(new Color(0, 250, 154));
		lbl_InTime.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 21));
		lbl_InTime.setBounds(10, 418, 162, 35);
		contentPane.add(lbl_InTime);
		
		text_ParkingID = new JTextField();
		text_ParkingID.setEditable(false);
		text_ParkingID.setBounds(204, 88, 153, 35);
		text_ParkingID.setFont(new Font("Courier New", Font.BOLD, 18));
		contentPane.add(text_ParkingID);
		text_ParkingID.setColumns(10);
		
		text_StaffIDin = new JTextField();
		text_StaffIDin.setEditable(false);
		text_StaffIDin.setFont(new Font("Courier New", Font.BOLD, 18));
		text_StaffIDin.setColumns(10);
		text_StaffIDin.setBounds(204, 134, 153, 35);
		contentPane.add(text_StaffIDin);
		
		text_TokenID = new JTextField();
		text_TokenID.setColumns(10);
		text_TokenID.setFont(new Font("Courier New", Font.BOLD, 18));
		text_TokenID.setBounds(204, 180, 153, 35);
		contentPane.add(text_TokenID);
		
		text_VehicleNumber = new JTextField();
		text_VehicleNumber.setColumns(10);
		text_VehicleNumber.setFont(new Font("Courier New", Font.BOLD, 18));
		text_VehicleNumber.setBounds(204, 330, 153, 35);
		contentPane.add(text_VehicleNumber);
		
		text_InDate = new JTextField();
		text_InDate.setEditable(false);
		text_InDate.setColumns(10);
		text_InDate.setFont(new Font("Courier New", Font.BOLD, 18));
		text_InDate.setBounds(204, 376, 153, 35);
		contentPane.add(text_InDate);
		
		text_InTime = new JTextField();
		text_InTime.setEditable(false);
		text_InTime.setColumns(10);
		text_InTime.setFont(new Font("Courier New", Font.BOLD, 18));
		text_InTime.setBounds(204, 420, 153, 35);
		contentPane.add(text_InTime);
		
		JButton btn_Save = new JButton("SAVE");
		
		btn_Save.setBackground(new Color(176, 196, 222));
		btn_Save.setFont(new Font("Garamond", Font.BOLD, 22));
		btn_Save.setForeground(new Color(248, 248, 255));
		btn_Save.setBounds(204, 489, 112, 35);
		btn_Save.addActionListener(this);
		btn_Save.addKeyListener(this);
		contentPane.add(btn_Save);
		
		
		setLocationRelativeTo(null);
		
		
		
		clock();
		
		
		
		
		   
		   cmbvehicle = new JComboBox();
		   cmbvehicle.setForeground(new Color(0, 0, 0));
		   cmbvehicle.setFont(new Font("Courier New", Font.BOLD, 18));
		   
		   cmbvehicle.setModel(new DefaultComboBoxModel(new String[] {"Select"})); 
		   populateCombo();
		   cmbvehicle.setBounds(204, 286, 153, 33);
		   contentPane.add(cmbvehicle);
		   
		   
		   
		   
		   
		   lbl_suggest = new JLabel();
		   suggest();
		   lbl_suggest.setFont(new Font("Tahoma", Font.BOLD, 16));
		   lbl_suggest.setForeground(new Color(0, 255, 255));
		   lbl_suggest.setBounds(204, 226, 197, 35);
		   contentPane.add(lbl_suggest);
		   
		   lbl_heading = new JLabel("Enter Vehicle Details");
		   lbl_heading.setFont(new Font("Garamond", Font.BOLD, 26));
		   lbl_heading.setForeground(new Color(255, 140, 0));
		   lbl_heading.setBounds(194, 33, 264, 42);
		   contentPane.add(lbl_heading);
		   
		   lbl_background = new JLabel("");
		   lbl_background.setIcon(new ImageIcon(Entry.class.getResource("/parking/images/olav-tvedt--oVaYMgBMbs-unsplash (3).jpg")));
		   lbl_background.setBounds(0, 0, 562, 562);
		   contentPane.add(lbl_background);
		
		   
		 
		   
		   
		   
		   
		   
		  tokenid();
		  get_parkingid();
	}

	 String abc;
	
	
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	
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
	public void clock()
	{
		DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		 DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
		   LocalDateTime now = LocalDateTime.now();   
		   text_InDate.setText(date.format(now));
		   text_InTime.setText(time.format(now));
		   text_StaffIDin.setText(userid);
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	String Parkingid,Staffidin,Tokenid,Vehicletype,Vehiclenumber,Indate,Intime;
	 public void fetchDetails()
	  {      
		  
		     Parkingid = text_ParkingID.getText();
			 Staffidin = text_StaffIDin.getText();
			 Tokenid = text_TokenID.getText();
			 cmb=(String)cmbvehicle.getSelectedItem().toString();
			 Vehiclenumber = text_VehicleNumber.getText().strip();
			 	 
			 
			   Indate=text_InDate.getText();
			   Intime=text_InTime.getText();			 
			 tokenid();
		  }
	  
	  
	
	public void actionPerformed(ActionEvent e) {
		clock();
		fetchDetails();
		if(checkEmpty())
		{ 
			JOptionPane.showMessageDialog(this, "all  fields are compulsory");
		}
		else
			
		    {	
		
		
		
		      if(tokenid())
		    	{addDetails();
		
		        	}
		      else
		           {
			           JOptionPane.showMessageDialog(this, "A vehicle is parked with this id","ERROR",JOptionPane.ERROR_MESSAGE);
	               	}
		      }
	      }
	  public void addDetails() {
		   String strinsert = "insert into vehicledetails(parkingid,checkinstaffid,tokenid,vehicletype,vehiclenumber,indate,intime) values(?,?,?,?,?,?,?)";
		   
		try {
			   pswrite = con.prepareStatement(strinsert);
			   pswrite.setString(1, Parkingid);
			   pswrite.setString(2, Staffidin);
			   pswrite.setString(3, Tokenid);
			   pswrite.setString(4, cmb);
			   pswrite.setString(5, Vehiclenumber);
			   pswrite.setString(6, Indate);
			   pswrite.setString(7, Intime);
			   
			   
			   
			   int status = pswrite.executeUpdate();
			
			   if(status > 0)
			   {   
				   JOptionPane.showMessageDialog(this, "Information Added Successfully", "Submitted", JOptionPane.INFORMATION_MESSAGE);
				   update_token();
				   text_ParkingID.setText("");
					text_TokenID.setText("");
					cmbvehicle.setSelectedItem("");
					text_VehicleNumber.setText("");
					
					update_token();
					suggest();
					
				   get_parkingid();
			   }
			   
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 finally
		 {
			 if(pswrite!= null)
					try {
						pswrite.close();
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
				 
			 
			  }
		  
		  
		  }
		 
			
			
		
		 public boolean checkEmpty()
	     {
	  	  if(Parkingid.isEmpty()||Tokenid.isEmpty()||cmb.isEmpty()||Vehiclenumber.isEmpty())
	  		  
	  		  return true;
	  	  
	  	  return false;
	  	   
	  	 }
		 String stat=null;
		 int flag;
	
		 public boolean tokenid()
			{  
				try
				
				{String sql="select * from tokenid where idtokenid=?";
				
				psread = con.prepareStatement(sql);
				
				psread.setString(1, Tokenid);
				rsread=psread.executeQuery();
				
				while(rsread.next())
				{  
				    stat=rsread.getString(2);
					
					
					if(stat.equalsIgnoreCase("checkout"))
					{
						return true;
						
						
					}
					else
					{
						
						return false;
					}
					
				}
				
				}
				catch(SQLException se)
				{
					
				}
				return true;
				
				}
	int parking;
public void get_parkingid()
{try {
	String sql="select parkingid from vehicledetails ";
	psread=con.prepareStatement(sql);
	rsread=psread.executeQuery();
	while(rsread.next())
	{
		parking=rsread.getInt("parkingid");
	}
	String park=(parking+1)+"";
	text_ParkingID.setText(park);
}
catch(SQLException se)
{
	se.printStackTrace();
}
}
String cmb="";
private JLabel lbl_heading;
private JLabel lbl_background;
public void populateCombo()

{
	int flag=0;
	
	
	try {
		
		String str_read = "select vehicletype  from parking_charge";
		psread = con.prepareStatement(str_read);
		rsread = psread.executeQuery();

		while (rsread.next())		
		{
			flag=1;
		
			String vehiclesql=rsread.getString("vehicletype");
		
			cmbvehicle.addItem(vehiclesql);
		}
		if(flag==0)
		{
			JOptionPane.showMessageDialog(this, "No vehicle available yet");
			
			
		}
		
		
		

	} catch (SQLException se) {
		System.out.println(se);
	} finally {

		if (psread != null)
			try {
				psread.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (rsread != null)
			try {
				rsread.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
public void update_token()
{ try
{
	String sql="update tokenid set status='checkin' where idtokenid=?";
	psread=con.prepareStatement(sql);
	psread.setString(1, Tokenid);
	psread.executeUpdate();
	}
catch(SQLException se)
{
	se.printStackTrace();
}


}

@Override
public void keyPressed(KeyEvent e) {
    clock();
	int code=e.getKeyCode();
	if(code== 10)
	{ fetchDetails();
	if(checkEmpty())
	{ 
		JOptionPane.showMessageDialog(this, "all  fields are compulsory");
	}
	else
		
	    {	
	
	
	
	      if(tokenid())
	    	{addDetails();
	
	        	}
	      else
	           {
		           JOptionPane.showMessageDialog(this, "A vehicle is parked with this id","ERROR",JOptionPane.ERROR_MESSAGE);
               	}
	      }
	}









}

public void suggest()
{   try
{
	String token="select * from tokenid";
	psread=con.prepareStatement(token);
	rsread=psread.executeQuery();
	while(rsread.next())
	{   String stat=rsread.getString("status");
	    tok=rsread.getString("idtokenid");
		if(stat.equalsIgnoreCase("checkout"))
		{
			
			break;
		}
		if(tok=="100"&&stat=="checkin")
		{
			tok="FULL";
		}
	
	}
	if(tok!="FULL")
	{
		lbl_suggest.setText("suggested token : "+tok);
	}
	else lbl_suggest.setText("Parking : "+tok);
	
}
catch(SQLException se)
{
	
}
}
}


