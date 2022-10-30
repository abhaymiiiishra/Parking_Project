package parking;

//import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

//import com.sun.jdi.connect.spi.Connection;

public class Listener 
{
	
	public static void windowClosing(Connection con)
	{
	    if(con!=null)
	  {
		  
			try {
				con.close();
			}
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  } 
		   }
	
	
	
	
	
	}
	
	
	
	


