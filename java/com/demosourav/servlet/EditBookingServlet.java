package com.demosourav.servlet;

import java.io.IOException;

import com.demosourav.service.EditBookingService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/edit-booking")
public class EditBookingServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int bookingId = Integer.parseInt(req.getParameter("id"));
        String bookingDate = req.getParameter("date");
        String startTime = req.getParameter("startTime");
        String endTime = req.getParameter("endTime");
        String purpose = req.getParameter("purpose");
        
        EditBookingService editBookingservice = new EditBookingService();
        int result = editBookingservice.updateBooking(bookingId, bookingDate, startTime, endTime, purpose);
        
        if (result > 0) {
        res.sendRedirect("my-bookings.jsp");
        }else {
        	res.sendRedirect("edit-bookings.jsp");
        }
}
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

	doGet(req,res);
}
}