package com.demosourav.DAO.IMP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.demosourav.DAO.IRoomBookingRepository;
import com.demosourav.util.DBConnection;


public class RoomBookingRepositoryImpl implements IRoomBookingRepository {

	@Override
	public boolean insertBookingWithTime(int roomId, int userId, String date, String startTime, String endTime, String purpose,
			String requests) {
		
		Connection con = DBConnection.getConnection();
		String sql = "INSERT INTO bookings (room_id,user_id,booking_date,start_time,end_time,purpose,special_requests)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try {
		PreparedStatement ps =  con.prepareStatement(sql);
            ps.setInt(1, roomId);
            ps.setInt(2, userId);
            ps.setString(3, date);
            ps.setString(4, startTime);
            ps.setString(5, endTime);
            ps.setString(6, purpose);
            ps.setString(7, requests);
            
            return ps.executeUpdate() == 1;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean isRoomAvailable(int roomId, String date, String startTime, String endTime) {
		
		Connection con = DBConnection.getConnection();
		String sql = "SELECT 1 FROM bookings WHERE room_id = ? AND booking_date = ?"
                 + " AND ((start_time < ? AND end_time > ?) OR (start_time < ? AND end_time > ?))";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, roomId);
            ps.setString(2, date);
            ps.setString(3, endTime);
            ps.setString(4, startTime);
            ps.setString(5, startTime);
            ps.setString(6, endTime);
            
            ResultSet rs = ps.executeQuery(); 
            return !rs.next();
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public List<String[]> getAvailableSlots(int roomId, String date) {
		
		List<String[]> slots = new ArrayList<>();
		Connection con = DBConnection.getConnection();
		String sql = "SELECT start_time, end_time FROM bookings WHERE room_id = ? AND booking_date = ? ORDER BY start_time";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, roomId);
            ps.setString(2, date);
            ResultSet rs = ps.executeQuery();
            
            Time workStart = Time.valueOf("09:00:00");
            Time workEnd = Time.valueOf("18:00:00");
            List<Time[]> booked = new ArrayList<>();
            while (rs.next()) {
                booked.add(new Time[]{rs.getTime("start_time"), rs.getTime("end_time")});
            }

            Time current = workStart;
            for (Time[] b : booked) {
                if (current.before(b[0])) {
                    slots.add(new String[]{current.toString(), b[0].toString()});
                }
                if (b[1].after(current)) {
                    current = b[1];
                }
            }
            if (current.before(workEnd)) {
                slots.add(new String[]{current.toString(), workEnd.toString()});
            }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return slots;
	}

}
