package com.avizva.trainingProject.backend.dao;

import com.avizva.trainingProject.backend.model.ForgotPass;
import com.avizva.trainingProject.backend.model.User;

/**
 * 
 * @author Akshay Chourasia
 * This is an DAO interface in which
 * we have defined the methods....
 *
 */
public interface ForgotPassDAO {
	/**
	 * 
	 * @param email
	 * @return
	 */
	public User findEmail(String email);
	
	/**
	 * 
	 * @param forgotPass
	 * @return
	 */
	public boolean saveOtp(ForgotPass forgotPass);
	
	/**
	 * 
	 * @param forgotPass
	 * @return
	 */
	public String getOtp(ForgotPass forgotPass);
	
	/**
	 * 
	 * @param user
	 */
	public void changePassword(User user);
}
