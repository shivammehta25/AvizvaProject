package com.avizva.trainingProject.backend.dao;

import com.avizva.trainingProject.backend.model.User;

public interface UserDAO {
	public boolean registerUser(User user);
	public boolean authLogin(String username , String password);
	public User getUserByUsername(String username);
	public boolean deactivate(User user);
	public boolean updateUser(User user);
	
	
}
