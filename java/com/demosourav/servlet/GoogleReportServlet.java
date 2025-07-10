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

@WebServlet("/googlereports")
public class GoogleReportServlet extends HttpServlet{
	
	 public ReportService reportService = new ReportService();
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        List<RoomUsageReport> reports = reportService.getRoomUtilization();

        // Convert to simple JavaScript array format
        StringBuilder chartData = new StringBuilder();
        chartData.append("['Room', 'Utilization %'],");

        for (RoomUsageReport report : reports) {
            chartData.append("['").append(report.getRoomName()).append("', ")
                     .append(report.getUtilizationPercentage()).append("],");
        }

        // Remove last comma
        if (chartData.length() > 0) {
            chartData.setLength(chartData.length() - 1);
        }

        req.setAttribute("chartData", chartData.toString());
        req.getRequestDispatcher("google-reports.jsp").forward(req, res);
    }
}
