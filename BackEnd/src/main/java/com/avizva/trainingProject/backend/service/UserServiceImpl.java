package com.avizva.trainingProject.backend.service;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.avizva.trainingProject.backend.dao.ForgotPassDAO;
import com.avizva.trainingProject.backend.dao.UserDAO;
import com.avizva.trainingProject.backend.model.ForgotPass;
import com.avizva.trainingProject.backend.model.User;

/**
 * 
 * @author Akshay.Chourasia
 * @service It makes an automatic bean userServiceImpl acts similar to the repository annotation but is used for service layer  
 */

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
	

	
	/**
	 * @param user
	 * <p>
	 * In the below method we have created the 
	 * object of SimpleMailMessage class.
	 * The user is getting registration conformation by email
	 * We are fetching the email address using getmethod
	 * from user object.
	 * 
	 *  @return Its return type is boolean.
	 */

	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

	public boolean registerUser(User user) {
		LOGGER.info("<-- UserService.registerUser Called--->");
		boolean flag = false;
		if (userDAO.registerUser(user)) {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("Admin@GAMAZON");
			message.setTo(user.getEmail());
			message.setSubject("Congratulations on Success");
			message.setText("Congratulations " + user.getName() + " on Your Successful Registration. ");
			mailSender.send(message);
			LOGGER.info("<-- Mail Sent and User " + user.getName()+ " Registered --->");
			flag = true;
			
		}
		else{
			LOGGER.error("<-- Registration Failed -->");
		}

		return flag;
	}
	
	/**
	 * @param username
	 * @param password
	 * @param request
	 * <p>
	 * The userDAO object is used to
	 * get the username. The operation of authentication
	 * of user is applied by calling the method named authLogin
	 * using userDAO.
	 */
	public boolean authLogin(String username, String password, HttpServletRequest request) {
		LOGGER.info("<-- UserService.authLogin Called--->");
		boolean flag = false;
		HttpSession session = request.getSession();
		if (userDAO.authLogin(username, password)) {
			session.setAttribute("username", username);
			session.setAttribute("user", userDAO.getUserByUsername(username));
			LOGGER.info("<--- User "+ username +" Authenticated --->");

			flag = true;
		}
		else{
			LOGGER.error("<-- User Not Authenticated -->");
		}
		return flag;
	}
	
	/**
	 * @param email
	 * <p>
	 * In this method we are applying the logic of 
	 * forgot password we get the email 
	 * of user by calling the method findMail
	 * in forgotPassDAO stored in user object
	 * after that we have created a 10 digit random number
	 * as an OTP and sends it to the email address written in the 
	 * textfield.
	 * 
	 * @return Its return type is boolean.
	 */
	public boolean forgotPass(String email) {
		LOGGER.info("<-- UserService.forgotPass Called--->");
		boolean flag = false;
		User user = forgotPassDAO.findEmail(email);
		if(user == null){
			LOGGER.error("Cannot Find Mailling Id for forgot pass " + email);
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
				LOGGER.info("<-- Mailed The OTP to " + user.getEmail() + "-->");
				flag = true;
			}
			else{
				LOGGER.error("Mail Cannot be Sent to " + user.getEmail()+ "-->");
			}
		}

		return flag;

	}
	
	/**
	 * @param email
	 * @param otp
	 * @param password
	 * 
	 * <p>
	 * The resetPass field checks weather the user has entered the correct OTP or not is yea it will change its password
	 */
	public boolean resetPass(String email, String otp, String password) {
		LOGGER.info("<-- UserService.resetPass Called--->");		
		boolean flag = false;
		User user = forgotPassDAO.findEmail(email);
		forgotPass.setEmail(user.getEmail());
		String dbOtp = forgotPassDAO.getOtp(forgotPass);
		if (dbOtp.equalsIgnoreCase(otp)) {
			user.setPassword(password);
			forgotPassDAO.changePassword(user);
			LOGGER.info("<-- Password Changed for "+ user.getEmail() +" --> ");

			flag = true;
		}
		else {
			LOGGER.error("<-- Password Cannot be Changed for " + user.getEmail() + " -->");
		}
		return flag;
	}
	/**
	 * @param request
	 * 
	 * <p> 
	 * Takes HttpServlet Request and get its session, deactivates the enable field of User model
	 */
	public boolean deactivate(HttpServletRequest request)
	{	
		
		boolean flag=false;
		User user = null;
		HttpSession session=request.getSession();
		user=(User)session.getAttribute("user");
		if(user == null){
			LOGGER.error("<-- Cannot Fetch User from Database for Deactivation -->");
			return flag;
		}
		if(userDAO.deactivate(user)){
			LOGGER.info("<-- User "  + user.getEmail()+ " Deactivated -->");
			flag = true;
		}else{
			LOGGER.error("<-- User " + user.getEmail() + " Couldnt Not be Deactivated -->");
			
		}
		
		
		return flag;
		
	}

	/**
	 * @param user
	 * <p>
	 * Updates the user by calling its DAO
	 * if the update is successfull it returns true
	 * else it returns false
	 * 
	 * @return Its return type is boolean.
	 */
	public boolean updateUser(User user) {
		LOGGER.info("<-- UserService.updateUser Called--->");
		boolean flag = false;
		if (userDAO.updateUser(user)) {
			LOGGER.info("<-- User " + user.getEmail() + " Updated -->");

			flag = true;
		}else {
			LOGGER.error("<-- Error Updating User " + user.getEmail()+" -->");
		}
		return flag;
	}
	/**
	 * @param username
	 * <p>
	 * It is used to return the User object by its username
	 */
	public User getUserByUsername(String username){
		LOGGER.info("<-- UserService.getUserByUsername Called -->");
		User user=userDAO.getUserByUsername(username);
		LOGGER.info("<-- Got User from the Database from Username -->" + user.getUsername());
		return user;
	}

}
