package com.demosourav.servlet;

import java.io.IOException;
import java.util.List;

import com.demosourav.model.Booking;
import com.demosourav.model.User;
import com.demosourav.service.MyBookingService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/my-bookings")
public class MyBookingServlet extends HttpServlet {
	
	public MyBookingService mybookingservice = new MyBookingService();
    
	public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("currentUser") == null) {
            res.sendRedirect("login.jsp");
            return;
        }

        int userId = ((User) session.getAttribute("currentUser")).getId();
        List<Booking> bookings = mybookingservice.getBookingsByUser(userId);

        req.setAttribute("bookings", bookings);
        req.getRequestDispatcher("my-bookings.jsp").forward(req, res);
    }
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doGet(req, res);
	}
}

