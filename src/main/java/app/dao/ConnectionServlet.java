package app.dao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        try {
            String url = "jdbc:mysql://localhost/committee?serverTimezone=Europe/Minsk&useSSL=false";
            String username = "root";
            String password = "want./1007";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection con = DriverManager.getConnection(url, username, password)) {
                writer.println("Connection successfull");
            }
        }
        catch (Exception e) {
            writer.println("Connection failed");
        }
        finally {
            writer.close();
        }
        //RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        //requestDispatcher.forward(req,resp);
    }
}
