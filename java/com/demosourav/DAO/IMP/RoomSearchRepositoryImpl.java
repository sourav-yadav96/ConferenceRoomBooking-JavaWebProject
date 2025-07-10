package com.demosourav.DAO.IMP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demosourav.DAO.IRoomSearchRepository;
import com.demosourav.model.Room;
import com.demosourav.util.DBConnection;

public class RoomSearchRepositoryImpl implements IRoomSearchRepository {

	@Override
	public List<Room> searchAvailableRooms(String date, String time, int capacity, String[] equipment) {
		List<Room> rooms = new ArrayList<>();
		String equipmentFilter = (equipment != null) ? String.join(",", equipment) : "";
		
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM rooms WHERE capacity >= ? AND features LIKE ?");
			ps.setInt(1, capacity);
            ps.setString(2, "%" + equipmentFilter + "%");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Room room = new Room(rs.getInt("id"),rs.getString("name"),rs.getInt("capacity"),rs.getString("features"));
                rooms.add(room);
            }
            con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rooms;
	}

}
