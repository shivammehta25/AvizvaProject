package com.avizva.trainingProject.backend.dao;

import com.avizva.trainingProject.backend.model.User;



/**
 * 
 * @author Akshay,Shivam,Saurabh
 * This is the DAO interface in which multiple
 * methods is been defined to perform different operation
 * such as registration, user authentication,deactivate Account
 * and update user.
 * 
 */
public interface UserDAO {
	/**
	 * 
	 * @param user
	 * @return true or false.
	 * argument as user object
	 */
	public boolean registerUser(User user);
	
	
	/**
	 * 
	 * @param username,password.
	 * @return true or false.
	 * argument as user object
	 */
	public boolean authLogin(String username , String password);
	
	/**
	 * 
	 * @param username
	 * @return true or false.
	 * argument as user object
	 */
	public User getUserByUsername(String username);
	
	/**
	 * 
	 * @param user
	 * @return true or false.
	 * argument as user object
	 */
	public boolean deactivate(User user);
	
	/**
	 * 
	 * @param user
	 * @return true or false.
	 * argument as user object
	 */
	public boolean updateUser(User user);
	
	
}
