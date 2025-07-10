package com.demosourav.DAO.IMP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demosourav.DAO.IMyBookingRepository;
import com.demosourav.model.Booking;
import com.demosourav.util.DBConnection;

public class MyBookingRepositoryImpl implements IMyBookingRepository {

	@Override
	public List<Booking> fetchBookingsByUser(int userId) {
		
		List<Booking> list = new ArrayList<>();
		Connection con = DBConnection.getConnection();
		String sql = "SELECT b.*, r.id AS room_id FROM bookings b " +
                "JOIN rooms r ON b.room_id = r.id WHERE b.user_id = ? ORDER BY booking_date DESC";
		
		try {	
		PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, userId);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Booking b = new Booking();
            b.setId(rs.getInt("id"));
            b.setRoomId(rs.getInt("room_id"));
            b.setBooking_date(rs.getString("booking_date"));
            b.setStartTime(rs.getString("start_time"));
            b.setEndTime(rs.getString("end_time"));
            b.setStatus(rs.getString("status"));
            list.add(b);
        }
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return list;
	}
}
