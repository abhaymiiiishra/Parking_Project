package parking;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Frame;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;

public class Entry_Dashboard extends JFrame implements ActionListener,KeyListener,WindowListener{

	private JPanel contentPane;
	JButton btn_logout;
	JButton btn_entry;
	JButton btn_vehicle;
	JButton btn_rules;
	JButton btn_charge;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Entry_Dashboard frame = new Entry_Dashboard();
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
	public Entry_Dashboard() {
		setTitle("Entry Dashboard");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Entry_Dashboard.class.getResource("/parking/images/icon_parking.png")));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		GUI();
	}
    public void GUI()
    {
    	
		setBounds(100, 100, 1400, 814);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btn_logout = new JButton("LOGOUT");
		btn_logout.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
		btn_logout.setForeground(new Color(255, 250, 250));
		btn_logout.setBackground(new Color(102, 205, 170));
		btn_logout.setBounds(1242, 52, 108, 32);
		btn_logout.addActionListener(this);
		btn_logout.addKeyListener(this);
		contentPane.add(btn_logout);
		
		btn_entry = new JButton("ENTRY");
		btn_entry.setForeground(new Color(255, 250, 250));
		btn_entry.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
		btn_entry.setBackground(new Color(102, 205, 170));
		btn_entry.setBounds(293, 278, 116, 32);
		btn_entry.addKeyListener(this);
		btn_entry.addActionListener(this);
		contentPane.add(btn_entry);
		
		btn_vehicle = new JButton("VEHICLE");
		btn_vehicle.setBackground(new Color(102, 205, 170));
		btn_vehicle.setForeground(new Color(255, 250, 250));
		btn_vehicle.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
		btn_vehicle.setBounds(293, 439, 116, 33);
		btn_vehicle.addActionListener(this);
		btn_vehicle.addKeyListener(this);
		contentPane.add(btn_vehicle);
		
		btn_rules = new JButton("RULES");
		btn_rules.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
		btn_rules.setBackground(new Color(102, 205, 170));
		btn_rules.setForeground(new Color(255, 250, 250));
		btn_rules.setBounds(293, 358, 116, 33);
		btn_rules.addActionListener(this);
		btn_rules.addKeyListener(this);
		contentPane.add(btn_rules);
		
		btn_charge = new JButton("CHARGE");
		btn_charge.setBackground(new Color(102, 205, 170));
		btn_charge.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
		btn_charge.setForeground(new Color(255, 250, 250));
		btn_charge.setBounds(293, 595, 116, 33);
		btn_charge.addActionListener(this);
		btn_charge.addKeyListener(this);
		contentPane.add(btn_charge);
		

		
		lblNewLabel = new JLabel("NEW ENTRY");
		lblNewLabel.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 269, 116, 49);
		contentPane.add(lblNewLabel);
		
		lblViewParkingCharges = new JLabel("VIEW PARKING CHARGES");
		lblViewParkingCharges.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lblViewParkingCharges.setBounds(10, 579, 278, 49);
		contentPane.add(lblViewParkingCharges);
		
		lblViewParkingRules = new JLabel("VIEW PARKING RULES");
		lblViewParkingRules.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lblViewParkingRules.setBounds(10, 342, 278, 49);
		contentPane.add(lblViewParkingRules);
		
		lblViewVehiclesParked = new JLabel("VIEW VEHICLES PARKED IN");
		lblViewVehiclesParked.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lblViewVehiclesParked.setBounds(10, 503, 278, 49);
		contentPane.add(lblViewVehiclesParked);
		
		lblViewVehicleStatus = new JLabel("VIEW VEHICLE STATUS");
		lblViewVehicleStatus.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		lblViewVehicleStatus.setBounds(10, 423, 278, 49);
		contentPane.add(lblViewVehicleStatus);
		
		lblLoggedInAs = new JLabel("LOGGED IN AS USER ");
		lblLoggedInAs.setFont(new Font("Georgia", Font.BOLD, 18));
		lblLoggedInAs.setBounds(10, 43, 278, 49);
		contentPane.add(lblLoggedInAs);
		
		btn_parking = new JButton("PARKING");
		btn_parking.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
		btn_parking.setForeground(new Color(255, 250, 250));
		btn_parking.setBackground(new Color(102, 205, 170));
		btn_parking.setBounds(293, 519, 116, 33);
		btn_parking.addActionListener(this);
		btn_parking.addKeyListener(this);
		contentPane.add(btn_parking);
		
		lblUser = new JLabel(login_details.username);
		lblUser.setFont(new Font("Georgia", Font.BOLD, 18));
		lblUser.setBounds(237, 43, 278, 49);
		contentPane.add(lblUser);
		
		lblbackground = new JLabel("");
		lblbackground.setIcon(new ImageIcon(Entry_Dashboard.class.getResource("/parking/images/3824.jpg")));
		lblbackground.setBounds(0, 0, 1370, 749);
		contentPane.add(lblbackground);
    }
    ActionEvent e;
    private JLabel lbl_background;
    private JLabel lblNewLabel;
    private JLabel lblViewParkingCharges;
    private JLabel lblViewParkingRules;
    private JLabel lblViewVehiclesParked;
    private JLabel lblViewVehicleStatus;
    private JLabel lblLoggedInAs;
    private JButton btn_parking;
    private JLabel lblUser;
    private JLabel lblbackground;
	@Override
	public void keyTyped(KeyEvent ke) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent ke) {
		// TODO Auto-generated method stub
		int code=ke.getKeyCode();
		if(code==10)
		{
			Object caption = ke.getSource();
			if(caption==btn_vehicle)
			{
				
				vehicle_date_parkid frame=new vehicle_date_parkid();
				frame.setVisible(true);
			}
			
			if(caption==btn_charge)
			{
				ViewParkingCharge frame=new ViewParkingCharge();
				frame.setVisible(true);
						
			}
			if(caption==btn_rules)
			{   ViewRules frame1=new ViewRules();
			    frame1.setVisible(true);
				
				
				
		    }
			
			if(caption==btn_entry)
			{
				Entry frame=new Entry();
				frame.setVisible(true);
			}
			if(caption==btn_logout)
			{
				login_details frame=new login_details();
				frame.setVisible(true);
				this.dispose();

			}
			if(caption==btn_parking)
			{
				Parked_Vehicle frame=new Parked_Vehicle();
				frame.setVisible(true);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		// TODO Auto-generated method stub
		
	}

	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object caption = e.getSource();
		if(caption==btn_vehicle)
		{
			
			vehicle_date_parkid frame=new vehicle_date_parkid();
			frame.setVisible(true);
		}
		
		if(caption==btn_charge)
		{
			ViewParkingCharge frame=new ViewParkingCharge();
			frame.setVisible(true);
					
		}
		if(caption==btn_rules)
		{   ViewRules frame1=new ViewRules();
		    frame1.setVisible(true);
			
			
			
	    }
		
		if(caption==btn_entry)
		{
			Entry frame=new Entry();
			frame.setVisible(true);
		}
		if(caption==btn_logout)
		{
			login_details frame=new login_details();
			frame.setVisible(true);
			this.dispose();

		}
		if(caption==btn_parking)
		{
			Parked_Vehicle frame=new Parked_Vehicle();
			frame.setVisible(true);
		}
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		login_details frame=new login_details();
		frame.setVisible(true);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		login_details frame=new login_details();
		frame.setVisible(true);
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
