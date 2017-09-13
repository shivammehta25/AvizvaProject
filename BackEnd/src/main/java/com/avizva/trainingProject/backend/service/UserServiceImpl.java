package com.avizva.trainingProject.backend.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.avizva.trainingProject.backend.dao.UserDAO;
import com.avizva.trainingProject.backend.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	@Autowired
	private MailSender mailSender;

	public boolean registerUser(User user) {
		boolean flag = false;
		if (userDAO.registerUser(user)) {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("Admin@GAMAZON");
			message.setTo(user.getEmail());
			message.setSubject("Congratulations on Success");
			message.setText("Congratulations " + user.getName() + " on Your Successful Registration. ");
			mailSender.send(message);
			flag = true;
		}

		return flag;
	}

	public boolean authLogin(String username, String password , HttpServletRequest request) {
		System.out.println("Inside Auth Login");
		boolean flag = false;
		
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		if(userDAO.authLogin(username, password)){
			flag= true;
		}
		return flag;
	}

}
