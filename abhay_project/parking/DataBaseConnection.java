package parking;

import java.sql.*;

public class DataBaseConnection {
private static Connection con;
public static Connection createConnection()
{
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parking","root","patvardhan");
	}
	catch(ClassNotFoundException|SQLException cs)
	{
		cs.printStackTrace();
	}
	return con;
	
	
}

}
