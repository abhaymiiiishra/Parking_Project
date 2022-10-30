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
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class DeleteParkingCharge extends JFrame implements ActionListener,KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private 	JComboBox<String> cmbvehicle;
	private JTextField text_chargehr;
	private PreparedStatement ps,pscourse;
	private ResultSet rscourse;
	String cmb="";
	private JTextField text_weekdays;
	private JTextField text_weekends;
	Connection con;
	JButton btn_delete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteParkingCharge frame = new DeleteParkingCharge();
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
	public DeleteParkingCharge() {
		setTitle("Delete Parking Charge");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DeleteParkingCharge.class.getResource("/parking/images/icon_parking.png")));
		setResizable(false);
		setAlwaysOnTop(true);
		
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
	
	
	cmbvehicle = new JComboBox<String>(); 
	  cmbvehicle.setForeground(new Color(0, 0, 0));
	  cmbvehicle.setFont(new Font("Courier New", Font.BOLD, 20));
	  cmbvehicle.addActionListener(this);
	  cmbvehicle.setModel(new DefaultComboBoxModel<String>(new String[] {"Select Vehicle"})); 
	  populateCombo();
	  cmbvehicle.setBounds(251, 110, 243,33); 
	  contentPane.add(cmbvehicle);
	  
	  JLabel lbl_vehicle = new JLabel("VEHICLE");
	  lbl_vehicle.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
	  lbl_vehicle.setForeground(new Color(0, 250, 154));
	  lbl_vehicle.setBounds(50, 111, 126, 33);
	  contentPane.add(lbl_vehicle);
	  
	  JLabel lbl_chargehr = new JLabel("CHARGE/hr");
	  lbl_chargehr.setForeground(new Color(0, 250, 154));
	  lbl_chargehr.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
	  lbl_chargehr.setBounds(50, 174, 126, 33);
	  contentPane.add(lbl_chargehr);
	  
	  text_chargehr = new JTextField();
	  text_chargehr.setEditable(false);
	  text_chargehr.setForeground(new Color(0, 0, 0));
	  text_chargehr.setFont(new Font("Courier New", Font.BOLD, 20));
	  text_chargehr.setBounds(251, 175, 112, 33);
	  contentPane.add(text_chargehr);
	  text_chargehr.setColumns(10);
	  
	  btn_delete = new JButton("DELETE");
	  btn_delete.setBackground(new Color(64, 224, 208));
	  btn_delete.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
	  btn_delete.setForeground(new Color(250, 128, 114));
	  btn_delete.setBounds(169, 401, 141, 40);
	  btn_delete.addActionListener(this);
	  btn_delete.addKeyListener(this);
	  contentPane.add(btn_delete);
	  
	  JLabel lbl_weekends = new JLabel("WEEKENDS");
	  lbl_weekends.setHorizontalAlignment(SwingConstants.LEFT);
	  lbl_weekends.setForeground(new Color(0, 250, 154));
	  lbl_weekends.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
	  lbl_weekends.setBounds(50, 340, 126, 33);
	  contentPane.add(lbl_weekends);
	  
	  JLabel lbl_weekdays = new JLabel("Weekdays");
	  lbl_weekdays.setHorizontalAlignment(SwingConstants.LEFT);
	  lbl_weekdays.setForeground(new Color(0, 250, 154));
	  lbl_weekdays.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
	  lbl_weekdays.setBounds(50, 296, 126, 33);
	  contentPane.add(lbl_weekdays);
	  
	  JLabel lbl_full_day = new JLabel("CHARGES FOR A FULL DAY");
	  lbl_full_day.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
	  lbl_full_day.setForeground(Color.ORANGE);
	  lbl_full_day.setBounds(124, 240, 206, 32);
	  contentPane.add(lbl_full_day);
	  
	  text_weekdays = new JTextField();
	  text_weekdays.setForeground(new Color(0, 0, 0));
	  text_weekdays.setFont(new Font("Courier New", Font.BOLD, 20));
	  text_weekdays.setEditable(false);
	  text_weekdays.setColumns(10);
	  text_weekdays.setBounds(251, 296, 112, 33);
	  contentPane.add(text_weekdays);
	  
	  text_weekends = new JTextField();
	  text_weekends.setForeground(new Color(0, 0, 0));
	  text_weekends.setFont(new Font("Courier New", Font.BOLD, 20));
	  text_weekends.setEditable(false);
	  text_weekends.setColumns(10);
	  text_weekends.setBounds(251, 340, 112, 33);
	  contentPane.add(text_weekends);
	  
	  lbl_full_day_1 = new JLabel("DELETE VEHICLE");
	  lbl_full_day_1.setForeground(Color.ORANGE);
	  lbl_full_day_1.setFont(new Font("Garamond", Font.BOLD, 26));
	  lbl_full_day_1.setBounds(149, 11, 236, 32);
	  contentPane.add(lbl_full_day_1);
	  
	  setLocationRelativeTo(null);
}

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==cmbvehicle)
	{
		fetchcmb();
	}
	if (e.getSource()==btn_delete)
	{   
	int selection =	JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this" , "Confirmation",JOptionPane.WARNING_MESSAGE);
		if(selection==0)
				{delete();}
	}
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==cmbvehicle)
	{
		fetchcmb();
	}
	if (e.getSource()==btn_delete)
	{   
	int selection =	JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this" , "Confirmation",JOptionPane.WARNING_MESSAGE);
		if(selection==0)
				{delete();}
	}
	
}
String chargehr,chargeday,weekday,weekend;
private JLabel lbl_full_day_1;
public void fetchsql()
{
	
	try {
		
		
		String strsql="select * from parking_charge where vehicletype=?";
		
		ps=con.prepareStatement(strsql);
		ps.setString(1,cmb);
		ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				
				chargehr=rs.getString("chargehr");	
				weekday=rs.getString("chargeday");
				weekend=rs.getString("weekend_chargeday");
				text_chargehr.setText(chargehr);
				
				text_weekends.setText(weekend);
				text_weekdays.setText(weekday);
			}
			
					

		
	}
		
	catch(SQLException se)
	{
		
		
		System.out.println(se);
	}
	
}
public void delete()
{
	
	String sqldel="DELETE FROM parking_charge where vehicletype=?";
	System.out.println("hey");
	try {
		PreparedStatement psread = con.prepareStatement(sqldel);
		System.out.println("hi");
		psread.setString(1,cmb);
		System.out.println("heythere");
	    int status= psread.executeUpdate();
	    System.out.println("hello");
	   if(status>0) 	
	   { text_chargehr.setText("");
	    text_weekends.setText("");
	    text_weekdays.setText("");
	    
	   
	    cmbvehicle.removeItem(cmb);
	    JOptionPane.showMessageDialog(this, "Vehicle Deleted");
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
			}}
}

public void populateCombo()

{
	int flag=0;
	
	
	try {
		
		String str_read = "select vehicletype  from parking_charge";
		pscourse = con.prepareStatement(str_read);
		rscourse = pscourse.executeQuery();

		while (rscourse.next())		
		{
			flag=1;
		
			String vehiclesql=rscourse.getString("vehicletype");
		
			cmbvehicle.addItem(vehiclesql);
		}
		if(flag==0)
		{
			JOptionPane.showMessageDialog(this, "No vehicle available yet");
			
			
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

public void fetchcmb()
{
				
				
				
				cmb=(String)cmbvehicle.getSelectedItem();
				fetchsql();
				
			
}
}

