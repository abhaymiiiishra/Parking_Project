package parking;
import javax.swing.*;
import java.awt.*;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.Dialog.ModalExclusionType;
//import java.awt.Dialog.ModalExclusionType;
//import java.awt.Window.Type;
public class ViewParkingCharge extends JFrame implements WindowListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DefaultTableModel model = new DefaultTableModel();
    Container cnt = this.getContentPane();
    JTable jtbl = new JTable(model);
    
    
    public ViewParkingCharge() {
    	setTitle("Parking Charge");
    	setResizable(false);
    	setIconImage(Toolkit.getDefaultToolkit().getImage(ViewParkingCharge.class.getResource("/parking/images/icon_parking.png")));
    	
    	setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
    	setBackground(new Color(70, 130, 180));
    	getContentPane().setBackground(new Color(70, 130, 180));
    	setType(Type.POPUP);
        model.addColumn("Vehicle Type");
        model.addColumn("Charge/hr");
        
        model.addColumn("weekday_charge");
        model.addColumn("weekend_charge");
        jtbl.getTableHeader().setBackground(Color.yellow);
       // model.setDefaultEditor(this, null);
        try {
        	
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/parking", "root", "patvardhan");
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM parking_charge");
            ResultSet Rs = pstm.executeQuery();
            while(Rs.next()){
                model.addRow(new Object[]{Rs.getString(1), Rs.getString(2),Rs.getString(3),Rs.getString(4)});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        jtbl.setForeground(new Color(0, 0, 128));
        jtbl.setBackground(new Color(255, 250, 250));
       
        
        getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        jtbl.setEnabled(false);
        jtbl.setRowSelectionAllowed(false);
        JScrollPane pg = new JScrollPane(jtbl);
        cnt.add(pg);
        this.pack();
        
        
        setLocationRelativeTo(null);
    }

public static void main(String[] args) {
 JFrame frame = new ViewParkingCharge();
            frame.setTitle("Swing Example");
            frame.setResizable(true);
            frame.setSize(500, 483);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            
        }

@Override
public void windowOpened(WindowEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void windowClosing(WindowEvent e) {
	// TODO Auto-generated method stub
	if(login_details.usertype=="admin")
	{
		AdminDashboard frame=new AdminDashboard();
		frame.setVisible(true);
	}
	if(login_details.usertype.equalsIgnoreCase("staff-entry"))
	{
		Entry_Dashboard frame=new Entry_Dashboard();
		frame.setVisible(true);
	}
	if(login_details.usertype.equalsIgnoreCase("staff-exit"))
	{
		Exit_Dashboard frame=new Exit_Dashboard();
				frame.setVisible(true);
	}
}

@Override
public void windowClosed(WindowEvent e) {
	// TODO Auto-generated method stub
	
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
