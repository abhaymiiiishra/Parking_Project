package parking;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class vehicle_date_parkid extends JFrame implements ActionListener,KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JButton btn_byparkid;
	JButton btn_bydate;
	JButton btn_vcno;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					vehicle_date_parkid frame = new vehicle_date_parkid();
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
	public vehicle_date_parkid() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(vehicle_date_parkid.class.getResource("/parking/images/m-design-logo-09A5D82F03-seeklogo.com.png")));
		GUI();
	}
	public void GUI()
	{
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 250);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btn_bydate = new JButton("BY DATE");
		btn_bydate.setBackground(new Color(72, 61, 139));
		btn_bydate.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 20));
		btn_bydate.setForeground(new Color(0, 255, 127));
		btn_bydate.setBounds(10, 84, 125, 42);
		btn_bydate.addActionListener(this);
		btn_bydate.addKeyListener(this);
		contentPane.add(btn_bydate);
		
		
		btn_byparkid = new JButton("PARKING ID");
		btn_byparkid.setBackground(new Color(72, 61, 139));
		btn_byparkid.setForeground(new Color(0, 255, 127));
		btn_byparkid.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 20));
		btn_byparkid.setBounds(145, 84, 143, 42);
		btn_byparkid.addActionListener(this);
		btn_byparkid.addKeyListener(this);
		contentPane.add(btn_byparkid);
		
		btn_vcno = new JButton("vehicle no.");
		btn_vcno.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 20));
		btn_vcno.setBackground(new Color(72, 61, 139));
		btn_vcno.setForeground(new Color(0, 255, 127));
		btn_vcno.setBounds(298, 84, 136, 42);
		btn_vcno.addActionListener(this);
		btn_vcno.addKeyListener(this);
		contentPane.add(btn_vcno);
		
		
		JLabel lbl_background = new JLabel("New label");
		lbl_background.setIcon(new ImageIcon(vehicle_date_parkid.class.getResource("/parking/images/vehicle dash.jpg")));
		lbl_background.setBounds(0, -2, 444, 221);
		contentPane.add(lbl_background);
		
		
		
		
		
		setLocationRelativeTo(null);
	}
   
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code=e.getExtendedKeyCode();
		Object caption=e.getSource();
		System.out.println(caption);
		//System.out.println(key);
		System.out.println(code);
		
		
		if(code==10)
		{ 
			if(caption.equals(btn_bydate))
			
			{
				
				
				 
		    		vehicleDate frame=new vehicleDate();
			    	frame.setVisible(true);
			    	
			    	this.dispose();
			    	
		    	
		    	}
		    if(caption.equals(btn_byparkid))
		    {   
		    	Vehicle_Details frame=new Vehicle_Details();
		    	frame.setVisible(true);
		    	
		    	this.dispose();
		    }
		    if(caption.equals(btn_vcno))
		    {
		    	Vehicle_vcno frame=new Vehicle_vcno();
		    	frame.setVisible(true);
		    }
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String caption=e.getActionCommand();
		if(caption.equalsIgnoreCase("parking id"))
		{
			Vehicle_Details frame=new Vehicle_Details();
			frame.setVisible(true);
			this.dispose();
		}
		if(caption.equalsIgnoreCase("by date"))
		{
			vehicleDate frame=new vehicleDate();
			frame.setVisible(true);
			this.dispose();
		}
		if(caption.equalsIgnoreCase("vehicle no."))
		    {
		    	Vehicle_vcno frame=new Vehicle_vcno();
		    	frame.setVisible(true);
		    	this.dispose();
		    }
	}
}
