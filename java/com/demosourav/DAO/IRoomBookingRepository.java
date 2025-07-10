package com.demosourav.DAO;

import java.util.List;

public interface IRoomBookingRepository {
	
	public boolean insertBookingWithTime(int roomId, int userId, String date, String startTime, String endTime, String purpose, String requests);
	
	public boolean isRoomAvailable(int roomId, String date, String startTime, String endTime);

    public List<String[]> getAvailableSlots(int roomId, String date);

}
