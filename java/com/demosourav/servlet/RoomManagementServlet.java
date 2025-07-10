package com.demosourav.servlet;

import java.io.IOException;
import java.util.List;

import com.demosourav.model.Room;
import com.demosourav.service.RoomManagementService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/room")
public class RoomManagementServlet extends HttpServlet {
	
	 public RoomManagementService roomManagementservice = new RoomManagementService();
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String action = req.getParameter("action");
        if ("delete".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            roomManagementservice.deleteRoom(id);
            res.sendRedirect("room");
        } 
        else if (req.getParameter("id") != null) {
            int id = Integer.parseInt(req.getParameter("id"));
            Room room = roomManagementservice.getRoomById(id);
            req.setAttribute("room", room);
            req.getRequestDispatcher("room-form.jsp").forward(req, res);
        } 
       else {
            List<Room> rooms = roomManagementservice.getAllRooms();
            req.setAttribute("rooms", rooms);
            req.getRequestDispatcher("room-management.jsp").forward(req, res);
        }
   }
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        int capacity = Integer.parseInt(req.getParameter("capacity"));
        boolean projector = req.getParameter("projector") != null;
        boolean whiteboard = req.getParameter("whiteboard") != null;

        Room room = new Room();
        room.setName(name);
        room.setCapacity(capacity);
        room.setProjector(projector);
        room.setWhiteboard(whiteboard);

        String idStr = req.getParameter("id");
        if (idStr != null) {
            room.setId(Integer.parseInt(idStr));
            roomManagementservice.updateRoom(room);
        } else {
            roomManagementservice.addRoom(room);
        }
        
//        req.setAttribute("room", room);
//        req.getRequestDispatcher("room-form.jsp").forward(req, res);
      res.sendRedirect("room");
    }

}

