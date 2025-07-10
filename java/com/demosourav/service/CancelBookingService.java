package com.demosourav.service;

import com.demosourav.DAO.*;
import com.demosourav.DAO.IMP.*;

public class CancelBookingService {
	
	public void cancelBooking(int bookingId) {
		ICancelBookingRepository repo = new CancelBookingRepositoryImpl();
	    repo.updateStatus(bookingId, "Cancelled");
	}

}
