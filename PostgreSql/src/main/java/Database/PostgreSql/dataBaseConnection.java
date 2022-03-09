package Database.PostgreSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//import com.mysql.cj.xdevapi.Statement;

public class dataBaseConnection {
 
	private final String url = "jdbc:postgresql://localhost:5432/postgres";
	private final String user = "postgres";
	private final String password = "!3ptE5k9N*";

	public  Connection get_connection() throws SQLException {
		Connection connection = DriverManager.getConnection(url, user, password);

		try  {
			if (connection != null) {

				System.out.println("connection Ok");
				return connection; 
			} else {
				System.out.println("connection failed");
			}
		} catch (Exception e) {
			System.out.println("e");
		}
		return null;
	}
	public static void main (String [] args ) {
		dataBaseConnection sqlconnect = new dataBaseConnection();

		
	
		
	}

	
}
