package com.demosourav.service;

import com.demosourav.model.User;

import java.util.List;

import com.demosourav.DAO.IUserManagementRepository;
import com.demosourav.DAO.IMP.UserManagementRepositoryImpl;

public class UserManagementService {
	
	public IUserManagementRepository repo = new UserManagementRepositoryImpl();
	
	public void addUser(User user) {
        repo.insertUser(user);
    }

    public void updateUser(User user) {
        repo.updateUser(user);
    }

    public void deleteUser(int id) {
        repo.deleteUser(id);
    }

    public User getUserById(int id) {
        return repo.getUserById(id);
    }

    public List<User> getAllUsers() {
        return repo.getAllUsers();
    }

}
