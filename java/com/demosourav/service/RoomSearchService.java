package com.demosourav.service;


import java.util.List;
import com.demosourav.model.Room;
import com.demosourav.DAO.IMP.RoomSearchRepositoryImpl;
import com.demosourav.DAO.IRoomSearchRepository;

public class RoomSearchService {
	
	public List<Room> findAvailableRooms(String date, String time, int capacity, String[] equipment) {
		IRoomSearchRepository repo = new RoomSearchRepositoryImpl();
		return repo.searchAvailableRooms(date, time, capacity, equipment);
	}

}
