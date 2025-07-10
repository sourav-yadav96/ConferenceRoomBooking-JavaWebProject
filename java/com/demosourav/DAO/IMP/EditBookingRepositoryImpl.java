package com.demosourav.DAO.IMP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.demosourav.DAO.IEditBookingRepository;
import com.demosourav.util.DBConnection;

public class EditBookingRepositoryImpl implements IEditBookingRepository {

	@Override
	public int updateBookingDetails(int bookingId, String bookingDate, String startTime, String endTime, String purpose) {
		Connection con = DBConnection.getConnection();
		String sql = "UPDATE bookings SET booking_date=?, start_time=?, end_time=?, purpose=? WHERE id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bookingDate);
	        ps.setString(2, startTime);
	        ps.setString(3, endTime);
	        ps.setString(4, purpose);
	        ps.setInt(5, bookingId);
	        int count = ps.executeUpdate();
	        return count;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
		
		
	}

}
