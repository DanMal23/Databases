
package db_tables;

/**
 * The program creates an application
 * connected to MySQL databases.
 * It consists of 2 tables.
 * You can add data or remove it 
 * from both, using UI controls.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBProject1 {
	Connection con;
	Statement stmt;

	public static void main(String[] args) {
		DBProject1 project = new DBProject1();
		project.createConnection();
	}

	void createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false",
					"root", "root");
			stmt = con.createStatement();
			ResultSet rset = stmt.executeQuery("SELECT * FROM LDDB");
			while (rset.next()) {
				String linuxdistro = rset.getString("linuxdistro");
				int year = rset.getInt("year");
				System.out.println(linuxdistro + ", since  " + year);
			}
			stmt.close();

		} catch (SQLException | ClassNotFoundException ex) {

		}

	}

}
