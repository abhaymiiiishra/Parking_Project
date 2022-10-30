package parking;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.text.NumberFormatter;

import parking.DataBaseConnection;
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
import java.text.NumberFormat;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

import javax.swing.ButtonGroup;
//import javax.swing.ImageIcon;

public class NewStaff extends JFrame implements ActionListener,WindowListener,KeyListener
{

	/**
	 * 
	 */
	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_name;
	private JTextField txt_staffid;
	private JTextField txt_emailid;
	private JTextField txt_phoneno;
	private JTextArea txtarea_address;
	private JRadioButton rd_btn_male,rd_btn_female;
	JCheckBox []language = new JCheckBox[3];
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Connection con;
	private PreparedStatement pswrite,psread;
	private ResultSet rsread;
	String password;
	JRadioButton rdbtn_entry;
	JRadioButton rdbtn_exit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewStaff frame = new NewStaff();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewStaff() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(NewStaff.class.getResource("/parking/images/icon_parking.png")));
		con = DataBaseConnection.createConnection();
		this.addWindowListener(this);
		createGui();
		
	}

	
	public void createGui()
	{
		setBackground(Color.WHITE);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Staff Enrollment");
		
	    setBounds(100, 100, 769, 770);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new LineBorder(new Color(34, 139, 34), 0, true));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_staff_enrollment = new JLabel("Staff Enrollment");
		lbl_staff_enrollment.setForeground(new Color(255, 165, 0));
		lbl_staff_enrollment.setFont(new Font("Garamond", Font.BOLD, 33));
		lbl_staff_enrollment.setBounds(262, 10, 260, 55);
		contentPane.add(lbl_staff_enrollment);
		
		JLabel lbl_name = new JLabel("Name");
		lbl_name.setForeground(new Color(0, 255, 127));
		lbl_name.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		lbl_name.setBounds(66, 173, 62, 33);
		contentPane.add(lbl_name);
		
		txt_name = new JTextField();
		txt_name.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_name.setForeground(new Color(0, 0, 0));
		txt_name.setBackground(new Color(255, 255, 255));
		txt_name.setFont(new Font("Courier New", Font.BOLD, 18));
		txt_name.setBounds(214, 171, 300, 38);
		contentPane.add(txt_name);
		txt_name.setColumns(20);
		
		JLabel lbl_staffid = new JLabel("Staff ID");
		lbl_staffid.setForeground(new Color(0, 255, 127));
		lbl_staffid.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		lbl_staffid.setBounds(66, 109, 96, 25);
		contentPane.add(lbl_staffid);
		
		txt_staffid = new JTextField();
		txt_staffid.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_staffid.setForeground(new Color(0, 0, 0));
		txt_staffid.setFont(new Font("Courier New", Font.BOLD, 18));
		txt_staffid.setBounds(214, 103, 300, 38);
		contentPane.add(txt_staffid);
		txt_staffid.setColumns(10);
		
		JLabel lbl_email = new JLabel("Email Id.");
		lbl_email.setForeground(new Color(0, 255, 127));
		lbl_email.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		lbl_email.setBounds(66, 233, 96, 33);
		contentPane.add(lbl_email);
		
		txt_emailid = new JTextField();
		txt_emailid.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_emailid.setForeground(new Color(0, 0, 0));
		txt_emailid.setFont(new Font("Courier New", Font.BOLD, 18));
		txt_emailid.setBounds(214, 231, 300, 38);
		contentPane.add(txt_emailid);
		txt_emailid.setColumns(20);
		
		JLabel lbl_phoneno = new JLabel("Phone No.");
		lbl_phoneno.setForeground(new Color(0, 255, 127));
		lbl_phoneno.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		lbl_phoneno.setBounds(66, 300, 107, 33);
		contentPane.add(lbl_phoneno);
		
		txt_phoneno = new JTextField();
		txt_phoneno.setBorder(new LineBorder(new Color(0, 0, 0)));
		txt_phoneno.setForeground(new Color(0, 0, 0));
		txt_phoneno.setFont(new Font("Courier New", Font.BOLD, 18));
		txt_phoneno.setBounds(214, 298, 300, 38);
		contentPane.add(txt_phoneno);
		txt_phoneno.setColumns(10);
		
		JLabel lbl_gender = new JLabel("Gender");
		lbl_gender.setForeground(new Color(0, 255, 127));
		lbl_gender.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		lbl_gender.setBounds(66, 374, 116, 39);
		contentPane.add(lbl_gender);
		
		rd_btn_male = new JRadioButton("Male");
		buttonGroup.add(rd_btn_male);
		rd_btn_male.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		rd_btn_male.setBounds(214, 377, 103, 33);
		contentPane.add(rd_btn_male);
		
		rd_btn_female = new JRadioButton("Female");
		buttonGroup.add(rd_btn_female);
		rd_btn_female.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		rd_btn_female.setBounds(410, 377, 103, 33);
		contentPane.add(rd_btn_female);
		
		JLabel lbl_address = new JLabel("Address");
		lbl_address.setForeground(new Color(0, 255, 127));
		lbl_address.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		lbl_address.setBounds(66, 458, 107, 25);
		contentPane.add(lbl_address);
		
	    txtarea_address = new JTextArea();
		txtarea_address.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtarea_address.setForeground(new Color(0, 0, 0));
		txtarea_address.setFont(new Font("Courier New", Font.BOLD, 18));
		txtarea_address.setBounds(214, 431, 300, 76);
		contentPane.add(txtarea_address);
		
		JButton btn_submit = new JButton("SUBMIT");
		btn_submit.setForeground(new Color(255, 250, 250));
		btn_submit.setBackground(new Color(169, 169, 169));
		btn_submit.setFont(new Font("Segoe UI Semibold", Font.BOLD, 25));
		btn_submit.setBounds(226, 671, 163, 33);
		btn_submit.addActionListener(this);
		btn_submit.addKeyListener(this);
		contentPane.add(btn_submit);
		
		JLabel lblNewLabel = new JLabel("");
		//lblNewLabel.setIcon(new ImageIcon(NewStaff.class.getResource("/com/images/user.png")));
		lblNewLabel.setBounds(581, 322, 50, 48);
		contentPane.add(lblNewLabel);
		
		txt_password = new JTextField();
		txt_password.setFont(new Font("Courier New", Font.BOLD, 18));
		txt_password.setForeground(new Color(244, 164, 96));
		txt_password.setBounds(214, 559, 209, 33);
		contentPane.add(txt_password);
		txt_password.setColumns(10);
		
		JLabel lbl_password = new JLabel("PASSWORD");
		lbl_password.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lbl_password.setForeground(new Color(0, 250, 154));
		lbl_password.setBounds(66, 559, 96, 33);
		contentPane.add(lbl_password);
		
		rdbtn_entry = new JRadioButton("ENTRY");
		buttonGroup_1.add(rdbtn_entry);
		rdbtn_entry.setBounds(214, 608, 74, 23);
		contentPane.add(rdbtn_entry);
		
		rdbtn_exit = new JRadioButton("EXIT");
		buttonGroup_1.add(rdbtn_exit);
		rdbtn_exit.setBounds(311, 608, 84, 23);
		contentPane.add(rdbtn_exit);
		
		rdbtn_admin = new JRadioButton("ADMIN");
		buttonGroup_1.add(rdbtn_admin);
		rdbtn_admin.setBounds(410, 608, 84, 23);
		contentPane.add(rdbtn_admin);
		//populateCombo();
		
		setLocationRelativeTo(null);
	}

       
  String name,staffid,email,phoneno,address,gender="",type="";
  private JTextField txt_password;
  private final ButtonGroup buttonGroup_1 = new ButtonGroup();
  private JRadioButton rdbtn_admin;
  
 
  
  public boolean checkStaffId()
  {
	  String strcheck = "select staffid from staffdetails";
	  
	  try {
		psread = con.prepareStatement(strcheck);
		
		rsread = psread.executeQuery();
		
		while(rsread.next())
		{
			
			String Staffid = rsread.getString("staffid");
			
		  if(staffid.equalsIgnoreCase(Staffid))
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
  
  
  
  
 
  
  public void fetchDetails()
  {
	  
	     name = txt_name.getText();
		 staffid = txt_staffid.getText();
		 email = txt_emailid.getText();
		 phoneno = txt_phoneno.getText();
		 address = txtarea_address.getText();
		 password=txt_password.getText();
		
		 if(rd_btn_male.isSelected())
		    gender = "Male";
		
		if(rd_btn_female.isSelected())
			gender = "Female";
		 if(rdbtn_admin.isSelected())
			 type="Admin";
		 if(rdbtn_entry.isSelected())
			 type="staff-entry";
		 if(rdbtn_exit.isSelected())
			 type="staff-exit";
		
	  }

	public void actionPerformed(ActionEvent ae) 
	{
		
		fetchDetails();	
		
		if(checkEmpty())
		{
		
			JOptionPane.showMessageDialog(this,"All fields are mandatory", "Error", JOptionPane.ERROR_MESSAGE);	
			
		}	
		
		else
		{
			System.out.println("The Name is :"+name);
			System.out.println("The Staff id is :"+staffid);
			System.out.println("The Email Id is :"+email);
			System.out.println("The Phone No. is :"+phoneno);
			System.out.println("The Adddress is :"+address);
			System.out.println("The Gender is :"+gender);
			System.out.println("type is :"+type);
			
			if(checkStaffId())
			{
				JOptionPane.showMessageDialog(this, "Staff Id already exist", "Error", JOptionPane.ERROR_MESSAGE);
				txt_staffid.grabFocus();
				txt_staffid.selectAll();
				
				
			}
			else
				addDetails();
			
			
		}
		
		
	}
	
	
	
	    public void addDetails() {
	   String strinsert = "insert into staffdetails values(?,?,?,?,?,?)";
	   try {
		
		   pswrite = con.prepareStatement(strinsert);
		   pswrite.setString(1, staffid);
		   pswrite.setString(2, name);
		   pswrite.setString(3, email);
		   pswrite.setString(4, gender);
		   pswrite.setString(5, phoneno);
		   pswrite.setString(6, address);
		   
		   
		   
		   int status = pswrite.executeUpdate();
		   setpass();
		
		   if(status > 0)
		   {
			   JOptionPane.showMessageDialog(this, "Information Added Successfully", "Submitted", JOptionPane.INFORMATION_MESSAGE);
			   txt_staffid.setText("");
			    txt_name.setText("");
				txt_emailid.setText("");
				txt_phoneno.setText("");
				buttonGroup.clearSelection();
				buttonGroup_1.clearSelection();
				txtarea_address.setText("");
				txt_password.setText("");
				
			   
			   
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
	 
		
		
	
	 public boolean checkEmpty()
     {
  	  if(name.isEmpty()||staffid.isEmpty()||phoneno.isEmpty()||address.isEmpty()||gender.isEmpty()||password.isEmpty()||type.isBlank())
  		  
  		  return true;
  	  
  	  return false;
  	   
  	 }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int check = e.getKeyCode();
		if(check==10)
		{
			fetchDetails();	
			
			if(checkEmpty())
			{
			
				JOptionPane.showMessageDialog(this,"All fields are mandatory", "Error", JOptionPane.ERROR_MESSAGE);	
				
			}	
			
			else
			{
				System.out.println("The Name is :"+name);
				System.out.println("The staff id is :"+staffid);
				System.out.println("The Email Id is :"+email);
				System.out.println("The Phone No. is :"+phoneno);
				System.out.println("The Adddress is :"+address);
				System.out.println("The Gender is :"+gender);
				
				
				if(checkStaffId())
				{
					
					JOptionPane.showMessageDialog(this, "Staff Id already exist", "Error", JOptionPane.ERROR_MESSAGE);
					txt_staffid.grabFocus();
					txt_staffid.selectAll();
				
				}
				else
					addDetails();
				
			}
			
			
			
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
	public void setpass()
	{
		String pass=txt_password.getText();
		String strpass="insert into login values(?,?,?)";
		try
		{
			pswrite=con.prepareStatement(strpass);
			pswrite.setString(1, staffid);
			pswrite.setString(2, pass);
			pswrite.setString(3, type);
			pswrite.executeUpdate();
		}
		catch(SQLException ae)
		{
			ae.printStackTrace();
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
}

