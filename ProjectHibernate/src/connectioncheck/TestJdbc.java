package connectioncheck;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
	public static void main(String[] args) throws Exception {

		// in the string: JDBC Url, user, password
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

		if (connection != null) {
			System.out.println("Successfully connected to 'mydb' database in phpMyAdmin");

		}
	}
}
