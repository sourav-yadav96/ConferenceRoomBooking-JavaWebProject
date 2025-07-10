package com.demosourav.DAO.IMP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.demosourav.DAO.IManageBookingRepository;
import com.demosourav.model.Booking;
import com.demosourav.util.DBConnection;

public class ManageBookingRepositoryImpl implements IManageBookingRepository {
	
	public List<Booking> findAllPendingBookings(){
		List<Booking> conflicts = new ArrayList<>();
		
		Connection con = DBConnection.getConnection();
		String sql = "SELECT * FROM bookings WHERE status = 'Pending'";
	    try {
			Statement st =  con.createStatement();
			 ResultSet rs = st.executeQuery(sql);
			 while (rs.next()) {
	                conflicts.add(new Booking(rs.getInt("id"), rs.getInt("room_id"), rs.getString("booking_date"), rs.getString("start_time"), rs.getString("end_time"), rs.getString("status")));
	            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    return conflicts;
	}
	
	
	 public void updateStatus(int bookingId, String status) {
		 Connection con = DBConnection.getConnection();
		 String sql = "UPDATE bookings SET status=? WHERE id=?";
		 try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, status);
            ps.setInt(2, bookingId);
            ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 }
	 
	 
	 public void updateTime(int bookingId, String newTime) {
		 Connection con = DBConnection.getConnection();
		 String sql = "UPDATE bookings SET start_time=? WHERE id=?";
		 try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newTime);
            ps.setInt(2, bookingId);
            ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	 }

}
