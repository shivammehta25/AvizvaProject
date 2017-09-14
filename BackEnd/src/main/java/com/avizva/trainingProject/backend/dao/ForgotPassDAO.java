package com.avizva.trainingProject.backend.dao;

import com.avizva.trainingProject.backend.model.ForgotPass;
import com.avizva.trainingProject.backend.model.User;

/**
 * 
 * @author Akshay Chourasia
 * This is an DAO interface in which
 * we have defined the methods.
 *
 */
public interface ForgotPassDAO {
	public User findEmail(String email);
	public boolean saveOtp(ForgotPass forgotPass);
	public String getOtp(ForgotPass forgotPass);
	public void changePassword(User user);
}
