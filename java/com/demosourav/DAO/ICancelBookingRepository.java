package com.demosourav.DAO;

public interface ICancelBookingRepository {
	
	public void updateStatus(int bookingId, String status);

}
