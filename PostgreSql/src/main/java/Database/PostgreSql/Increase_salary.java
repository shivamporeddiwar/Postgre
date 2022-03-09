package Database.PostgreSql;
import java.sql.*;


public class Increase_salary{

	public static void main(String[] args) throws Exception {

		Connection myConn = null;
		CallableStatement myStmt = null;

		try {
			// Get a connection to database
			dataBaseConnection sqlconnect = new dataBaseConnection();
			myConn=sqlconnect.get_connection();

			Integer id = 1 ;
			int theIncreaseAmount = 10000;
			
////			Show salaries BEFORE
//			System.out.println("Salaries BEFORE\n");
//			showSalaries(myConn, id);

			// Prepare the stored procedure call
			myStmt = myConn
					.prepareCall("{emp_salary(?, ?)}");

			// Set the parameters
			myStmt.setLong(1, id);
			myStmt.setDouble(2, theIncreaseAmount);

			// Call stored procedure
			System.out.println("\n\nCalling stored procedure.emp_salary('" + id + "', " + theIncreaseAmount + ")");
			myStmt.execute();
			System.out.println("Finished calling stored procedure");

			// Show salaries AFTER
			System.out.println("\n\nSalaries AFTER\n");
			showSalaries(myConn, id);

		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			close(myConn, myStmt, null);
		}
	}

	private static void showSalaries(Connection myConn, Integer id) throws SQLException {
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			// Prepare statement
			myStmt = myConn
					.prepareStatement("call emp_salary where id=? ");

			myStmt.setInt(1, id);
			
			// Execute SQL query
			myRs = myStmt.executeQuery();

			// Process result set
			while (myRs.next()) {
				Integer id1 = myRs.getInt("id");
				String name = myRs.getString("name");
				double salary = myRs.getDouble("salary");
				
				System.out.printf("%s, %s, %s, %.2f\n", id1, name, salary);
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			close(myStmt, myRs);
		}

	}

	private static void close(Connection myConn, Statement myStmt,
			ResultSet myRs) throws SQLException {
		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			myStmt.close();
		}

		if (myConn != null) {
			myConn.close();
		}
	}

	private static void close(Statement myStmt, ResultSet myRs)
			throws SQLException {

		close(null, myStmt, myRs);
	}
}
