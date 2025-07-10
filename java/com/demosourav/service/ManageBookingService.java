package com.demosourav.service;

import java.util.List;

import com.demosourav.model.Booking;
import com.demosourav.DAO.IManageBookingRepository;
import com.demosourav.DAO.IMP.*;

public class ManageBookingService {
	
	public IManageBookingRepository repo = new  ManageBookingRepositoryImpl();
	
	  public List<Booking> getAllPendingBookings() {
	        return repo.findAllPendingBookings();
	    }
	  
	  
	  public void approveBooking(int bookingId) {
	        repo.updateStatus(bookingId, "Approved");
	    }
	  
	  public void rescheduleBooking(int bookingId, String newTime) {
	        repo.updateTime(bookingId, newTime);
	        repo.updateStatus(bookingId, "Rescheduled");
	    }
	  
	  public void cancelBooking(int bookingId) {
		  repo.updateStatus(bookingId, "Cancelled");
	  }

}
