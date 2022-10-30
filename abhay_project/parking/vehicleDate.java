package parking;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ScrollPaneConstants;

public class vehicleDate extends JFrame implements ActionListener,KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	PreparedStatement ps;
	ResultSet rs;
	Connection con;
	String operation;
	String time;
	JDateChooser dateChooser;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					vehicleDate frame = new vehicleDate();
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
	public vehicleDate() {
		setTitle("Search Vehicle By Date");
		setIconImage(Toolkit.getDefaultToolkit().getImage(vehicleDate.class.getResource("/parking/images/m-design-logo-09A5D82F03-seeklogo.com.png")));
		con=DataBaseConnection.createConnection();
		GUI();
	}
    public void GUI()
    {
    	
		setBounds(100, 100, 990, 722);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 84, 974, 599);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(0, 5, 974, 596);
		
		scrollPane_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		scrollPane_1.setAutoscrolls(true);
		panel.add(scrollPane_1);
		
		table = new JTable(model);
		table.setEnabled(false);
		table.setRowSelectionAllowed(false);
		
		scrollPane_1.setViewportView(table);
		table.setSize(974, 304);
		table.setBounds(0, 84, 974, 304);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(61, 32, 215, 41);
		dateChooser.setDateFormatString("yyyy-MM-dd");
		contentPane.add(dateChooser);
		
		JButton btn_entry = new JButton("INDATE");
		btn_entry.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 21));
		btn_entry.setBackground(new Color(64, 224, 208));
		btn_entry.setBounds(371, 32, 149, 41);
		btn_entry.addActionListener(this);
		btn_entry.addKeyListener(this);
		contentPane.add(btn_entry);
		
		JButton btn_exit = new JButton("OUTDATE");
		btn_exit.setBackground(new Color(64, 224, 208));
		btn_exit.setForeground(new Color(0, 0, 0));
		btn_exit.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
		btn_exit.setBounds(623, 32, 149, 41);
		btn_exit.addActionListener(this);
		btn_exit.addKeyListener(this);
		contentPane.add(btn_exit);
		 model.addColumn("Parking ID");
	        model.addColumn("Checkin ID");
	        model.addColumn("Token ID");
	        model.addColumn("Vehicle Type");
	        model.addColumn("Vehicle NO.");
	        model.addColumn("IN Date");
	        model.addColumn("IN Time");
	        model.addColumn("Checkout ID");
	        model.addColumn("OUT Date");
	        model.addColumn("OUT Time");
	        model.addColumn("Charge");
	        model.addColumn("time");
	        model.addColumn("Status");
	        table.getTableHeader().setBackground(Color.yellow);
	        
			
	        
	        setLocationRelativeTo(null);
		
    }
    
    
    
    
    
    
    
    String sql;
    public void vehicle() {
    	
        
        
        try {
        	if(operation.equalsIgnoreCase("outdate"))
        	{
            sql="select * from vehicledetails where outdate=?"; 
        	}
        	else sql="select * from vehicledetails where indate=?";
        		
            ps=con.prepareStatement(sql);
            ps.setString(1,time);
            System.out.println(sql);
           
            ResultSet Rs = ps.executeQuery();
            System.out.println("1");
            
            while(Rs.next()){
            	System.out.println("2");
            	
                model.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5),Rs.getString(6),Rs.getString(7),Rs.getString(8),Rs.getString(9),Rs.getString(10),Rs.getString(11),Rs.getString(12),Rs.getString(13)});
                
                
               
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String button=e.getActionCommand();
		System.out.println("bonjour");
		//model.removeRow();
		model.setRowCount(0);
		if(button.equalsIgnoreCase("indate"))
		{  
		    
			time=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
			
			operation="indate";
			
			vehicle();
		}
		if(button.equalsIgnoreCase("outdate"))
		{   
			time=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
			
			operation="outdate";
			vehicle();
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
		String caption=e.getSource().toString();
		if(code==10)
		{
			
			
			
			model.setRowCount(0);
			if(caption=="indate")
			{  
			    
				time=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
				
				operation="indate";
				
				vehicle();
			}
			if(caption.equalsIgnoreCase("outdate"))
			{   
				time=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
				
				operation="outdate";
				vehicle();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
