package parking;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import javax.swing.JScrollBar;
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

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Vehicle_Details extends JFrame implements ActionListener,WindowListener,KeyListener
{

	private JPanel contentPane;
	private JTextField text_ParkingID;
	private JTextField text_StaffidIN;
	private JTextField text_Token;
	private JTextField text_VehicleType;
	private JTextField text_VehicleNO;
	private JTextField text_InDate;
	private JTextField text_InTime;
	private JTextField text_StaffIDout;
	private JTextField text_OutDate;
	private JTextField text_OutTime;
	private JTextField text_Cost;
	private JTextField text_Hour;
	private JTextField text_Status;
	private Connection con;
	PreparedStatement psread;
	ResultSet rsread;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Vehicle_Details frame = new Vehicle_Details();
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
	public Vehicle_Details() {
		setTitle("Vehicle Details");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Vehicle_Details.class.getResource("/parking/images/icon_parking.png")));
		con = DataBaseConnection.createConnection();
		
		GUI();
		
	}
	public void GUI() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 623);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(192, 192, 192));
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_parkingID = new JLabel("PARKING ID");
		lbl_parkingID.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lbl_parkingID.setForeground(new Color(0, 250, 154));
		lbl_parkingID.setBounds(57, 61, 121, 29);
		contentPane.add(lbl_parkingID);
		
		JLabel lbl_checkinStaffID = new JLabel("STAFF ID(in)");
		lbl_checkinStaffID.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lbl_checkinStaffID.setForeground(new Color(0, 250, 154));
		lbl_checkinStaffID.setBounds(57, 101, 121, 29);
		contentPane.add(lbl_checkinStaffID);
		
		JLabel lbl_TokenID = new JLabel("TOKEN ID");
		lbl_TokenID.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lbl_TokenID.setForeground(new Color(0, 250, 154));
		lbl_TokenID.setBounds(57, 141, 121, 29);
		contentPane.add(lbl_TokenID);
		
		JLabel lbl_VehicleType = new JLabel("VEHICLE TYPE");
		lbl_VehicleType.setForeground(new Color(0, 250, 154));
		lbl_VehicleType.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lbl_VehicleType.setBounds(57, 181, 121, 33);
		contentPane.add(lbl_VehicleType);
		
		JLabel lbl_VehicleNO = new JLabel("VEHICLE NO.");
		lbl_VehicleNO.setForeground(new Color(0, 250, 154));
		lbl_VehicleNO.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lbl_VehicleNO.setBounds(57, 225, 121, 29);
		contentPane.add(lbl_VehicleNO);
		
		JLabel lbl_INDate = new JLabel("IN DATE");
		lbl_INDate.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lbl_INDate.setForeground(new Color(0, 250, 154));
		lbl_INDate.setBounds(57, 265, 121, 27);
		contentPane.add(lbl_INDate);
		
		JLabel lbl_INTime = new JLabel("IN TIME");
		lbl_INTime.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lbl_INTime.setForeground(new Color(0, 250, 154));
		lbl_INTime.setBounds(57, 303, 121, 27);
		contentPane.add(lbl_INTime);
		
		JLabel lbl_checkoutStaffID = new JLabel("STAFF ID(out)");
		lbl_checkoutStaffID.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lbl_checkoutStaffID.setForeground(new Color(0, 250, 154));
		lbl_checkoutStaffID.setBounds(57, 341, 121, 29);
		contentPane.add(lbl_checkoutStaffID);
		
		JLabel lbl_outDate = new JLabel("OUT DATE");
		lbl_outDate.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lbl_outDate.setForeground(new Color(0, 250, 154));
		lbl_outDate.setBounds(57, 381, 121, 27);
		contentPane.add(lbl_outDate);
		
		JLabel lbl_outTime = new JLabel("OUT TIME");
		lbl_outTime.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lbl_outTime.setForeground(new Color(0, 250, 154));
		lbl_outTime.setBounds(57, 419, 121, 27);
		contentPane.add(lbl_outTime);
		
		JLabel lbl_cost = new JLabel("COST");
		lbl_cost.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lbl_cost.setForeground(new Color(0, 250, 154));
		lbl_cost.setBounds(57, 457, 121, 30);
		contentPane.add(lbl_cost);
		
		JLabel lbl_hour = new JLabel("HOUR");
		lbl_hour.setForeground(new Color(0, 250, 154));
		lbl_hour.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lbl_hour.setBounds(57, 498, 121, 29);
		contentPane.add(lbl_hour);
		
		JLabel lbl_status = new JLabel("STATUS");
		lbl_status.setForeground(new Color(0, 250, 154));
		lbl_status.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lbl_status.setBounds(57, 538, 121, 29);
		contentPane.add(lbl_status);
		
		text_ParkingID = new JTextField();
		text_ParkingID.setForeground(new Color(0, 0, 0));
		text_ParkingID.setFont(new Font("Courier New", Font.BOLD, 18));
		text_ParkingID.setBounds(188, 61, 173, 29);
		text_ParkingID.setColumns(6);
		contentPane.add(text_ParkingID);
		
		
		text_StaffidIN = new JTextField();
		text_StaffidIN.setEditable(false);
		text_StaffidIN.setColumns(10);
		text_StaffidIN.setForeground(new Color(0, 0, 0));
		text_StaffidIN.setFont(new Font("Courier New", Font.BOLD, 18));
		text_StaffidIN.setBounds(188, 104, 173, 29);
		contentPane.add(text_StaffidIN);
		
		text_Token = new JTextField();
		text_Token.setEditable(false);
		text_Token.setColumns(10);
		text_Token.setForeground(new Color(0, 0, 0));
		text_Token.setFont(new Font("Courier New", Font.BOLD, 18));
		text_Token.setBounds(188, 144, 173, 29);
		contentPane.add(text_Token);
		
		text_VehicleType = new JTextField();
		text_VehicleType.setEditable(false);
		text_VehicleType.setColumns(10);
		text_VehicleType.setForeground(new Color(0, 0, 0));
		text_VehicleType.setFont(new Font("Courier New", Font.BOLD, 18));
		text_VehicleType.setBounds(188, 186, 173, 29);
		contentPane.add(text_VehicleType);
		
		text_VehicleNO = new JTextField();
		text_VehicleNO.setEditable(false);
		text_VehicleNO.setColumns(10);
		text_VehicleNO.setForeground(new Color(0, 0, 0));
		text_VehicleNO.setFont(new Font("Courier New", Font.BOLD, 18));
		text_VehicleNO.setBounds(188, 228, 173, 29);
		contentPane.add(text_VehicleNO);
		
		text_InDate = new JTextField();
		text_InDate.setEditable(false);
		text_InDate.setColumns(10);
		text_InDate.setForeground(new Color(0, 0, 0));
		text_InDate.setFont(new Font("Courier New", Font.BOLD, 18));
		text_InDate.setBounds(188, 267, 173, 29);
		contentPane.add(text_InDate);
		
		text_InTime = new JTextField();
		text_InTime.setEditable(false);
		text_InTime.setColumns(10);
		text_InTime.setForeground(new Color(0, 0, 0));
		text_InTime.setFont(new Font("Courier New", Font.BOLD, 18));
		text_InTime.setBounds(188, 305, 173, 29);
		contentPane.add(text_InTime);
		
		text_StaffIDout = new JTextField();
		text_StaffIDout.setEditable(false);
		text_StaffIDout.setColumns(10);
		text_StaffIDout.setForeground(new Color(0, 0, 0));
		text_StaffIDout.setFont(new Font("Courier New", Font.BOLD, 18));
		text_StaffIDout.setBounds(188, 344, 173, 29);
		contentPane.add(text_StaffIDout);
		
		text_OutDate = new JTextField();
		text_OutDate.setEditable(false);
		text_OutDate.setColumns(10);
		text_OutDate.setForeground(new Color(0, 0, 0));
		text_OutDate.setBounds(188, 383, 173, 29);
		text_OutDate.setFont(new Font("Courier New", Font.BOLD, 18));
		contentPane.add(text_OutDate);
		
		text_OutTime = new JTextField();
		text_OutTime.setEditable(false);
		text_OutTime.setColumns(10);
		text_OutTime.setForeground(new Color(0, 0, 0));
		text_OutTime.setFont(new Font("Courier New", Font.BOLD, 18));
		text_OutTime.setBounds(188, 421, 173, 29);
		contentPane.add(text_OutTime);
		
		text_Cost = new JTextField();
		text_Cost.setEditable(false);
		text_Cost.setColumns(10);
		text_Cost.setForeground(new Color(0, 0, 0));
		text_Cost.setFont(new Font("Courier New", Font.BOLD, 18));
		text_Cost.setBounds(188, 461, 173, 29);
		contentPane.add(text_Cost);
		
		text_Hour = new JTextField();
		text_Hour.setEditable(false);
		text_Hour.setColumns(10);
		text_Hour.setForeground(new Color(0, 0, 0));
		text_Hour.setFont(new Font("Courier New", Font.BOLD, 18));
		text_Hour.setBounds(188, 501, 173, 29);
		contentPane.add(text_Hour);
		
		text_Status = new JTextField();
		text_Status.setEditable(false);
		text_Status.setColumns(10);
		text_Status.setForeground(new Color(0, 0, 0));
		text_Status.setFont(new Font("Courier New", Font.BOLD, 18));
		text_Status.setBounds(188, 541, 173, 29);
		contentPane.add(text_Status);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.setBackground(new Color(65, 105, 225));
		btnNewButton.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		btnNewButton.setForeground(new Color(64, 224, 208));
		btnNewButton.setBounds(390, 61, 114, 29);
		btnNewButton.addActionListener(this);
		btnNewButton.addKeyListener(this);
		contentPane.add(btnNewButton);
		
		JLabel lbl_VehicleDetails = new JLabel("VEHICLE DETAILS");
		lbl_VehicleDetails.setForeground(new Color(255, 165, 0));
		lbl_VehicleDetails.setFont(new Font("Garamond", Font.BOLD, 31));
		lbl_VehicleDetails.setBounds(152, 22, 288, 29);
		contentPane.add(lbl_VehicleDetails);	
		
		
		
		setLocationRelativeTo(null);
	}
	 String parkingID;
	 public void fetchDetails()
	   {
		   
		   parkingID = text_ParkingID.getText();
		   
	   }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code=e.getKeyCode();
		
		if(code==10)
		{searchDetails();}
		
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
		AdminDashboard frame=new AdminDashboard();
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
		searchDetails();
	}
	public void searchDetails()
	{
	    	 
		
		try 
		  {
			  fetchDetails();
			  String str_read = "select * from vehicledetails where parkingid=?";
			  psread = con.prepareStatement(str_read);
			  psread.setString(1, parkingID);
			  rsread = psread.executeQuery();
			  int flag = 0;
			 while(rsread.next())
			  {
				  
				  String ParkID =rsread.getString("parkingid");
				  if(ParkID.equals(parkingID))
				  {
					flag = 1; 
					break;
				  }
				  
			  }
			 
			 if(flag == 1)
			 {
			  text_ParkingID.setText(rsread.getString("parkingid"));
			  text_StaffidIN.setText(rsread.getString("checkinstaffid"));
			  text_Token.setText(rsread.getString("tokenid"));
			  text_VehicleType.setText(rsread.getString("vehicletype"));
			  text_VehicleNO.setText(rsread.getString("vehiclenumber"));
			  text_InDate.setText(rsread.getString("indate"));
			  text_InTime.setText(rsread.getString("intime"));
			  text_StaffIDout.setText(rsread.getString("checkoutstaffid"));
			  text_OutDate.setText(rsread.getString("outdate"));
			  text_OutTime.setText(rsread.getString("outtime"));
			  text_Cost.setText(rsread.getString("charge"));
			  text_Hour.setText(rsread.getString("time"));
			  text_Status.setText(rsread.getString("status"));
			 
			  
			  }
			 else
				 JOptionPane.showMessageDialog(this,"No such Parking ID. exist", "Error", JOptionPane.ERROR_MESSAGE);
		
		  
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
	
}
