package com.demosourav.DAO.IMP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.demosourav.DAO.IRoomManagementRepository;
import com.demosourav.model.Room;
import com.demosourav.util.DBConnection;


public class RoomManagementRepositoryImpl implements IRoomManagementRepository {

	public void insertRoom(Room room) {
		Connection con = DBConnection.getConnection();
		String sql = "INSERT INTO rooms (name, capacity, projector, whiteboard) VALUES (?, ?, ?, ?)";
        try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, room.getName());
	        ps.setInt(2, room.getCapacity());
	        ps.setBoolean(3, room.isProjector());
	        ps.setBoolean(4, room.isWhiteboard());
	        ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

	
	public void updateRoom(Room room) {
		Connection con = DBConnection.getConnection();
		String sql = "UPDATE rooms SET name=?, capacity=?, projector=?, whiteboard=? WHERE id=?";
        try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, room.getName());
	        ps.setInt(2, room.getCapacity());
	        ps.setBoolean(3, room.isProjector());
	        ps.setBoolean(4, room.isWhiteboard());
	        ps.setInt(5, room.getId());
	        ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

	
	public void deleteRoom(int id) {
		Connection con = DBConnection.getConnection();
		String sql = "DELETE FROM rooms WHERE id=?";
        try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
            ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}

    
	public Room getRoomById(int id) {
		Room room = null;
		Connection con = DBConnection.getConnection();
		String sql = "SELECT * FROM rooms WHERE id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                room = new Room(rs.getInt("id"), rs.getString("name"),
                                rs.getInt("capacity"), rs.getBoolean("projector"),
                                rs.getBoolean("whiteboard"));
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return room;
	}

	
	
	public List<Room> getAllRooms() {
		 List<Room> list = new ArrayList<>();
		 Connection con = DBConnection.getConnection();
		 String sql = "SELECT * FROM rooms";
		 try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                list.add(new Room(rs.getInt("id"), rs.getString("name"),
                        rs.getInt("capacity"),rs.getBoolean("projector"),
                        rs.getBoolean("whiteboard")));
                    }
              } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		      }
		 
		return list;
	}

	

}
