package at.stderr.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

    public static void main(String[] args) {
        String jdbcURL = "jdbc:postgresql://lb.lan.stderr.at:5432/hb_student_tracker?schema=hb-01-one-to-one-uni";
        String username = "hbstudent";
        String password = "hbstudent";

        try {
            Connection myConn = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println(myConn);
            System.out.println("Connection successful!");
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
