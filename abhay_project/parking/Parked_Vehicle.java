package parking;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;
import javax.swing.ScrollPaneConstants;

public class Parked_Vehicle extends JFrame {

	private JPanel contentPane;
	DefaultTableModel model = new DefaultTableModel();
	private JTable table;
	Connection con;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Parked_Vehicle frame = new Parked_Vehicle();
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
	public Parked_Vehicle() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Parked_Vehicle.class.getResource("/parking/images/icon_parking.png")));
		setTitle("Parked Vehicle");
		con=DataBaseConnection.createConnection();
		GUI();
	}
	public void GUI()
	{
		
		setBounds(100, 100, 731, 467);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 130, 180));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 695, 406);
		contentPane.add(scrollPane);
		
		table = new JTable(model);
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		model.addColumn("Parking ID");
        model.addColumn("Checkin ID");
        model.addColumn("Token ID");
        model.addColumn("Vehicle Type");
        model.addColumn("Vehicle NO.");
        model.addColumn("IN Date");
        model.addColumn("IN Time");
        model.addColumn("Status");
        table.getTableHeader().setBackground(Color.yellow);
        
        setLocationRelativeTo(null);
		
        
        vehicle();
		
	}
	public void vehicle()
	{
		 try {
	        	
	          
	            PreparedStatement pstm = con.prepareStatement("SELECT * FROM vehicledetails where status='checkin'");
	            ResultSet Rs = pstm.executeQuery();
	            while(Rs.next()){
	                model.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getString(3),Rs.getString(4),Rs.getString(5),Rs.getString(6),Rs.getString(7),Rs.getString(13)});
	            }
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	}

}
