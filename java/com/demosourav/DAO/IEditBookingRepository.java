package com.demosourav.DAO;

public interface IEditBookingRepository {
	
	public int updateBookingDetails(int bookingId, String bookingDate, String startTime, String endTime, String purpose);

}
