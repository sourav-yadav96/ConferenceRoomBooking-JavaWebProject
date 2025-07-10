package com.demosourav.servlet;

import java.io.IOException;

import com.demosourav.model.User;
import com.demosourav.service.UserRegistration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet  {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
		
		User user = new User();
		String username = req.getParameter("username");
		user.setUsername(username);
        String email = req.getParameter("email");
        user.setEmail(email);
        String password = req.getParameter("password");
        user.setPassword(password);
        String role = req.getParameter("role");
        user.setRole(role);
        
        UserRegistration userreg = new UserRegistration();
        boolean success = userreg.registerUser(user);
        
//        if (success) {
//            req.setAttribute("message", "Registration successful! You can now log in.");
//        } else {
//            req.setAttribute("message", "Registration failed. Username or Email may already exist.");
//        }
//
//        try {
//			req.getRequestDispatcher("login.jsp").forward(req, res);
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        
        if(success==true) {
        	res.sendRedirect("login.jsp");
        }else {
        	res.sendRedirect("register.jsp");
        }
    }
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		doGet(req, res);
	}
}
