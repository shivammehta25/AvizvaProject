package com.avizva.trainingProject.backend.service;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.avizva.trainingProject.backend.dao.ForgotPassDAO;
import com.avizva.trainingProject.backend.dao.UserDAO;
import com.avizva.trainingProject.backend.model.ForgotPass;
import com.avizva.trainingProject.backend.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	@Autowired
	ForgotPassDAO forgotPassDAO;
	@Autowired
	private MailSender mailSender;

	@Autowired
	private ForgotPass forgotPass;
	
	

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

	public boolean authLogin(String username, String password, HttpServletRequest request) {
		boolean flag = false;

		HttpSession session = request.getSession();
		if (userDAO.authLogin(username, password)) {
			session.setAttribute("username", username);
			session.setAttribute("user", userDAO.getUserByUsername(username));
			flag = true;
		}
		return flag;
	}

	public boolean forgotPass(String email) {
		boolean flag = false;
		User user = forgotPassDAO.findEmail(email);
		if(user == null){
			return flag;
		}
		else
		 {
			Random random = new Random();

			StringBuilder builder = new StringBuilder();
			for (int count = 0; count <= 4; count++) {
				builder.append(random.nextInt(10));
			}

			
			forgotPass.setEmail(user.getEmail());
			forgotPass.setOtp(builder.toString());
			
			if (forgotPassDAO.saveOtp(forgotPass)) {
				SimpleMailMessage message = new SimpleMailMessage();
				message.setFrom("Admin@GAMAZON");
				message.setTo(user.getEmail());
				message.setSubject("OTP for Password Reset");
				message.setText("Dear " + user.getName() + ", Your OTP is " + forgotPass.getOtp());
				mailSender.send(message);
				// Set flag
				flag = true;
			}
		}

		return flag;

	}

	public boolean resetPass(String email, String otp, String password) {
		boolean flag = false;
		// Call dao.findEmail
		User user = forgotPassDAO.findEmail(email);
		System.out.println("Reset pass me user ka object" + user.getEmail());
		// Call dao.getOtp
		forgotPass.setEmail(user.getEmail());
		String dbOtp = forgotPassDAO.getOtp(forgotPass);
		// Check otp's
		if (dbOtp.equalsIgnoreCase(otp)) {
			// Call dao.changePassword
			user.setPassword(password);
			forgotPassDAO.changePassword(user);
			flag = true;
		}
		return flag;
	}
	
	public boolean deactivate(HttpServletRequest request)
	{	
		boolean flag=false;
		User user = null;
		HttpSession session=request.getSession();
		user=(User)session.getAttribute("user");
		if(user == null){
			return flag;
		}
		
		userDAO.deactivate(user);
		flag=true;
		return flag;
		
	}

}
