package com.demosourav.service;

import com.demosourav.model.Room;

import java.util.List;

import com.demosourav.DAO.*;
import com.demosourav.DAO.IMP.*;

public class RoomManagementService {
	
	public IRoomManagementRepository repo = new RoomManagementRepositoryImpl();
	
	public void addRoom(Room room) {
        repo.insertRoom(room);
    }

    public void updateRoom(Room room) {
        repo.updateRoom(room);
    }

    public void deleteRoom(int id) {
        repo.deleteRoom(id);
    }

    public Room getRoomById(int id) {
        return repo.getRoomById(id);
    }

    public List<Room> getAllRooms() {
        return repo.getAllRooms();
    }

}
