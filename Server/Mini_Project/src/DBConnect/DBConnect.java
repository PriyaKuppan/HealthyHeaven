package DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	 public Connection Con ;
		String dburl="jdbc:mysql://localhost:3306/healthyheaven";
		String dbuser="root";
		String dbpass="Priya@0501";
		

	 public  DBConnect() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		     Con=DriverManager.getConnection(dburl, dbuser, dbpass);
		     System.out.println("Connected successfuly...");
		     
		       
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}

}
