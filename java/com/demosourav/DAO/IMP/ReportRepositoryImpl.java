package com.demosourav.DAO.IMP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demosourav.DAO.IReportRepository;
import com.demosourav.model.RoomUsageReport;
import com.demosourav.util.DBConnection;

public class ReportRepositoryImpl implements IReportRepository{

	public List<RoomUsageReport> getRoomUtilization() {
		
		List<RoomUsageReport> reports = new ArrayList<>();
		
		Connection con = DBConnection.getConnection();
		String sql = "SELECT r.name, COUNT(b.id) AS totalBookings, " +
                "SUM(TIMESTAMPDIFF(HOUR, b.start_time, b.end_time)) AS totalHours " +
                "FROM rooms r " +
                "LEFT JOIN bookings b ON r.id = b.room_id AND b.status = 'Approved' " +
                "GROUP BY r.name";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			 while (rs.next()) {
	                String name = rs.getString("name");
	                int bookings = rs.getInt("totalBookings");
	                int hours = rs.getInt("totalHours");
	                double utilization = (hours / 40.0) * 100;
	                reports.add(new RoomUsageReport(name, bookings, hours, utilization));
	            }
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reports;
	}

}
