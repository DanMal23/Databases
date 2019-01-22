package db_table1;

/**
 * The program creates an application
 * connected to MySQL databases.
 * It displays 1 table.
 * You can add data, remove it or
 * edit table rows and update year 
 * using UI controls.
 */

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LGSdatabases {

	Connection connection;
	Statement statement;

	public static void main(String[] args) {
		LGSdatabases object = new LGSdatabases();
		object.createConnection();
		object.callableExample();
		object.callableExample2();
		object.callableExample3();
		object.addBatch(); // adding new rows / batch

	}

	void createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false"
			// +
			// "/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
					, "root", "maailmdmroot");
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM LGS"); // accessing data
			System.out.println("-----Successful Database Connection: -----");
			while (rs.next()) {
				String name = rs.getString("name");
				String progrlang = rs.getString("progrlang");
				int year = rs.getInt("year");
				System.out.println(progrlang + ", developed by " + name + " in:  " + year);
			}
			statement.close();

		} catch (SQLException | ClassNotFoundException ex) {

		}
	}

	void callableExample() {
		try {
			CallableStatement cstmt = connection.prepareCall("{call procedure1()}");
			Boolean hasResult = cstmt.execute();
			if (hasResult) {
				ResultSet rset = cstmt.getResultSet();
				System.out
						.println("----------all 'name' selected in Callable Procedure via mySQL Workbench : ---------");
				while (rset.next()) {
					System.out.println(rset.getString("name"));
				}
				cstmt.close();
			}

		} catch (SQLException ex) {
			Logger.getLogger(LGSdatabases.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	void callableExample2() {
		try {
			CallableStatement cstmt = connection.prepareCall("{call procedure2(?)}"); // (?) - calling 1 parameter
			cstmt.setInt(1, 2000); // years after 2000
			Boolean hasResult = cstmt.execute();
			if (hasResult) {
				ResultSet rset = cstmt.getResultSet();
				System.out.println("------names of developers who created lgs after 2000 : ------------");
				while (rset.next()) {
					System.out.println(rset.getString("name"));
				}
				cstmt.close();
			}

		} catch (SQLException ex) {
			Logger.getLogger(LGSdatabases.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	void callableExample3() {
		try {
			CallableStatement cstmt = connection.prepareCall("{call procedure3(?,?)}"); // (?,?) - calling 2 parameters
			cstmt.setInt(1, 1994); // years after ...
			cstmt.registerOutParameter(2, java.sql.Types.INTEGER); // second parameter is an integer
			Boolean hasResult = cstmt.execute();
			if (hasResult) {
				int countReturned = cstmt.getInt(2);

				System.out.println("-> Number of devs who created lgs after 1994 : " + countReturned);
				ResultSet rset = cstmt.getResultSet();
				while (rset.next()) {
					System.out.println(rset.getString("name"));
				}
				cstmt.close();
			}

		} catch (SQLException ex) {
			Logger.getLogger(LGSdatabases.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	void addBatch() {
		try {
			statement = connection.createStatement();
			statement.addBatch("INSERT INTO LGS VALUES( 'MATSUMOTO', 'RUBY', 1995) ");
			statement.addBatch("INSERT INTO LGS VALUES( 'ODERSKY', 'SCALA', 2004) ");
			statement.addBatch("INSERT INTO LGS VALUES( 'STROUSTRUP', 'C++', 1985) ");
			int[] arr = statement.executeBatch();
			for (int i : arr) {
				System.out.print(i);
			}
			statement.close();
		} catch (SQLException ex) {
			Logger.getLogger(LGSdatabases.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
