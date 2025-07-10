package com.demosourav.servlet;

import java.io.IOException;

import com.demosourav.model.User;
import com.demosourav.service.UserAuthentication;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/authenticate")
public class LoginServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
//		String method = req.getMethod();
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		UserAuthentication obj = new UserAuthentication();
		User user = obj.checkUser(username, password);
		
		if (user != null) {
            HttpSession session = req.getSession();
            session.setAttribute("currentUser", user);
            session.setAttribute("role", user.getRole());

            // Redirect based on role
            switch (user.getRole()) {
                case "ADMIN":
                    res.sendRedirect("dashboard-admin.jsp");
                    break;
                case "EMPLOYEE":
                    res.sendRedirect("dashboard-employee.jsp");
                    break;
                case "FACILITY_MANAGER":
                    res.sendRedirect("dashboard-manager.jsp");
                    break;
                default:
                    res.sendRedirect("login.jsp?error=role");
            }
        } else {
            res.sendRedirect("login.jsp?error=invalid");
        }
    }
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		doGet(req, res);
	}
}
