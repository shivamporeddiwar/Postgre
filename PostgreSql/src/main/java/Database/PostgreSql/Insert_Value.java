package Database.PostgreSql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert_Value {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		Statement statement = null;
		dataBaseConnection sqlconnect = new dataBaseConnection();
		connection=sqlconnect.get_connection();
		
		try {
			 
			String query = "insert into Employee(id,name,city) values(4,'BINU','BIH')";
			statement = connection.createStatement();
			statement.executeUpdate(query);
			
			System.out.println("values inserted  successfully ");
		
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
