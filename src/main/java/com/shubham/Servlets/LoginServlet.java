package com.shubham.Servlets;

import com.shubham.services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            userService.authorizeUser(email, password)
                    .ifPresent(user -> req.setAttribute("user", user));
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher(
                "/WEB-INF/jsp/user-display.jsp");
        dispatcher.forward(req, resp);

    }
}
