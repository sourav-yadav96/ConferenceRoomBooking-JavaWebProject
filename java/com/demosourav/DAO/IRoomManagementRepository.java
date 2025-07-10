package com.demosourav.DAO;

import java.util.List;

import com.demosourav.model.Room;

public interface IRoomManagementRepository {
	
	public void insertRoom(Room room);
	public void updateRoom(Room room);
	public void deleteRoom(int id);
	public Room getRoomById(int id);
	public List<Room> getAllRooms();
	

}
