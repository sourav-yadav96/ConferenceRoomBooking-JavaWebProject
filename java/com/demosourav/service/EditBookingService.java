package com.demosourav.service;
import com.demosourav.DAO.*;
import com.demosourav.DAO.IMP.*;

public class EditBookingService {
	
	public int updateBooking(int bookingId, String bookingDate, String startTime, String endTime, String purpose) {
		
		IEditBookingRepository repo = new EditBookingRepositoryImpl();
	    return repo.updateBookingDetails(bookingId, bookingDate, startTime, endTime, purpose);

}
}
