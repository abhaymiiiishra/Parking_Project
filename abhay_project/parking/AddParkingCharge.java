package parking;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;

public class AddParkingCharge extends JFrame implements ActionListener,KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField text_chargehr;
	private JTextField text_weekends;
	private PreparedStatement ps,pscourse;
	private ResultSet rscourse;
	private JTextField text_weekdays;
	Connection con;
	JButton btn_add;
	String chargehr,weekend,weekday,vehicle;
	private JTextField text_vehicle;
	PreparedStatement psread;
	ResultSet rsread;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AddParkingCharge frame = new AddParkingCharge();
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
	public AddParkingCharge() {
		setTitle("Add New Vehicle");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddParkingCharge.class.getResource("/parking/images/icon_parking.png")));
	    con = DataBaseConnection.createConnection();
		GUI();
	}
public void GUI()
{
	
	setBounds(100, 100, 574, 531);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(70, 130, 180));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	 
	  
	  JLabel lbl_vehicle = new JLabel("VEHICLE");
	  lbl_vehicle.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
	  lbl_vehicle.setForeground(new Color(0, 250, 154));
	  lbl_vehicle.setBounds(50, 74, 126, 33);
	  contentPane.add(lbl_vehicle);
	  
	  JLabel lbl_chargehr = new JLabel("CHARGE/hr");
	  lbl_chargehr.setForeground(new Color(0, 250, 154));
	  lbl_chargehr.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
	  lbl_chargehr.setBounds(50, 136, 126, 33);
	  contentPane.add(lbl_chargehr);
	  
	  JLabel lbl_weekdays = new JLabel("WEEKDAYS");
	  lbl_weekdays.setForeground(new Color(0, 250, 154));
	  lbl_weekdays.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
	  lbl_weekdays.setBounds(50, 281, 126, 33);
	  contentPane.add(lbl_weekdays);
	  
	  text_chargehr = new JTextField();
	  text_chargehr.setForeground(new Color(0, 0, 0));
	  text_chargehr.setFont(new Font("Courier New", Font.BOLD, 20));
	  text_chargehr.setBounds(251, 137, 112, 33);
	  contentPane.add(text_chargehr);
	  text_chargehr.setColumns(10);
	  
	  text_weekends = new JTextField();
	  text_weekends.setForeground(new Color(0, 0, 0));
	  text_weekends.setFont(new Font("Courier New", Font.BOLD, 20));
	  text_weekends.setColumns(10);
	  text_weekends.setBounds(251, 341, 112, 33);
	  contentPane.add(text_weekends);
	  
	  btn_add = new JButton("ADD");
	  btn_add.setBackground(new Color(64, 224, 208));
	  btn_add.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
	  btn_add.setForeground(new Color(250, 128, 114));
	  btn_add.setBounds(149, 401, 112, 40);
	  btn_add.addActionListener(this);
	  btn_add.addKeyListener(this);
	  contentPane.add(btn_add);
	  
	  JLabel lbl_weekends = new JLabel("WEEKENDS");
	  lbl_weekends.setForeground(new Color(0, 250, 154));
	  lbl_weekends.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
	  lbl_weekends.setBounds(50, 340, 126, 33);
	  contentPane.add(lbl_weekends);
	  
	  JLabel lbl_full_day = new JLabel("CHARGES FOR A FULL DAY");
	  lbl_full_day.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
	  lbl_full_day.setForeground(Color.ORANGE);
	  lbl_full_day.setBounds(124, 240, 206, 32);
	  contentPane.add(lbl_full_day);
	  
	  text_weekdays = new JTextField();
	  text_weekdays.setForeground(new Color(0, 0, 0));
	  text_weekdays.setFont(new Font("Courier New", Font.BOLD, 20));
	  text_weekdays.setColumns(10);
	  text_weekdays.setBounds(251, 282, 112, 33);
	  contentPane.add(text_weekdays);
	  
	  text_vehicle = new JTextField();
	  text_vehicle.setForeground(new Color(0, 0, 0));
	  text_vehicle.setFont(new Font("Courier New", Font.BOLD, 20));
	  text_vehicle.setColumns(10);
	  text_vehicle.setBounds(251, 74, 112, 33);
	  contentPane.add(text_vehicle);
	  
	  JLabel lbl_heading = new JLabel("ADD NEW VEHICLE");
	  lbl_heading.setForeground(Color.ORANGE);
	  lbl_heading.setFont(new Font("Garamond", Font.BOLD, 24));
	  lbl_heading.setBounds(149, 11, 243, 32);
	  contentPane.add(lbl_heading);
	  
	  
	  setLocationRelativeTo(null);
}

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	
	int code=e.getKeyCode();
	if(code==10)
		{add();}
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void actionPerformed(ActionEvent e) {
	
		
	//getContentPane().add();
	add();
	
}
public void fetch()
{
	 vehicle=text_vehicle.getText();
	 weekend=text_weekends.getText();
	 chargehr=text_chargehr.getText();
	 
	 weekday=text_weekdays.getText();
}

public void add()
{   fetch();
    if(checkempty())
    {
    	JOptionPane.showMessageDialog(this, "all fields are compulsory","ERROR",JOptionPane.ERROR_MESSAGE);
    }
    
    else if(checkvehicle())
           {
    			JOptionPane.showMessageDialog(this, "This Vehicle is already present","ERROR",JOptionPane.ERROR_MESSAGE);
    	
           } 
    			else
    				{String sqlupdate="insert into parking_charge values (?,?,?,?)";
	
    				try {
    					psread = con.prepareStatement(sqlupdate);
    					System.out.println("hi");
    					psread.setString(1, vehicle);
    					psread.setString(2,chargehr);
    					psread.setString(3,weekday);
    					psread.setString(4,weekend);
		
    					System.out.println("heythere");
    					int status= psread.executeUpdate();
    					System.out.println("hello");
    					if(status>0) 	
    					{
	    
	   
	    
    						JOptionPane.showMessageDialog(this, "Vehicle Added");
    						text_vehicle.setText("");
    						text_chargehr.setText("");
    						text_weekends.setText("");
    						text_weekdays.setText("");
    					}
    				}
    				catch (SQLException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();}
    				finally {

    					if (pscourse != null)
    						try {
    							pscourse.close();
    						} catch (SQLException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    						}
    					if (rscourse != null)
    						try {
    							rscourse.close();
    						} catch (SQLException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    						}
    				}
    				}
}
public boolean  checkvehicle()
{
	String sqlvehicle="select vehicletype from parking_charge";
	  
	try {
			psread = con.prepareStatement(sqlvehicle);
			
			rsread = psread.executeQuery();
			
			while(rsread.next())
			{
				
				String vehicletype = rsread.getString("vehicletype");
				
			  if(vehicletype.equalsIgnoreCase(vehicle))
			  {
				  return true;
				  
			 }
			  
			  
			}
		   return false;
			
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
		  return false;
		  
	  }
	  
	  public boolean checkempty()
	  {
		  if(vehicle.isBlank()||weekday.isBlank()||weekend.isBlank()||chargehr.isBlank())
		  {
			  
			  return true;
		  }
		  return false;
	  }
}




