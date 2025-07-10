package com.demosourav.service;

import java.util.List;
import com.demosourav.DAO.IRoomBookingRepository;
import com.demosourav.DAO.IMP.RoomBookingRepositoryImpl;

public class RoomBookingService {
	
	public IRoomBookingRepository repo = new RoomBookingRepositoryImpl();
	
	public boolean bookRoomWithTime(int roomId, int userId, String date, String startTime, String endTime, String purpose, String requests) {
		
		if (repo.isRoomAvailable(roomId, date, startTime, endTime)) {
            return repo.insertBookingWithTime(roomId, userId, date, startTime, endTime, purpose, requests);
        }
        return false;
	}
	
	
	 public List<String[]> suggestSlots(int roomId, String date) {
	        return repo.getAvailableSlots(roomId, date);
	    }

}
