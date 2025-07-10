package com.demosourav.DAO;

import java.util.List;

import com.demosourav.model.User;

public interface IUserManagementRepository {
	
	 public void insertUser(User user);
	 public void updateUser(User user);
	 public void deleteUser(int id);
	 public User getUserById(int id);
	 public List<User> getAllUsers();

}
