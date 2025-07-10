package com.demosourav.servlet;

import java.io.IOException;

import com.demosourav.service.CancelBookingService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cancel-booking")
public class CancelBookingServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
		
		int bookingId = Integer.parseInt(req.getParameter("id"));
		
		CancelBookingService cancelBookingService = new CancelBookingService();
        cancelBookingService.cancelBooking(bookingId);
        res.sendRedirect("my-bookings.jsp");

}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
		doGet(req,res);
	}
}

