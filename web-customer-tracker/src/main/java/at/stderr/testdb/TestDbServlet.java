package at.stderr.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet(name = "TestDbServlet", value = "/TestDbServlet")
public class TestDbServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // setup db connection variables
        String user = "springstudent";
        String password = "springstudent";

        String jdbcURL = "jdbc:postgresql://lb.lan.stderr.at:5432/web_customer_tracker";
        String driver = "org.postgresql.Driver";

        try {
            PrintWriter out = response.getWriter();
            out.println("Connecting to database: " + jdbcURL);

            Class.forName(driver);

            Connection conn = DriverManager.getConnection(jdbcURL, user, password);
            out.println("Connection successful");

            conn.close();
        }
        catch(Exception exc) {
            exc.printStackTrace();
            throw new ServletException(exc);
        }
    }
}
