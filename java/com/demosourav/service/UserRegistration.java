package com.demosourav.service;

import com.demosourav.DAO.IUserRepository;
import com.demosourav.DAO.IMP.UserRepositoryImpl;
import com.demosourav.model.User;

public class UserRegistration {
	
	public boolean registerUser(User user) {
        IUserRepository userRepo = new UserRepositoryImpl();
        return userRepo.insertUser(user);
    }

}
