package com.demosourav.servlet;

import java.io.IOException;
import java.util.List;

import com.demosourav.model.RoomUsageReport;
import com.demosourav.service.ReportService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/reports")
public class ReportServlet extends HttpServlet{
	
	 public ReportService reportService = new ReportService();
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
		
		List<RoomUsageReport> reports = reportService.getRoomUtilization();
        req.setAttribute("reports", reports);
        req.getRequestDispatcher("reports.jsp").forward(req, res);
    }
		
	}

