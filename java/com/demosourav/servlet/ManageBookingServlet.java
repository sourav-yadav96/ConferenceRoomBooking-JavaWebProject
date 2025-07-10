package com.demosourav.servlet;

import java.io.IOException;
import java.util.List;

import com.demosourav.model.Booking;
import com.demosourav.service.ManageBookingService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/conflicts")
public class ManageBookingServlet extends HttpServlet{
	
	public ManageBookingService manageBookingService = new ManageBookingService();
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<Booking> conflicts = manageBookingService.getAllPendingBookings();
        req.setAttribute("conflicts", conflicts);
        req.getRequestDispatcher("manage-bookings.jsp").forward(req, resp);
    }

   
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int bookingId = Integer.parseInt(req.getParameter("bookingId"));
        String action = req.getParameter("action");

        if ("approve".equals(action)) {
        	manageBookingService.approveBooking(bookingId);
        } else if ("reschedule".equals(action)) {
            String newTime = req.getParameter("newTime");
            manageBookingService.rescheduleBooking(bookingId, newTime);
        } else if ("cancel".equals(action)) {
        	manageBookingService.cancelBooking(bookingId);
        }

        resp.sendRedirect("conflicts");
    }

}
