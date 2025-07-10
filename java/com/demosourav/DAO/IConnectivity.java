package com.demosourav.DAO;

import com.demosourav.model.User;

public interface IConnectivity {
	
	public User isValid(String username, String password);

}
