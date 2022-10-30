package parking;

//import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
//import java.awt.event.FocusEvent;
//import java.awt.event.FocusListener;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;

import parking.DataBaseConnection;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Toolkit;
//import javax.swing.ImageIcon;
public class UpdateStaff extends JFrame  implements ActionListener,KeyListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_name;
	private JTextField txt_phoneno;
	private JTextField txt_email;

	private Connection  con;
	private 	JComboBox<String> cmbstaffid;
	
	private PreparedStatement ps,pscourse;
	private ResultSet rscourse;
	

	String id,duration;
	String fees,name;
	private JButton btn_update;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UpdateStaff frame = new UpdateStaff();
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
	public UpdateStaff() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateStaff.class.getResource("/parking/images/icon_parking.png")));
		setResizable(false);
		setTitle("Update Staff");
		con=DataBaseConnection.createConnection();
		createGui();
		
	}
	
	
	public void createGui()
	{
		
		
	
		setBounds(100, 100, 713, 665);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new LineBorder(new Color(34, 139, 34), 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_name = new JTextField();
		txt_name.setForeground(new Color(0, 0, 0));
		txt_name.setFont(new Font("Courier New", Font.ITALIC, 18));
		txt_name.setEditable(false);
		//txtid.addFocusListener(this);
		txt_name.setBounds(251, 143, 243, 33);
		contentPane.add(txt_name);
		txt_name.setColumns(10);
		
		txt_phoneno = new JTextField();
		txt_phoneno.setForeground(new Color(0, 0, 0));
		txt_phoneno.setFont(new Font("Courier New", Font.BOLD, 18));
		txt_phoneno.setBounds(251, 202, 243, 33);
		contentPane.add(txt_phoneno);
		txt_phoneno.setColumns(10);
		
		txt_email = new JTextField();
		txt_email.setForeground(new Color(0, 0, 0));
		txt_email.setFont(new Font("Courier New", Font.BOLD, 18));
		txt_email.setBounds(251, 271, 243, 33);
		contentPane.add(txt_email);
		txt_email.setColumns(10);
		
		 btn_update = new JButton("UPDATE");
		 btn_update.setBackground(new Color(176, 224, 230));
		 btn_update.setForeground(new Color(128, 128, 0));
		 btn_update.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 28));
		btn_update.setBounds(238, 495, 139, 33);
		btn_update.addKeyListener(this);
		btn_update.addActionListener(this);
		contentPane.add(btn_update);
		
		
		  cmbstaffid = new JComboBox<String>(); 
		  cmbstaffid.setForeground(new Color(0, 0, 0));
		  cmbstaffid.setFont(new Font("Courier New", Font.BOLD, 18));
		  cmbstaffid.addActionListener(this);
		  cmbstaffid.setModel(new DefaultComboBoxModel<String>(new String[] {"Select StaffId"})); 
		  populateCombo();
		  cmbstaffid.setBounds(251, 74, 243,33); 
		  contentPane.add(cmbstaffid);
		  
		  JLabel lbl_staffid = new JLabel("Staff ID");
		  lbl_staffid.setForeground(new Color(0, 255, 0));
		  lbl_staffid.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		  lbl_staffid.setBounds(61, 77, 133, 27);
		  contentPane.add(lbl_staffid);
		  
		  JLabel lbl_name = new JLabel("Name");
		  lbl_name.setForeground(new Color(0, 255, 0));
		  lbl_name.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		  lbl_name.setBounds(61, 143, 108, 33);
		  contentPane.add(lbl_name);
		  
		  JLabel lbl_phoneno = new JLabel("Phone No.");
		  lbl_phoneno.setForeground(new Color(0, 255, 0));
		  lbl_phoneno.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		  lbl_phoneno.setBounds(61, 208, 96, 20);
		  contentPane.add(lbl_phoneno);
		  
		  JLabel lblNewLabel = new JLabel("Email ID");
		  lblNewLabel.setForeground(new Color(0, 255, 0));
		  lblNewLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		  lblNewLabel.setBounds(61, 271, 108, 33);
		  contentPane.add(lblNewLabel);
		  
		  JLabel lblNewLabel_1 = new JLabel("Address");
		  lblNewLabel_1.setForeground(new Color(0, 255, 0));
		  lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		  lblNewLabel_1.setBounds(61, 395, 133, 33);
		  contentPane.add(lblNewLabel_1);
		  
		  text_area_address = new JTextField();
		  text_area_address.setForeground(new Color(0, 0, 0));
		  text_area_address.setFont(new Font("Courier New", Font.BOLD, 18));
		  text_area_address.setBounds(251, 377, 243, 70);
		  contentPane.add(text_area_address);
		  text_area_address.setColumns(10);
		  
		  text_pass = new JTextField();
		  text_pass.setForeground(new Color(0, 0, 0));
		  text_pass.setFont(new Font("Courier New", Font.BOLD, 18));
		  text_pass.setColumns(10);
		  text_pass.setBounds(251, 333, 243, 33);
		  contentPane.add(text_pass);
		  
		  JLabel lbl_Password = new JLabel("Password");
		  lbl_Password.setForeground(Color.GREEN);
		  lbl_Password.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
		  lbl_Password.setBounds(61, 333, 108, 33);
		  contentPane.add(lbl_Password);
		  
		  
		  setLocationRelativeTo(null);
		 
	}

	
	
	
	String password;
	
	public void populateCombo()

	{
		int flag=0;
		try {
			
			String str_read = "select staffid  from staffdetails";
			pscourse = con.prepareStatement(str_read);
			rscourse = pscourse.executeQuery();

			while (rscourse.next())		
			{
				flag=1;
			
				String id=rscourse.getString("staffid");
			
				cmbstaffid.addItem(id);
			}
			if(flag==0)
			{
				JOptionPane.showMessageDialog(this, "No staff available yet");
				
				
			}
			
			
			

		} catch (SQLException se) {
			System.out.println(se);
		} finally {

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
	
	
	String email,phone,address;
	
	public void fetchData(String cid)
	{
		
		
		try {
			
			
			String strsql="select * from staffdetails where staffid=?";
			
			ps=con.prepareStatement(strsql);
			ps.setString(1,cid);
			ResultSet rs=	ps.executeQuery();
			
				if(rs.next())
				{
					
					name=rs.getString("name");
					email=rs.getString("email");
					phone=rs.getString("phone");
					address=rs.getString("address");	
						
				}
				
						

			
		}
			
		catch(SQLException se)
		{
			
			
			System.out.println(se);
		}
		
		
				
	
	
		
	}
	String status="";
	String cid="";
	private JTextField text_area_address;
	private JTextField text_pass;
	
	
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		
		//System.out.println("click event generated");
		
		if(ae.getSource()==cmbstaffid)
		{
			
			//System.out.println("combo doyour work here");
			
			 cid=(String)cmbstaffid.getSelectedItem();
			fetchData(cid);
			password();
			txt_phoneno.setText(phone);
			txt_email.setText(email);
			txt_name.setText(name);
			text_area_address.setText(address);
			text_pass.setText(password);
		}
		
		
		

		if(ae.getSource()==btn_update)
		{
			
			
				String updated_phone=txt_phoneno.getText();
				String updated_email=txt_email.getText();
				String updated_address = text_area_address.getText();
			
			
						if(updated_phone.isEmpty() || updated_email.isEmpty() || updated_address.isEmpty()  || cid.equalsIgnoreCase("Select StaffId"))
						
							
						{
							
							JOptionPane.showMessageDialog(this, "Enter valid data for updation");
						}
						
						else
						{
							
						
							
						int status=	updateStaff();
						if(status>0)
						{
							
							JOptionPane.showMessageDialog(this, "Staff Details Updated successfully");
							cmbstaffid.setSelectedIndex(0);
							txt_email.setText("");
							txt_name.setText("");
							txt_phoneno.setText("");
							text_area_address.setText("");
							text_pass.setText("");
						}
							
				
			}
			
			
			
			
				
			}
			
			
		
		
		
			
			
			}//method closes
		
		
	
	
	public int updateStaff()
	
	{
		
		int updatestatus=0;
		try {
			
			updatepass();
			
			String strupdate="update staffdetails set email=?, phone=?, address=? where staffid=?";
			
			String updated_email   =txt_email.getText();
			String updated_phone   =txt_phoneno.getText();
			String updated_address = text_area_address.getText();		
			
			pscourse=con.prepareStatement(strupdate);
			
			pscourse.setString(1, updated_email);
			pscourse.setString(2, updated_phone);
			pscourse.setString(3, updated_address);
			pscourse.setString(4, cid);
			System.out.println(pscourse);
			
		 updatestatus=pscourse.executeUpdate();	
			
		}
		catch(SQLException se)
		{
			
			se.printStackTrace();
		}
		finally {
			
			if(pscourse!=null)
				try {
					pscourse.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
	return updatestatus;	
	}
	public void password()
	{   try
	{
	    String strpass="select password from login where id=?";
	    pscourse=con.prepareStatement(strpass);
	    pscourse.setString(1, cid);
	    ResultSet rs=	pscourse.executeQuery();
		if(rs.next())
		{	
			password=rs.getString("password");
		}
	}
	catch(SQLException se)
	{
		
		se.printStackTrace();
	}
	finally {
		
		if(pscourse!=null)
			try {
				pscourse.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
	}
	public void updatepass()
	{
		try
		{
			String strupdate="update login set password=? where id=?";
			
			String updpass=text_pass.getText();
			
            pscourse=con.prepareStatement(strupdate);
			
			pscourse.setString(1, updpass);
			pscourse.setString(2, cid);
			
		 int updatestatus = pscourse.executeUpdate();	
			
		
	}
	catch(SQLException se)
	{
		
		se.printStackTrace();
	}
	finally {
		
		if(pscourse!=null)
			try {
				pscourse.close();
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
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code=e.getKeyCode();
		if(code==10)
		{
		if(e.getSource()==cmbstaffid)
		{
			
			//System.out.println("combo doyour work here");
			
			 cid=(String)cmbstaffid.getSelectedItem();
			fetchData(cid);
			password();
			txt_phoneno.setText(phone);
			txt_email.setText(email);
			txt_name.setText(name);
			text_area_address.setText(address);
			text_pass.setText(password);
		}
		
		
		

		if(e.getSource()==btn_update)
		{
			
			
				String updated_phone=txt_phoneno.getText();
				String updated_email=txt_email.getText();
				String updated_address = text_area_address.getText();
			
			
						if(updated_phone.isEmpty() || updated_email.isEmpty() || updated_address.isEmpty()  || cid.equalsIgnoreCase("Select StaffId"))
						
							
						{
							
							JOptionPane.showMessageDialog(this, "Enter valid data for updation");
						}
						
						else
						{
							
						
							
						int status=	updateStaff();
						if(status>0)
						{
							
							JOptionPane.showMessageDialog(this, "Staff Details Updated successfully");
							cmbstaffid.setSelectedIndex(0);
							txt_email.setText("");
							txt_name.setText("");
							txt_phoneno.setText("");
							text_area_address.setText("");
							text_pass.setText("");
						}
							
				
			}
			
			
			
			
				
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	}