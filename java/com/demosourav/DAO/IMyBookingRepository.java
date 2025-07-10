package com.demosourav.DAO;

import java.util.List;
import com.demosourav.model.Booking;

public interface IMyBookingRepository {
	
	public List<Booking> fetchBookingsByUser(int userId);

}
