package Database.PostgreSql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Calling_Procedure {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		Statement statement = null;

		dataBaseConnection sqlconnect = new dataBaseConnection();
		connection = sqlconnect.get_connection();

		try {
			String query = "insert into emp_salary(id,name,city) values(10,'ROCK','UP')";
		 CallableStatement cstmt = connection.prepareCall("{Call emp_infor(?,?,?) }");
		 
			cstmt.setInt(query, 1);
			cstmt.setInt(query, 2);
			cstmt.setInt(query, 3);

			cstmt.execute();
			
//			statement = connection.createStatement();
//			statement.executeUpdate(query);
			
			System.out.println("updated");
			
		} catch (Exception e) {
			e.printStackTrace();
//			System.out.println("exception");
		}
	}

}