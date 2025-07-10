package com.demosourav.servlet;

import java.io.IOException;
import java.util.List;

import com.demosourav.model.Room;
import com.demosourav.service.RoomSearchService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/rooms")
public class RoomSearchServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		String date = req.getParameter("date");
        String time = req.getParameter("time");
        String capacityStr = req.getParameter("capacity");
        String[] equipment = req.getParameterValues("equipment");
        
        int capacity = capacityStr != null && !capacityStr.isEmpty() ? Integer.parseInt(capacityStr) : 0;
        
        RoomSearchService roomSearchService = new RoomSearchService();
        
        List<Room> roomList = roomSearchService.findAvailableRooms(date, time, capacity, equipment);
       
        req.setAttribute("roomList", roomList);
        req.getRequestDispatcher("rooms.jsp").forward(req, res);
        
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		doGet(req, res);
	}

}
