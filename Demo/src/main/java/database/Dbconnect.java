package database;
import java.sql.*;
public class Dbconnect {
	public static Connection initializeDatabase() 
    throws SQLException, ClassNotFoundException 
{ 
    // Initialize all the information regarding 
    // Database Connection  
    String dbURL = "jdbc:mysql://localhost:3306/demosite"; 
    // Database name to access 
     
    String dbUsername = "root"; 
    String dbPassword = "1234"; 

    Connection con = DriverManager.getConnection(dbURL , 
                                                 dbUsername,  
                                                 dbPassword); 
    return con; 
}
	public static String getpassword(String usr) throws ClassNotFoundException, SQLException {
		try(Connection conn = Dbconnect.initializeDatabase();
	            Statement stmt = conn.createStatement();
	        ) {
			
			String sql = "SELECT pass FROM login WHERE user = ?";
	                
				
	                PreparedStatement statement = conn.prepareStatement(sql);
	                statement.setString(1, usr);
	                ResultSet resultSet = statement.executeQuery();

	                if (resultSet.next()) {
	                    String passwordRetrieved = resultSet.getString("pass");
	                    return(passwordRetrieved);
	                    
	                } 
	                return null;}
	}
//	public static void main(String[] args) {
//		System.out.println(getpassword("Metal"));
//	}
	}
