
package parking;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Toolkit;

public class ViewRules extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField text_1;
	private JTextField text_2;
	private JTextField text_3;
	private JTextField text_4;
	private JTextField text_5;
	ResultSet rs;
	PreparedStatement ps;
	Connection con;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ViewRules frame = new ViewRules();
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
	public ViewRules() {
		setTitle("Parking Rules");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewRules.class.getResource("/parking/images/icon_parking.png")));
		con = DataBaseConnection.createConnection();
		GUI();
		getRules();
	}
public void GUI()
{
	//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 719, 508);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(70, 130, 180));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	text_1 = new JTextField();
	text_1.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
	text_1.setForeground(Color.ORANGE);
	text_1.setEditable(false);
	text_1.setBounds(148, 64, 504, 36);
	contentPane.add(text_1);
	text_1.setColumns(10);
	
	text_2 = new JTextField();
	text_2.setForeground(Color.ORANGE);
	text_2.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
	text_2.setEditable(false);
	text_2.setColumns(10);
	text_2.setBounds(148, 117, 504, 36);
	contentPane.add(text_2);
	
	text_3 = new JTextField();
	text_3.setForeground(Color.ORANGE);
	text_3.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
	text_3.setEditable(false);
	text_3.setColumns(10);
	text_3.setBounds(148, 175, 504, 36);
	contentPane.add(text_3);
	
	text_4 = new JTextField();
	text_4.setForeground(Color.ORANGE);
	text_4.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
	text_4.setEditable(false);
	text_4.setColumns(10);
	text_4.setBounds(148, 234, 504, 36);
	contentPane.add(text_4);
	
	text_5 = new JTextField();
	text_5.setForeground(Color.ORANGE);
	text_5.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
	text_5.setEditable(false);
	text_5.setColumns(10);
	text_5.setBounds(148, 295, 504, 36);
	contentPane.add(text_5);
	
	JLabel lbl_Rule1 = new JLabel("RULE 1:");
	lbl_Rule1.setFont(new Font("Tahoma", Font.BOLD, 18));
	lbl_Rule1.setForeground(new Color(124, 252, 0));
	lbl_Rule1.setBounds(10, 64, 97, 36);
	contentPane.add(lbl_Rule1);
	
	JLabel lbl_Rule2 = new JLabel("RULE 2:");
	lbl_Rule2.setForeground(new Color(124, 252, 0));
	lbl_Rule2.setFont(new Font("Tahoma", Font.BOLD, 18));
	lbl_Rule2.setBounds(10, 117, 97, 36);
	contentPane.add(lbl_Rule2);
	
	JLabel lbl_Rule3 = new JLabel("RULE 3:");
	lbl_Rule3.setForeground(new Color(124, 252, 0));
	lbl_Rule3.setFont(new Font("Tahoma", Font.BOLD, 18));
	lbl_Rule3.setBounds(10, 175, 97, 36);
	contentPane.add(lbl_Rule3);
	
	JLabel lbl_Rule4 = new JLabel("RULE 4:");
	lbl_Rule4.setForeground(new Color(124, 252, 0));
	lbl_Rule4.setFont(new Font("Tahoma", Font.BOLD, 18));
	lbl_Rule4.setBounds(10, 234, 97, 36);
	contentPane.add(lbl_Rule4);
	
	JLabel lbl_Rule5 = new JLabel("RULE 5:");
	lbl_Rule5.setForeground(new Color(124, 252, 0));
	lbl_Rule5.setFont(new Font("Tahoma", Font.BOLD, 18));
	lbl_Rule5.setBounds(10, 295, 97, 36);
	contentPane.add(lbl_Rule5);
	
	
	setLocationRelativeTo(null);
}
public void getRules()
{  try
{
	String sql="select * from parkingrules";
	ps=con.prepareStatement(sql);
	rs=ps.executeQuery();
	int n=1;
	while(rs.next())
	{
	if (n==1)
	{
	text_1.setText(rs.getString(2));}
	if(n==2) {
	text_2.setText(rs.getString(2));}
	if(n==3) {
	text_3.setText(rs.getString(2));}
	if(n==4) {
	text_4.setText(rs.getString(2));}
	if(n==5) {
	text_5.setText(rs.getString(2));}
	n++;
}}
catch(SQLException se)
{
	se.printStackTrace();
}
finally
{
	  if(ps!= null)
		try {
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  if(rs!= null)
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	  
}
}
}


