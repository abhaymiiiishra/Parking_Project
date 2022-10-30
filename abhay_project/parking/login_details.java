package parking;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;

//import com.pms.Listener;
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


import javax.swing.JTextField;
import javax.swing.JButton;
//import javax.swing.JComboBox;
import javax.swing.JPasswordField;

import java.sql.*;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
//import java.awt.SystemColor;

public class login_details extends JFrame implements ActionListener, WindowListener, KeyListener

{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_username;
	private JButton btn_submit;
	private static login_details frame;
	
	private Connection  con;
	private PreparedStatement ps;
	private ResultSet rs;
	static String usertype;
	static String username;
	
	
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					  login_details frame = new login_details();
					
					  frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public login_details() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(login_details.class.getResource("/parking/images/m-design-logo-09A5D82F03-seeklogo.com.png")));
		setTitle("mishra PARKING");
		
		
		
		con=DataBaseConnection.createConnection();

		createGui();
		

		this.addWindowListener(this);

	}

	public void createGui() {
		{
			setResizable(false);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 660, 596);
			setLocationRelativeTo(null);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(70, 130, 180));
			contentPane.setBorder(new LineBorder(new Color(128, 128, 0), 0));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			txt_username = new JTextField();
			txt_username.setBorder(new LineBorder(new Color(171, 173, 179), 0, true));
			txt_username.setBackground(new Color(255, 255, 255));
			txt_username.setFont(new Font("Courier New", Font.BOLD, 25));
			txt_username.setBounds(269, 184, 225, 38);
			contentPane.add(txt_username);
			txt_username.setColumns(20);

			btn_submit = new JButton("LOGIN");
			btn_submit.setBackground(new Color(0, 255, 255));
			btn_submit.setIcon(null);
			btn_submit.setFont(new Font("Agency FB", Font.BOLD, 30));
			btn_submit.setBounds(269, 382, 126, 38);
			btn_submit.addActionListener(this);
			btn_submit.addKeyListener(this);
			contentPane.add(btn_submit);
			
			pwd_password = new JPasswordField();
			
			pwd_password.setBackground(new Color(255, 255, 255));
			pwd_password.setBorder(new LineBorder(new Color(171, 173, 179), 0, true));
			pwd_password.setFont(new Font("Courier New", Font.BOLD, 20));
			pwd_password.setEchoChar('*');
			
			pwd_password.setColumns(20);
			pwd_password.setBounds(269, 272, 225, 38);
			contentPane.add(pwd_password);
			
			JLabel lbl_username = new JLabel("Username");
			lbl_username.setForeground(new Color(0, 250, 154));
			lbl_username.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
			lbl_username.setBounds(94, 184, 132, 27);
			contentPane.add(lbl_username);
			
			JLabel lbl_password = new JLabel("Password");
			lbl_password.setForeground(new Color(0, 250, 154));
			lbl_password.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
			lbl_password.setBounds(94, 270, 108, 34);
			contentPane.add(lbl_password);
			
			JLabel lbl_mishra = new JLabel("mishra");
			lbl_mishra.setHorizontalAlignment(SwingConstants.LEFT);
			lbl_mishra.setFont(new Font("Mistral", Font.PLAIN, 40));
			lbl_mishra.setBounds(234, 52, 97, 38);
			contentPane.add(lbl_mishra);
			
			JLabel lblimage = new JLabel("");
			lblimage.setIcon(new ImageIcon(login_details.class.getResource("/parking/images/76-512.png")));
			lblimage.setBounds(-42, 270, 437, 346);
			contentPane.add(lblimage);
			
			JLabel lblparking = new JLabel("PARKING");
			lblparking.setFont(new Font("Consolas", Font.PLAIN, 38));
			lblparking.setHorizontalAlignment(SwingConstants.LEFT);
			lblparking.setBounds(344, 52, 172, 41);
			contentPane.add(lblparking);
			
			JLabel lbl_icon = new JLabel("New label");
			lbl_icon.setIcon(new ImageIcon(login_details.class.getResource("/parking/images/icon_parking.png")));
			lbl_icon.setBounds(21, 22, 108, 100);
			contentPane.add(lbl_icon);
			
			
			setLocationRelativeTo(null);
		}

	}

	
	
	private String password;
	private String caption;
	 char[] pwd;
	private JPasswordField pwd_password;
	
	
	
	
		
	String pass;
	
	public void fetchData(String username)
	{
		
		
		try {
			
			
			String strsql=  "select * from login where id=?";
			
			ps = con.prepareStatement(strsql);
			ps.setString(1,username);
		    rs =	ps.executeQuery();
				
		    if(rs.next())
				{
					pass = rs.getString("password");
					usertype = rs.getString("type");
					
						
							
				}
		    else
		    {
		    	JOptionPane.showMessageDialog(this, "no user found with this userid","ERROR",JOptionPane.ERROR_MESSAGE);
		    }
					
			
		}
			
		catch(SQLException se)
		{
			
			
			System.out.println(se);
		}
	
	
		
				
	
	
		
	}
	
	
	
	
	

	public void actionPerformed(ActionEvent e) 
	{
		caption = e.getActionCommand();
		
		username = txt_username.getText();
		pwd = pwd_password.getPassword();
		
		password = String.valueOf(pwd);
		
		
       
		if(caption.contentEquals("LOGIN")) 
		{
 
		   if( checkEmpty())
		   {
		   System.out.println("All fields are mandatory");
		   }

		 
		
		else
		
		{

			System.out.println("The username is " + username);
			System.out.println("The password is " + password);
		    credentials();

		}
		}
	}
	
	
	
	public void credentials() 
	{
          
          fetchData(username);
		  if(password.contentEquals(pass) )
		  {
				
				 
			  if(usertype.equalsIgnoreCase("admin"))
			  {  
				  AdminDashboard frame1= new AdminDashboard();
				  frame1.setVisible(true);
					 frame.dispose();
				  JOptionPane.showMessageDialog(this, "Login Successful for Admin");
				  //this.dispose();
			  }
			  
			  if(usertype.equalsIgnoreCase("staff-entry"))
			  { 
				  Entry_Dashboard frame=new Entry_Dashboard();
				  frame.setVisible(true);
				  JOptionPane.showMessageDialog(this, "Login Successful");
				  this.dispose();
			  }
			  if(usertype.equalsIgnoreCase("staff-exit"))
			  {
				  Exit_Dashboard frame=new Exit_Dashboard();
				  frame.setVisible(true);
				  JOptionPane.showMessageDialog(this, "Login Successful");
				  this.dispose();
			  }
		  }
        	
		  
		  else
		  { 
			
			  JOptionPane.showMessageDialog(this, "Wrong username/password", "Error", JOptionPane.ERROR_MESSAGE);  
              
		  }
		  return;
		  
          }
         
        
		  
	
		  
		  
		 


	public boolean checkEmpty() 
	{

		 if(username.isEmpty() || password.isEmpty() )
		 {
			 JOptionPane.showMessageDialog(this, "All fields are required", "Error", JOptionPane.ERROR_MESSAGE);
		    return true;
		 }
		 
				
	     
	    
	        return false;

	}

	@Override
	public void windowOpened(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) 
	{

		Listener.windowClosing(con);

	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		int check = e.getKeyCode();
         
		if (check == 10)
		{
			
	
			
			
	       
			username = txt_username.getText();
			pwd = pwd_password.getPassword();
			
			password = String.valueOf(pwd);
			
			
	       
	 
			   if( checkEmpty())
			   {
			   System.out.println("All fields are mandatory");
			   }

			 
			
			else
			
			{

				System.out.println("The username is " + username);
				System.out.println("The password is " + password);
			    credentials();

			
			}
		}

		}

	

	@Override
	public void keyReleased(KeyEvent e) {

	}
}