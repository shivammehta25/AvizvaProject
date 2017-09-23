package com.avizva.trainingProject.backend.service;

import javax.servlet.http.HttpServletRequest;

import com.avizva.trainingProject.backend.model.User;

public interface UserService {
	/**
	 * 
	 * @param user This object is passed as an argument in the method named registerUser.  
	 * @return Its return type is boolean.
	 */
	public boolean registerUser(User user);
	
	/**
	 * 
	 * @param username 
	 * @param password
	 * @param request
	 * 
	 * @return Its return type is boolean.
	 */
	public boolean authLogin(String username , String password , HttpServletRequest request);
	
	/**
	 * 
	 * @param email
	 * @return Its return type is boolean.
	 */
	public boolean forgotPass(String email);
	
	/**
	 * 
	 * @param email
	 * @param onetimepass
	 * @param password
	 * @return Its return type is boolean.
	 */
	public boolean resetPass(String email, String onetimepass, String password);
	
	/**
	 * 
	 * @param request
	 * @return Its return type is boolean.
	 */
	public boolean deactivate(HttpServletRequest request);
	
	/**
	 * 
	 * @param user
	 * @return Its return type is boolean.
	 */
	public boolean updateUser(User user);
	
	/**
	 * 
	 * @param username
	 * @return Its return type is boolean.
	 */
	public User getUserByUsername(String username);


}
