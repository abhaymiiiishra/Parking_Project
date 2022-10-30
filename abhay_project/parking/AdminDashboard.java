package parking;

//import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.border.LineBorder;



import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.Toolkit;

public class AdminDashboard extends JFrame implements ActionListener,KeyListener,WindowListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	String caption;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AdminDashboard frame = new AdminDashboard();
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
	public AdminDashboard() 
	{
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminDashboard.class.getResource("/parking/images/icon_parking.png")));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setGui();
	}
public void setGui()
{
	setTitle("Admin Dashboard");
	setBounds(100, 100, 1369, 784);
	
	JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
	
	JMenu mnAccount = new JMenu("Account");
	mnAccount.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
	menuBar.add(mnAccount);
	
	JMenuItem mnitemAddAccount = new JMenuItem("Add Account");
	 mnitemAddAccount.addActionListener(this);
	 mnitemAddAccount.addKeyListener(this);
	
	JMenuItem mnItemStaffDetails = new JMenuItem(" Staff Details");
	mnItemStaffDetails.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
	//mnItemStaffDetails.setBorder(new LineBorder(new Color(75, 0, 130)));
	mnAccount.add(mnItemStaffDetails);
	//mnitemAddAccount.setBorder(new LineBorder(new Color(75, 0, 130), 1, true));
	mnitemAddAccount.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
	mnItemStaffDetails.addActionListener(this);
	mnItemStaffDetails.addKeyListener(this);
	mnAccount.add(mnitemAddAccount);
	
	JMenuItem mnitemUpdateAccount = new JMenuItem("Update Account");
	 mnitemUpdateAccount.addActionListener(this);
	 mnitemUpdateAccount.addKeyListener(this);
	//mnitemUpdateAccount.setBorder(new LineBorder(new Color(75, 0, 130)));
	mnitemUpdateAccount.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
	mnAccount.add(mnitemUpdateAccount);
	
	JMenuItem mnitemDeleteAccount = new JMenuItem("Delete Account");
	 mnitemDeleteAccount.addActionListener(this);
	 mnitemDeleteAccount.addKeyListener(this);
	//mnitemDeleteAccount.setBorder(new LineBorder(new Color(75, 0, 130)));
	mnitemDeleteAccount.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
	mnAccount.add(mnitemDeleteAccount);
	
	JMenu mnParkingRules = new JMenu("Parking Rules");
	mnParkingRules.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
	menuBar.add(mnParkingRules);
	
	JMenuItem mnItemUpdateRules = new JMenuItem("Update Rules");
	mnItemUpdateRules.addActionListener(this);
	mnItemUpdateRules.addKeyListener(this);
	//mnItemUpdateRules.setBorder(new LineBorder(new Color(75, 0, 130)));
	mnItemUpdateRules.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
	mnParkingRules.add(mnItemUpdateRules);
	
	JMenuItem mntmViewRules = new JMenuItem("View Rules");
	mntmViewRules.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 16));
	mntmViewRules.addActionListener(this);
	mntmViewRules.addKeyListener(this);
	mnParkingRules.add(mntmViewRules);
	
	JMenu mnView = new JMenu("View");
	mnView.setFont(new Font("Segoe UI Semibold", Font.BOLD, 18));
	menuBar.add(mnView);
	
	JMenuItem mnItemVehicleDetails = new JMenuItem("Vehicle Details");
	mnItemVehicleDetails.addActionListener(this);
	mnItemVehicleDetails.addKeyListener(this);

	//mnItemVehicleDetails.setBorder(new LineBorder(new Color(75, 0, 130)));
	mnItemVehicleDetails.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
	mnView.add(mnItemVehicleDetails);
	
	JMenuItem mntmParked = new JMenuItem("Parked vehicle");
	mntmParked.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
	mntmParked.addActionListener(this);
	mntmParked.addKeyListener(this);
	mnView.add(mntmParked);
	
	JMenu mn_Charge = new JMenu("Charge ");
	mn_Charge.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
	menuBar.add(mn_Charge);
	
	JMenuItem mntm_view_charge = new JMenuItem("View Charges");
	mntm_view_charge.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
	mntm_view_charge.addActionListener(this);
	mntm_view_charge.addKeyListener(this);
	mn_Charge.add(mntm_view_charge);
	
	JMenuItem mntm_add_charge = new JMenuItem("Add Vehicle");
	mntm_add_charge.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
	mntm_add_charge.addActionListener(this);
	mntm_add_charge.addKeyListener(this);
	mn_Charge.add(mntm_add_charge);
	
	JMenuItem mntm_update_charge = new JMenuItem("Update Charges");
	mntm_update_charge.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
	mntm_update_charge.addActionListener(this);
	mntm_update_charge.addKeyListener(this);
	mn_Charge.add(mntm_update_charge);
	
	JMenuItem mntm_delete_charge = new JMenuItem("Delete Vehicle");
	mntm_delete_charge.setFont(new Font("Segoe UI Semibold", Font.BOLD, 15));
	mntm_delete_charge.addActionListener(this);
	mntm_delete_charge.addKeyListener(this);
	mn_Charge.add(mntm_delete_charge);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(255, 255, 255));
	contentPane.setBorder(new LineBorder(new Color(0, 0, 205), 2, true));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JButton btn_logout = new JButton("LOGOUT");
	btn_logout.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
	btn_logout.setBackground(new Color(64, 224, 208));
	btn_logout.setForeground(new Color(0, 0, 0));
	btn_logout.setBounds(1237, 35, 106, 28);
	btn_logout.addActionListener(this);
	btn_logout.addKeyListener(this);
	contentPane.add(btn_logout);
	
	
	JLabel lbl_admin = new JLabel("WELCOME ADMIN");
	lbl_admin.setHorizontalAlignment(SwingConstants.CENTER);
	lbl_admin.setFont(new Font("Garamond", Font.BOLD, 36));
	lbl_admin.setForeground(new Color(100, 149, 237));
	lbl_admin.setBounds(474, 83, 456, 69);
	contentPane.add(lbl_admin);
	
	JLabel lblimage = new JLabel("New label");
	lblimage.setIcon(new ImageIcon(AdminDashboard.class.getResource("/parking/images/adminpark.jpg")));
	lblimage.setBounds(479, 197, 470, 363);
	contentPane.add(lblimage);
	
	
	JLabel lblNewLabel = new JLabel("");
	lblNewLabel.setIcon(new ImageIcon(AdminDashboard.class.getResource("/parking/images/adminback.jpg")));
	lblNewLabel.setBounds(0, 0, 1365, 714);
	contentPane.add(lblNewLabel);
	
	
	
}

@Override
public void windowOpened(WindowEvent e) 

{
	// TODO Auto-generated method stub
	
}

@Override
public void windowClosing(WindowEvent e)
{
	
	
	// add the new login frame

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

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyPressed(KeyEvent e) 
{
	int code=e.getKeyCode();
    caption=e.getSource().toString();
    
	
	if(code==10)
		{
		action();
		}
	
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void actionPerformed(ActionEvent e)
{
	caption=e.getActionCommand();
	action();
	
}
public void action()
{
    
	
	System.out.println("Command initiated "+caption);
	
	//if(caption.equalsIgnoreCase("10"))
	//{
	
	if(caption.equalsIgnoreCase("Add Account"))
	{
		NewStaff frame=new NewStaff();
		frame.setVisible(true);
		//this.dispose();
	}
	if(caption.equalsIgnoreCase("Update Account"))
	{
		UpdateStaff frame=new UpdateStaff();
		frame.setVisible(true);
	}
	if(caption.equalsIgnoreCase("Delete Account"))
	{
		DeleteStaff frame=new DeleteStaff();
		frame.setVisible(true);
	}
	if(caption.equalsIgnoreCase("View Charges"))
	{
		ViewParkingCharge frame=new ViewParkingCharge();
		frame.setVisible(true);
	}

	if(caption.equalsIgnoreCase("Update Rules"))
	{
		UpdateRules frame=new UpdateRules();
		frame.setVisible(true);
	}
	
	if(caption.equalsIgnoreCase(" Staff Details"))
	{
		view_staff frame=new view_staff();
		frame.setVisible(true);
		
		
	}
	if(caption.equalsIgnoreCase("Vehicle Details"))
	{
		
		vehicle_date_parkid frame=new vehicle_date_parkid();
		frame.setVisible(true);
		
	}
	if(caption.equalsIgnoreCase("LOGOUT"))
	{
		login_details frame=new login_details();
		frame.setVisible(true);
		this.dispose();
	}
	if(caption.equalsIgnoreCase("View Rules"))
	{
		ViewRules frame=new ViewRules();
				frame.setVisible(true);
	}
	if(caption.equalsIgnoreCase("Parked Vehicle"))
	{
		 Parked_Vehicle frame=new Parked_Vehicle();
		 frame.setVisible(true);
	}
	if(caption.equalsIgnoreCase("Add Vehicle"))
	{
		AddParkingCharge frame=new AddParkingCharge();
				frame.setVisible(true);
	}
	if(caption.equalsIgnoreCase("Update Charges"))
	{
		UpdateParkingCharge frame=new UpdateParkingCharge();
				frame.setVisible(true);
	}
	if(caption.equalsIgnoreCase("Delete Vehicle"))
	{
		DeleteParkingCharge frame=new DeleteParkingCharge();
				frame.setVisible(true);
	}
	
}
}
