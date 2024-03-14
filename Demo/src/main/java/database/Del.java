package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Del {
	public static void profile(String usr) throws ClassNotFoundException, SQLException {
		try(Connection conn = Dbconnect.initializeDatabase();
	            Statement stmt = conn.createStatement();
	        ) {
			
			String sql = "DELETE FROM info where user=?";
			PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setString(1, usr);
	        int x = statement.executeUpdate();
	        System.out.println(x);
	        sql = "DELETE FROM login where user=?";
	        statement = conn.prepareStatement(sql);
	        statement.setString(1, usr);
	        x = statement.executeUpdate();
	        System.out.println(x);
	        
	                } 
	}
}
