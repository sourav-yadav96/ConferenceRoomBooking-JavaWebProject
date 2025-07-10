package com.demosourav.DAO.IMP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demosourav.DAO.IConnectivity;
import com.demosourav.model.User;
import com.demosourav.util.DBConnection;

public class UserDatabaseConnectivity implements IConnectivity {

	@Override
	public User isValid(String username, String password) {
		
		 User user = null;
		try {
		    Connection con = DBConnection.getConnection();
		    String sql = "SELECT * FROM users WHERE username=? AND password=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
	             user = new User();
	             user.setId(rs.getInt("id"));
	             user.setUsername(rs.getString("username"));
	             user.setRole(rs.getString("role"));
	         }
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
}
}
