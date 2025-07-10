package com.demosourav.servlet;

import java.io.IOException;
import java.util.List;
import com.demosourav.service.UserManagementService;

import com.demosourav.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/users")
public class UserManagementServlet extends HttpServlet{
	
	public UserManagementService userManagementService = new UserManagementService();
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
		
        String action = req.getParameter("action");
        if ("delete".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            userManagementService.deleteUser(id);
            res.sendRedirect("users");
        } 
        else if (req.getParameter("id") != null) {
            int id = Integer.parseInt(req.getParameter("id"));
            User user = userManagementService.getUserById(id);
            req.setAttribute("user", user);
            req.getRequestDispatcher("users-form.jsp").forward(req, res);
        }
        else {
            List<User> users = userManagementService.getAllUsers();
            req.setAttribute("users", users);
            req.getRequestDispatcher("users-management.jsp").forward(req, res);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);

        String idStr = req.getParameter("id");
        if (idStr != null) {
            user.setId(Integer.parseInt(idStr));
            userManagementService.updateUser(user);
        } else {
            userManagementService.addUser(user);
        }

        res.sendRedirect("users");
    }

}
