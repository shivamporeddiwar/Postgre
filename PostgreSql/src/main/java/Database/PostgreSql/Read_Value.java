package Database.PostgreSql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.ibm.db2.jcc.am.ResultSet;

public class Read_Value {
	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		Statement statement = null;
		java.sql.ResultSet rs =null;
		dataBaseConnection sqlconnect = new dataBaseConnection();
		connection=sqlconnect.get_connection();
		try {
			String query = " Select * from Employee" ;
			statement = connection.createStatement();
			rs= statement.executeQuery(query);
			
			while(rs.next()) {
				System.out.print(rs.getString(1));
				
				System.out.print(rs.getString(2));
				
				System.out.println(rs.getString(3));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
