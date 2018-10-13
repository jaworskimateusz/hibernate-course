package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/hb_cars?useSSL=false&serverTimezone=UTC";
		String user = "hbcars";
		String password = "hbcars";
		
		try {
			System.out.println("Start connecting to database: " + url);
			Connection connection =
					DriverManager.getConnection(url, user, password);
			System.out.println("\nConnection successful!");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
