package database;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
public class SetRegisterr {
	public static void setLogin(String usr, String pass) throws ClassNotFoundException, SQLException {
		try(Connection conn = Dbconnect.initializeDatabase();
	            Statement stmt = conn.createStatement();
	        ) {
			
			String sql = "INSERT INTO login VALUES(?,?)";
	                
				
	                PreparedStatement statement = conn.prepareStatement(sql);
	                statement.setString(1, usr);
	                statement.setString(2, pass);
	                
	                int x = statement.executeUpdate();
	                System.out.println(x);
	                } 
	}
//	public static Connection initializeDatabase() 
//    throws SQLException, ClassNotFoundException 
//{ 
//    // Initialize all the information regarding 
//    // Database Connection  
//    String dbURL = "jdbc:mysql://localhost:3306/demosite"; 
//    // Database name to access 
//     
//    String dbUsername = "root"; 
//    String dbPassword = "1234"; 
//
//    Connection con = DriverManager.getConnection(dbURL , 
//                                                 dbUsername,  
//                                                 dbPassword); 
//    return con; 
//}
	public static void setInfo(String usr, String name, String city) throws ClassNotFoundException, SQLException {
		try(Connection conn = Dbconnect.initializeDatabase();
	            Statement stmt = conn.createStatement();
	        ) {
			
			String sql = "INSERT INTO info VALUES(?,?,?)";
	                
				
	                PreparedStatement statement = conn.prepareStatement(sql);
	                statement.setString(1, name);
	                statement.setString(2, usr);
	                statement.setString(3, city);
	                
	                int x = statement.executeUpdate();
	                System.out.println(x);
	                } 
	                
		}
	}