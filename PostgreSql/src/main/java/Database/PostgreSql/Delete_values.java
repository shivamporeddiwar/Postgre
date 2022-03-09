package Database.PostgreSql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete_values {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		Statement statement = null;

		dataBaseConnection sqlconnect = new dataBaseConnection();
		connection = sqlconnect.get_connection();

		try {
			
			String query = "delete from Employee  where id='0' ";
			statement = connection.createStatement();
			statement.executeUpdate(query);
			System.out.println("Deleted");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
