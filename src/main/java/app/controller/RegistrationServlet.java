package app.controller;

import app.beans.User;
import app.dao.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;

public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/registration.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password1");
        String repassword = req.getParameter("password2");
        PrintWriter writer = resp.getWriter();
        if (password.equals(repassword)) {
            User user = new User(name, password);
            UserDAO userDAO = new UserDAO();
            User test = userDAO.registerUser(user);
            if (test.equals(user)) {
                writer.println("success!");
            }
            else {
                writer.println("problem");
            }
        }
        else {
            writer.println("problem");
        }
    }
}
