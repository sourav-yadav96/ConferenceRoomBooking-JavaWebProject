package com.demosourav.DAO;

import java.util.List;

import com.demosourav.model.Room;

public interface IRoomSearchRepository {
	
	public List<Room> searchAvailableRooms(String date, String time, int capacity, String[] equipment);

}
