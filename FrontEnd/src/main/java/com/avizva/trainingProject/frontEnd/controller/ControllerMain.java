package com.avizva.trainingProject.frontEnd.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.trainingProject.backend.dao.ContactUsDAO;
import com.avizva.trainingProject.backend.dao.UserDAO;
import com.avizva.trainingProject.backend.model.ContactUs;
import com.avizva.trainingProject.backend.model.User;

@Controller
public class ControllerMain {
	
	@Autowired
	UserDAO userDAO;
	@Autowired
	private MailSender mailSender;

	@Autowired
	private ContactUsDAO contactUsDAO;
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, "dob", new CustomDateEditor(format, false));

	}
	

	@RequestMapping("/")
	public ModelAndView viewIndex(){
		return new ModelAndView("index").addObject("homeactive" , "active");
	}
	@RequestMapping("registeration")
	public ModelAndView registerit(){
		return new ModelAndView("registeration");
	}
	@RequestMapping("contact")
	public ModelAndView contactcall(){
		return new ModelAndView("contactus");
	}
	@RequestMapping("aboutus")
	public ModelAndView aboutuscall(){
		return new ModelAndView("aboutus").addObject("aboutusactive" , "active");
	}
	
	@RequestMapping("/registerationform")
	public ModelAndView registrationForm(@Valid @ModelAttribute User user  , BindingResult result){
		if(userDAO.registerUser(user) && (!(result.hasErrors()))){
			
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("Admin@GAMAZON");
			message.setTo(user.getEmail());
			message.setSubject("Congratulations on Success");
			message.setText("Congratulations " + user.getName() + " on Your Successful Registration. ");
			mailSender.send(message);
			return new ModelAndView("registeration").addObject("msg", "User Registered Successfully" );
		}else {
			return new ModelAndView("registeration").addObject("msg" , "Error While Registering Please Fix error and Continue");
		}
		
		
	}
	
	
	@RequestMapping("/contactusmail")
	public ModelAndView contactUsForm(@Valid @ModelAttribute ContactUs contactUs){
		if(contactUsDAO.contactus(contactUs)){
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("Admin@GAMAZON");
			message.setTo(contactUs.getEmail());
			message.setSubject("Thank You for Contacting Us");
			message.setText("Hii " + contactUs.getName() + " thank you for your time we will get back to you as soon as possible. ");
			mailSender.send(message);
			return new ModelAndView("contactus" , "msg" , "Thank You for Contacting Us We will get back to you shortly.");
		}
		else{
			return new ModelAndView("contactus" , "msg" , "Sorry , There was some technical error , Try Again Later ");
		}
	}
	
}
