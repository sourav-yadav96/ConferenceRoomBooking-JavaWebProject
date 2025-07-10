package com.demosourav.DAO.IMP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.demosourav.DAO.IUserRepository;
import com.demosourav.model.User;
import com.demosourav.util.DBConnection;

 public class UserRepositoryImpl implements IUserRepository {
	
	 public boolean insertUser(User user) {
		    
	        try (Connection con = DBConnection.getConnection();) {

	            String sql = "INSERT INTO users (username, email, password, role) VALUES (?, ?, ?, ?)";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setString(1, user.getUsername());
	            ps.setString(2, user.getEmail());
	            ps.setString(3, user.getPassword()); 
	            ps.setString(4, user.getRole());
	            int rows = ps.executeUpdate();
	            return rows > 0;
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	}

