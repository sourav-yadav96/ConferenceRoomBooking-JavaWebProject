package com.demosourav.DAO.IMP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.demosourav.DAO.ICancelBookingRepository;
import com.demosourav.util.DBConnection;

public class CancelBookingRepositoryImpl implements ICancelBookingRepository {

	@Override
	public void updateStatus(int bookingId, String status) {
		
		Connection con = DBConnection.getConnection();	
		String sql = "UPDATE bookings SET status = ? WHERE id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			 ps.setString(1, status);
		     ps.setInt(2, bookingId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
