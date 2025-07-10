package com.demosourav.servlet;

import java.io.IOException;
import java.util.List;

import com.demosourav.service.RoomBookingService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/bookRoom")
public class RoomBookServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("currentUser") == null) {
            res.sendRedirect("login.jsp");
            return;
        }
        
        int roomId = Integer.parseInt(req.getParameter("roomId"));
        String date = req.getParameter("date");
        String startTime = req.getParameter("startTime");
        String endTime = req.getParameter("endTime");
        String purpose = req.getParameter("purpose");
        String requests = req.getParameter("requests");
        
        int userId = ((com.demosourav.model.User) session.getAttribute("currentUser")).getId();
        
        RoomBookingService roomBookingService = new RoomBookingService();
        boolean success = roomBookingService.bookRoomWithTime(roomId, userId, date, startTime, endTime, purpose, requests);
        
        if (success==true) {
        	req.setAttribute("success","Booking Successfull!!!");
        	req.getRequestDispatcher("dashboard-employee.jsp?success=booked").forward(req, res);
  //        res.sendRedirect("dashboard-employee.jsp?success=booked");
        } else {
            List<String[]> alt = roomBookingService.suggestSlots(roomId, date);
            req.setAttribute("error", "Time slot unavailable. Try these alternatives:");
            req.setAttribute("alternatives", alt);
            req.getRequestDispatcher("book-room.jsp").forward(req, res);
        }
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doGet(req, res);
	}

}
