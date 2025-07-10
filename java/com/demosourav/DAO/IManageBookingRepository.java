package com.demosourav.DAO;

import java.util.List;

import com.demosourav.model.Booking;

public interface IManageBookingRepository {
	
	public List<Booking> findAllPendingBookings();
	public void updateStatus(int bookingId, String status);
	public void updateTime(int bookingId, String newTime);

}
