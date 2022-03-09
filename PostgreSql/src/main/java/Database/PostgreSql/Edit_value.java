package Database.PostgreSql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Edit_value {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		Statement statement = null;

		dataBaseConnection sqlconnect = new dataBaseConnection();
		connection = sqlconnect.get_connection();

		try {
			
			String query = "update Employee set name='bhau' where id='1' ";
			statement = connection.createStatement();
			statement.executeUpdate(query);
			System.out.println("updATED");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
