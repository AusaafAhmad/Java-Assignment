package database;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Getval {
	public static String[] getinfo(String usr) throws ClassNotFoundException, SQLException {
		try(Connection conn = Dbconnect.initializeDatabase();
	            Statement stmt = conn.createStatement();
	        ) {
			
			String sql = "select * from info where user= ?";
	                
				
	                PreparedStatement statement = conn.prepareStatement(sql);
	                statement.setString(1, usr);
	                ResultSet rs= statement.executeQuery();
	                String[] arr = new String[3];
	                while(rs.next())
	                {
	                	arr[0] = rs.getString("name");
	                	arr[1] = rs.getString("city");
	                	arr[2] = rs.getString("user");
	                }
	               return arr;
	           } 
	}

}