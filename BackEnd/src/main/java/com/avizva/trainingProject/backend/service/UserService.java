package com.avizva.trainingProject.backend.service;

import javax.servlet.http.HttpServletRequest;

import com.avizva.trainingProject.backend.model.User;

public interface UserService {
	public boolean registerUser(User user);
	public boolean authLogin(String username , String password , HttpServletRequest request);

}
