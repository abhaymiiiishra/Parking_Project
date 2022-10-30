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

public class UpdateParkingCharge extends JFrame implements ActionListener,KeyListener{

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
	JButton btn_update;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UpdateParkingCharge frame = new UpdateParkingCharge();
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
	public UpdateParkingCharge() {
		setTitle("Update Charges");
		setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateParkingCharge.class.getResource("/parking/images/icon_parking.png")));
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
	  cmbvehicle.setFont(new Font("Courier New", Font.BOLD, 18));
	  cmbvehicle.addActionListener(this);
	  cmbvehicle.setModel(new DefaultComboBoxModel<String>(new String[] {"Select Vehicle"})); 
	  populateCombo();
	  cmbvehicle.setBounds(253, 99, 243,33); 
	  contentPane.add(cmbvehicle);
	  
	  JLabel lbl_vehicle = new JLabel("VEHICLE");
	  lbl_vehicle.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
	  lbl_vehicle.setForeground(new Color(0, 250, 154));
	  lbl_vehicle.setBounds(50, 100, 126, 33);
	  contentPane.add(lbl_vehicle);
	  
	  JLabel lbl_chargehr = new JLabel("CHARGE/hr");
	  lbl_chargehr.setForeground(new Color(0, 250, 154));
	  lbl_chargehr.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
	  lbl_chargehr.setBounds(50, 164, 126, 33);
	  contentPane.add(lbl_chargehr);
	  
	  text_chargehr = new JTextField();
	  text_chargehr.setForeground(new Color(0, 0, 0));
	  text_chargehr.setFont(new Font("Courier New", Font.BOLD, 18));
	  text_chargehr.setBounds(251, 165, 112, 33);
	  contentPane.add(text_chargehr);
	  text_chargehr.setColumns(10);
	  
	  btn_update = new JButton("UPDATE");
	  btn_update.setBackground(new Color(169, 169, 169));
	  btn_update.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
	  btn_update.setForeground(new Color(255, 250, 250));
	  btn_update.setBounds(149, 401, 112, 40);
	  btn_update.addActionListener(this);
	  btn_update.addKeyListener(this);
	  contentPane.add(btn_update);
	  
	  JLabel lbl_weekends = new JLabel("WEEKENDS");
	  lbl_weekends.setForeground(new Color(0, 250, 154));
	  lbl_weekends.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
	  lbl_weekends.setBounds(50, 340, 126, 33);
	  contentPane.add(lbl_weekends);
	  
	  JLabel lbl_weekdays = new JLabel("WEEKDAYS");
	  lbl_weekdays.setForeground(new Color(0, 250, 154));
	  lbl_weekdays.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
	  lbl_weekdays.setBounds(50, 296, 126, 33);
	  contentPane.add(lbl_weekdays);
	  
	  JLabel lbl_full_day = new JLabel("CHARGES FOR A FULL DAY");
	  lbl_full_day.setFont(new Font("Garamond", Font.BOLD, 18));
	  lbl_full_day.setForeground(Color.ORANGE);
	  lbl_full_day.setBounds(124, 240, 255, 32);
	  contentPane.add(lbl_full_day);
	  
	  text_weekdays = new JTextField();
	  text_weekdays.setForeground(new Color(0, 0, 0));
	  text_weekdays.setFont(new Font("Courier New", Font.BOLD, 18));
	  text_weekdays.setColumns(10);
	  text_weekdays.setBounds(251, 296, 112, 33);
	  contentPane.add(text_weekdays);
	  
	  text_weekends = new JTextField();
	  text_weekends.setForeground(new Color(0, 0, 0));
	  text_weekends.setFont(new Font("Courier New", Font.BOLD, 18));
	  text_weekends.setColumns(10);
	  text_weekends.setBounds(251, 340, 112, 33);
	  contentPane.add(text_weekends);
	  
	  JLabel lbl_heading = new JLabel("UPDATE CHARGES");
	  lbl_heading.setForeground(Color.ORANGE);
	  lbl_heading.setFont(new Font("Garamond", Font.BOLD, 25));
	  lbl_heading.setBounds(136, 26, 243, 32);
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
	{
	if(e.getSource()==cmbvehicle)
	{
		fetchcmb();
	}
	
	if (e.getSource()==btn_update)
	{   
		int selection =	JOptionPane.showConfirmDialog(this, "Are you sure you want to update this" , "Confirmation",JOptionPane.WARNING_MESSAGE);
		if(selection==0)
		  { 
			update();
		  }
	}
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
	
	if (e.getSource()==btn_update)
	{   
		int selection =	JOptionPane.showConfirmDialog(this, "Are you sure you want to update this" , "Confirmation",JOptionPane.WARNING_MESSAGE);
		if(selection==0)
		  { 
			update();
		  }
	}
	
}
String chargehr,weekend,weekday;
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
public void update()
{
	
	String chargehr=text_chargehr.getText();
	String weekday=text_weekdays.getText();
	String weekend=text_weekends.getText();
	String sqlupdate="update parking_charge set chargehr=?,chargeday=?,weekend_chargeday=? where vehicletype=?";
	
	try {
		PreparedStatement psread = con.prepareStatement(sqlupdate);
		
		psread.setString(1,chargehr);
		psread.setString(2,weekday);
		psread.setString(3,weekend);
		
		
		psread.setString(4,cmb);
		
	    int status= psread.executeUpdate();
	    
	   if(status>0) 	
	   {
	    
	
	    
	    JOptionPane.showMessageDialog(this, "Charges Updated");
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


