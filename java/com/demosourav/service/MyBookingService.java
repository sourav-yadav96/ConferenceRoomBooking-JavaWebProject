package com.demosourav.service;

import java.util.List;

import com.demosourav.DAO.IMyBookingRepository;
import com.demosourav.DAO.IMP.MyBookingRepositoryImpl;
import com.demosourav.model.Booking;

public class MyBookingService {
	
	public List<Booking> getBookingsByUser(int userId) {
	    IMyBookingRepository repo = new MyBookingRepositoryImpl();
        return  repo.fetchBookingsByUser(userId);
	}

}
