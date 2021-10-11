package at.stderr.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

    public static void main(String[] args) {
        String jdbcURL = "jdbc:postgresql://worker01.lan.stderr.at:32101/hb-01-one-to-one-uni";
        String username = "";
        String password = "";

        try {
            Connection myConn = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println(myConn);
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
