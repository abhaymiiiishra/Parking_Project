package parking;

//import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import parking.DataBaseConnection;
import java.awt.Toolkit;

public class view_staff extends JFrame implements ActionListener,WindowListener,KeyListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_staffid;
	private JTextField txt_name;
	private JTextField txt_phoneno;
	private JTextField txt_email;
	private JTextField txt_gender;
	private JTextArea txt_area_address;
	
	private Connection con;
	private PreparedStatement psread;
	private ResultSet rsread;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					view_staff frame = new view_staff();
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
	public view_staff() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(view_staff.class.getResource("/parking/images/icon_parking.png")));
		
		con = DataBaseConnection.createConnection();
		System.out.println("con");
		
		createGui();

	}
	
	
	public void createGui()
	{
		
		setTitle("Staff Details");
		
		setLocationRelativeTo(null);
		setBounds(100, 100, 837, 767);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_viewStaff = new JLabel("Staff Details");
		lbl_viewStaff.setForeground(new Color(255, 165, 0));
		lbl_viewStaff.setFont(new Font("Garamond", Font.BOLD, 33));
		lbl_viewStaff.setBounds(289, 23, 221, 47);
		contentPane.add(lbl_viewStaff);
		
		JLabel lbl_staffid = new JLabel("Staff ID");
		lbl_staffid.setForeground(new Color(0, 255, 0));
		lbl_staffid.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		lbl_staffid.setBounds(73, 114, 160, 33);
		contentPane.add(lbl_staffid);
		
		txt_staffid = new JTextField();
		txt_staffid.setForeground(new Color(0, 0, 0));
		txt_staffid.setFont(new Font("Courier New", Font.BOLD, 18));
		txt_staffid.setBounds(256, 113, 254, 33);
		contentPane.add(txt_staffid);
		txt_staffid.setColumns(10);
		
		JButton btn_search = new JButton("Search");
		btn_search.setBackground(new Color(64, 224, 208));
		btn_search.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 33));
		btn_search.setBounds(563, 107, 147, 42);
		btn_search.addActionListener(this);
		btn_search.addKeyListener(this);
		contentPane.add(btn_search);
		
		JLabel lbl_name = new JLabel("Name");
		lbl_name.setForeground(new Color(0, 255, 0));
		lbl_name.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		lbl_name.setBounds(73, 195, 105, 33);
		contentPane.add(lbl_name);
		
		txt_name = new JTextField();
		txt_name.setForeground(new Color(0, 0, 0));
		txt_name.setFont(new Font("Courier New", Font.BOLD, 18));
		txt_name.setEditable(false);
		txt_name.setBounds(256, 194, 254, 33);
		contentPane.add(txt_name);
		txt_name.setColumns(10);
		
		JLabel lbl_phoneo = new JLabel("Phone No.");
		lbl_phoneo.setForeground(new Color(0, 255, 0));
		lbl_phoneo.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		lbl_phoneo.setBounds(73, 286, 105, 25);
		contentPane.add(lbl_phoneo);
		
		txt_phoneno = new JTextField();
		txt_phoneno.setForeground(new Color(0, 0, 0));
		txt_phoneno.setEditable(false);
		txt_phoneno.setFont(new Font("Courier New", Font.BOLD, 18));
		txt_phoneno.setBounds(256, 274, 254, 33);
		contentPane.add(txt_phoneno);
		txt_phoneno.setColumns(10);
		
		JLabel lbl_email = new JLabel("Email ID");
		lbl_email.setForeground(new Color(0, 255, 0));
		lbl_email.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		lbl_email.setBounds(73, 354, 105, 25);
		contentPane.add(lbl_email);
		
		txt_email = new JTextField();
		txt_email.setForeground(new Color(0, 0, 0));
		txt_email.setFont(new Font("Courier New", Font.BOLD, 18));
		txt_email.setEditable(false);
		txt_email.setBounds(256, 349, 254, 33);
		contentPane.add(txt_email);
		txt_email.setColumns(10);
		
		JLabel lbl_address = new JLabel("Address");
		lbl_address.setForeground(new Color(0, 255, 0));
		lbl_address.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		lbl_address.setBounds(73, 427, 105, 25);
		contentPane.add(lbl_address);
		
		txt_area_address = new JTextArea();
		txt_area_address.setForeground(new Color(0, 0, 0));
		txt_area_address.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_area_address.setFont(new Font("Courier New", Font.BOLD, 18));
		txt_area_address.setEditable(false);
		txt_area_address.setBounds(256, 408, 254, 57);
		contentPane.add(txt_area_address);
		
		JLabel lbl_gender = new JLabel("Gender");
		lbl_gender.setForeground(new Color(0, 255, 0));
		lbl_gender.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		lbl_gender.setBounds(73, 516, 87, 25);
		contentPane.add(lbl_gender);
		
		txt_gender = new JTextField();
		txt_gender.setForeground(new Color(0, 0, 0));
		txt_gender.setFont(new Font("Courier New", Font.BOLD, 18));
		txt_gender.setEditable(false);
		txt_gender.setBounds(256, 504, 254, 33);
		contentPane.add(txt_gender);
		txt_gender.setColumns(10);
		
		
		
		setLocationRelativeTo(null);
		
		
	}

	String StaffId;
	String caption;
	
   public void fetchDetails()
   {
	   
	   StaffId = txt_staffid.getText();
	   
   }

	public void actionPerformed(ActionEvent ae) 
	{
		caption = ae.getActionCommand();
		fetchDetails();
		
		if(caption.equals("Search"))
		{
		     searchDetails();
			
			
		}
		
		
		
		
		
		
		
	}
	
	public void searchDetails()
	{
	    	 
		  try 
		  {
			  
			  String str_read = "select * from parking.staffdetails where StaffId=?;";
			  psread = con.prepareStatement(str_read);
			  psread.setString(1, StaffId);
			  rsread = psread.executeQuery();
			  int flag = 0;
			 while(rsread.next())
			  {
				  
				  String StaffId =rsread.getString("StaffId");
				  if(StaffId.equals(StaffId))
				  {
					flag = 1; 
					break;
				  }
				  
			  }
			 
			 if(flag == 1)
			 {
			  txt_name.setText(rsread.getString("name"));
			  txt_phoneno.setText(rsread.getString("phone"));
			  txt_email.setText(rsread.getString("email"));
			  txt_gender.setText(rsread.getString("gender"));
			  txt_area_address.setText(rsread.getString("address"));
			  
			 
			  
			  }
			 else
				 JOptionPane.showMessageDialog(this,"No such Staff Id. exist", "Error", JOptionPane.ERROR_MESSAGE);
		
		  
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
	
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		
		int check = e.getKeyCode();	
			
			if(check == 10)
			{	
			
			
			   searchDetails();
				
				
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
		
		Listener.windowClosing(con);
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
	
	
	
}
