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
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Toolkit;

public class UpdateRules extends JFrame implements ActionListener,KeyListener{

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
	JButton btn_update_1;
	ResultSet rs;
	PreparedStatement ps;
	Connection con;
	String rule;
	int status,del;
	Object caption;
	private JButton btn_update_2;
	private JButton btn_update_3;
	private JButton btn_update_4;
	private JButton btn_update_5;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UpdateRules frame = new UpdateRules();
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
	public UpdateRules() {
		setTitle("Update Rules");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(UpdateRules.class.getResource("/parking/images/icon_parking.png")));
		con = DataBaseConnection.createConnection();
		GUI();
		getRules();
		
	}
public void GUI()
{
	
	setBounds(100, 100, 781, 508);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(176, 196, 222));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	text_1 = new JTextField();
	text_1.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
	text_1.setForeground(Color.ORANGE);
	text_1.setBounds(125, 53, 504, 36);
	contentPane.add(text_1);
	text_1.setColumns(10);
	
	text_2 = new JTextField();
	text_2.setForeground(Color.ORANGE);
	text_2.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
	text_2.setColumns(10);
	text_2.setBounds(125, 118, 504, 36);
	contentPane.add(text_2);
	
	text_3 = new JTextField();
	text_3.setForeground(Color.ORANGE);
	text_3.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
	text_3.setColumns(10);
	text_3.setBounds(125, 176, 504, 36);
	contentPane.add(text_3);
	
	text_4 = new JTextField();
	text_4.setForeground(Color.ORANGE);
	text_4.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
	text_4.setColumns(10);
	text_4.setBounds(125, 235, 504, 36);
	contentPane.add(text_4);
	
	text_5 = new JTextField();
	text_5.setForeground(Color.ORANGE);
	text_5.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
	text_5.setColumns(10);
	text_5.setBounds(125, 296, 504, 36);
	contentPane.add(text_5);
	
	JLabel lbl_Rule1 = new JLabel("RULE 1:");
	lbl_Rule1.setFont(new Font("Tahoma", Font.BOLD, 18));
	lbl_Rule1.setForeground(new Color(105, 105, 105));
	lbl_Rule1.setBounds(10, 52, 82, 36);
	contentPane.add(lbl_Rule1);
	
	JLabel lbl_Rule2 = new JLabel("RULE 2:");
	lbl_Rule2.setForeground(SystemColor.controlDkShadow);
	lbl_Rule2.setFont(new Font("Tahoma", Font.BOLD, 18));
	lbl_Rule2.setBounds(10, 117, 82, 36);
	contentPane.add(lbl_Rule2);
	
	JLabel lbl_Rule3 = new JLabel("RULE 3:");
	lbl_Rule3.setForeground(SystemColor.controlDkShadow);
	lbl_Rule3.setFont(new Font("Tahoma", Font.BOLD, 18));
	lbl_Rule3.setBounds(10, 175, 82, 36);
	contentPane.add(lbl_Rule3);
	
	JLabel lbl_Rule4 = new JLabel("RULE 4:");
	lbl_Rule4.setForeground(SystemColor.controlDkShadow);
	lbl_Rule4.setFont(new Font("Tahoma", Font.BOLD, 18));
	lbl_Rule4.setBounds(10, 234, 82, 36);
	contentPane.add(lbl_Rule4);
	
	JLabel lbl_Rule5 = new JLabel("RULE 5:");
	lbl_Rule5.setForeground(SystemColor.controlDkShadow);
	lbl_Rule5.setFont(new Font("Tahoma", Font.BOLD, 18));
	lbl_Rule5.setBounds(10, 295, 82, 36);
	contentPane.add(lbl_Rule5);
	
	btn_update_1 = new JButton("UPDATE");
	btn_update_1.setBackground(new Color(255, 255, 0));
	btn_update_1.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
	btn_update_1.setForeground(new Color(128, 128, 0));
	btn_update_1.setBounds(640, 66, 115, 23);
	btn_update_1.addActionListener(this);
	btn_update_1.addKeyListener(this);
	contentPane.add(btn_update_1);
	
	btn_update_2 = new JButton("UPDATE");
	btn_update_2.setBackground(new Color(255, 255, 0));
	btn_update_2.setForeground(new Color(128, 128, 0));
	btn_update_2.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
	btn_update_2.setBounds(640, 131, 115, 23);
	btn_update_2.addActionListener(this);
	btn_update_2.addKeyListener(this);
	contentPane.add(btn_update_2);
	
	btn_update_3 = new JButton("UPDATE");
	btn_update_3.setBackground(new Color(255, 255, 0));
	btn_update_3.setForeground(new Color(128, 128, 0));
	btn_update_3.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
	btn_update_3.setBounds(640, 185, 115, 23);
	btn_update_3.addActionListener(this);
	btn_update_3.addKeyListener(this);
	contentPane.add(btn_update_3);
	
	btn_update_4 = new JButton("UPDATE");
	btn_update_4.setBackground(new Color(255, 255, 0));
	btn_update_4.setForeground(new Color(128, 128, 0));
	btn_update_4.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
	btn_update_4.setBounds(640, 248, 115, 23);
	btn_update_4.addActionListener(this);
	btn_update_4.addKeyListener(this);
	contentPane.add(btn_update_4);
	
	btn_update_5 = new JButton("UPDATE");
	btn_update_5.setBackground(new Color(255, 255, 0));
	btn_update_5.setForeground(new Color(128, 128, 0));
	btn_update_5.setFont(new Font("Source Sans Pro Semibold", Font.BOLD, 18));
	btn_update_5.setBounds(640, 309, 115, 23);
	btn_update_5.addActionListener(this);
	btn_update_5.addKeyListener(this);
	contentPane.add(btn_update_5);
	
	
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
}
	}
catch(SQLException se)
{
	se.printStackTrace();
}

}
public void update()
{ try {
	String sql="update parkingrules set Rules=? where serial=?";
	ps=con.prepareStatement(sql);
	ps.setString(1, rule);
	ps.setInt(2,del);
	
	status=ps.executeUpdate();
	JOptionPane.showMessageDialog(this,"Parking Rule Updated");
	
}
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
     caption=e.getSource();
	
	   button();
	   int result=JOptionPane.showConfirmDialog(this, "Are You Sure You Want To Update Rule","",JOptionPane.YES_NO_OPTION);
	   if(result == JOptionPane.YES_OPTION){
          update();
        }else if (result == JOptionPane.NO_OPTION){
        
       }
	}
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void actionPerformed(ActionEvent e) {
	
	caption=e.getSource();
	
	button();
	int result=JOptionPane.showConfirmDialog(this, "Are You Sure You Want To Update Rule","",JOptionPane.YES_NO_OPTION);
	if(result == JOptionPane.YES_OPTION){
        update();
     }else if (result == JOptionPane.NO_OPTION){
        
     }

	
	
}
public void button()
{
	
	if(caption==btn_update_1)
	{
		del=1;
		rule=text_1.getText();
		
	}
	if(caption==btn_update_2)
	{
		del=2;
		
		rule=text_2.getText();
	}
	if(caption==btn_update_3)
	{
		del=3;
		rule=text_3.getText();
		
	}
	if(caption==btn_update_4)
	{
		del=4;
		
		rule=text_4.getText();
	}
	if(caption==btn_update_5)
	{
		del=5;
		rule=text_5.getText();
		
	}
	
}
}



