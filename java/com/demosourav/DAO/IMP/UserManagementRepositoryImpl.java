package com.demosourav.DAO.IMP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.demosourav.DAO.IUserManagementRepository;
import com.demosourav.model.User;
import com.demosourav.util.DBConnection;

public class UserManagementRepositoryImpl implements IUserManagementRepository{

	
	public void insertUser(User user) {
		Connection con = DBConnection.getConnection();
		String sql = "INSERT INTO users (username, email, password, role) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole());
            ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void updateUser(User user) {
		Connection con = DBConnection.getConnection();
		String sql = "UPDATE users SET username=?, email=?, password=?, role=? WHERE id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole());
            ps.setInt(5, user.getId());
            ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void deleteUser(int id) {
		Connection con = DBConnection.getConnection();
		String sql = "DELETE FROM users WHERE id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
            ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public User getUserById(int id) {
		Connection con = DBConnection.getConnection();
		String sql = "SELECT * FROM users WHERE id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("username"), rs.getString("email"),
                        rs.getString("password"), rs.getString("role"));
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		Connection con = DBConnection.getConnection();
		String sql = "SELECT * FROM users";
		 Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
	        while (rs.next()) {
	             users.add(new User(rs.getInt("id"), rs.getString("username"),
	                     rs.getString("email"), rs.getString("password"),
	                     rs.getString("role")));
		}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		return users;

}
}
