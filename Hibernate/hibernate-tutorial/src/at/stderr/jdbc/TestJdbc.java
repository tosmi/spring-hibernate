package at.stderr.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		var jdbcURL = "jdbc:postgresql://worker01.lan.stderr.at:32101/hb_student_tracker";
		var username = "hbstudent";
		var password = "hbstudentzzz";
		
		try {
		
			System.out.println("Connecting to database " + jdbcURL);
			
		 	Connection connection = DriverManager.getConnection(jdbcURL, username, password);

			System.out.println("Connection successful!");
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
