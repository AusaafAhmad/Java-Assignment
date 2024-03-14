package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SetCity {
	public static void setnew(String usr, String newcity) throws ClassNotFoundException, SQLException {
		try(Connection conn = Dbconnect.initializeDatabase();
	            Statement stmt = conn.createStatement();
	        ) {
			
			String sql = "UPDATE info set city=? where user=?";
	                
				
	                PreparedStatement statement = conn.prepareStatement(sql);
	                statement.setString(1, newcity);
	                statement.setString(2, usr);
	                
	                int x = statement.executeUpdate();
	                System.out.println(x);
	                } 
	}
}
