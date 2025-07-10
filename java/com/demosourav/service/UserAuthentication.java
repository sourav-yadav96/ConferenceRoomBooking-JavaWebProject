package com.demosourav.service;

import com.demosourav.DAO.IConnectivity;
import com.demosourav.DAO.IMP.UserDatabaseConnectivity;
import com.demosourav.model.User;

public class UserAuthentication {
	
public User checkUser(String username, String password) {
		
		IConnectivity ref = new UserDatabaseConnectivity();
		return ref.isValid(username, password);
		
	}

}
