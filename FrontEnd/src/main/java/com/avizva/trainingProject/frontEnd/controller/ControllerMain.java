package com.avizva.trainingProject.frontEnd.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.trainingProject.backend.model.ContactUs;
import com.avizva.trainingProject.backend.model.User;
import com.avizva.trainingProject.backend.service.ContactUsService;
import com.avizva.trainingProject.backend.service.UserService;

@Controller
public class ControllerMain {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ContactUsService contactUsService;
	
	private static final Logger LOGGER = Logger.getLogger(ExceptionController.class);

	
	
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, "dob", new CustomDateEditor(format, false));

	}
	

	@RequestMapping("/")
	public ModelAndView viewIndex(){
		LOGGER.info("<--- Reached Index Page --->");
		return new ModelAndView("index").addObject("homeactive" , "active");
	}
	@RequestMapping("/registeration")
	public ModelAndView registerit(){
		LOGGER.info("<--- Reached Registration Page --->");
		return new ModelAndView("registeration").addObject("myaccountactive" , "active");
	}
	@RequestMapping("/contact")
	public ModelAndView contactcall(){
		LOGGER.info("<--- Reached Contact Page --->");
		return new ModelAndView("contactus");
	}
	@RequestMapping("/aboutus")
	public ModelAndView aboutuscall(){
		LOGGER.info("<--- Reached About Us Page --->");
		return new ModelAndView("aboutus").addObject("aboutusactive" , "active");
	}
	
	
	@RequestMapping("/forgotpass")
	public ModelAndView forgotpasscall(){
		LOGGER.info("<--- Reached ForgotPass Page --->");
		return new ModelAndView("forgotpass");
	}
	@RequestMapping("/resetpass")
	public ModelAndView resetPassCall(){
		LOGGER.info("<--- Reached Resetpass Page --->");
		return new ModelAndView("resetpass");
	}
	@RequestMapping("/profile")
	public ModelAndView profileCall(HttpServletRequest request){
		HttpSession session=request.getSession(false);
		String username=(String)session.getAttribute("username");
		User user=userService.getUserByUsername(username);
		LOGGER.info("<--- Reached Profile Page of " + user.getEmail() + " --->");
		return new ModelAndView("profile","command", user).addObject("disabled" , "yes");
	}
	
	@RequestMapping("/registerationform")
	public ModelAndView registrationForm(@Valid @ModelAttribute User user  , BindingResult result){
		if(  userService.registerUser(user)  && (!(result.hasErrors()))){
			
			LOGGER.warn("<--- User " + user.getEmail() +  " Registering  --->");
			return new ModelAndView("login").addObject("msg", "User Registered Successfully" );
		}else {
			return new ModelAndView("registeration").addObject("msg" , "Error While Registering Please Fix error and Continue");
		}
		
		
	}
	
	
	@RequestMapping("/contactusmail")
	public ModelAndView contactUsForm(@Valid @ModelAttribute ContactUs contactUs){
		if(contactUsService.contactUs(contactUs)){
			
			return new ModelAndView("contactus" , "msg" , "Thank You for Contacting Us We will get back to you shortly.");
		}
		else{
			return new ModelAndView("contactus" , "msg" , "Sorry , There was some technical error , Try Again Later ");
		}
	}

	@RequestMapping("/forgotpassform")
	public ModelAndView forgotPassForm(@RequestParam("email") String email){
		if(userService.forgotPass(email)){
			return new ModelAndView("resetpass").addObject("msg", "Enter the OTP sent on your mail" );
		}
		else{
			return new ModelAndView("forgotpass").addObject("msg", "Error Occured. Email not found" );
		}
		
	}
	

	@RequestMapping("/resetpassform")
	public ModelAndView resetPassForm(@RequestParam("email") String email,@RequestParam("otp") String otp, @RequestParam("password") String password){
		if(userService.resetPass(email, otp, password)){
			return new ModelAndView("login").addObject("msg", "Your password has been successfully reset" );
		}
		else{
			return new ModelAndView("resetpass").addObject("msg", "Error Occured. Please enter correct OTP" );
		}
	}


	@RequestMapping("/logout")
	public ModelAndView logoutUser(HttpServletRequest request){
	 HttpSession session=request.getSession(false);
	 session.invalidate();
	 return new ModelAndView("index" , "msg" , "Logged out Successfully");	
	}
	
	
	@RequestMapping("/profileupdateform")
	public ModelAndView profileUpdateForm(@Valid @ModelAttribute User user  , BindingResult result){
		if(userService.updateUser(user)  && (!(result.hasErrors()))){
			return new ModelAndView("profile" , "command" , user).addObject("msg", "Your details were successfully updated" );
		}
		else{
			return new ModelAndView("profile" , "command" , user).addObject("msg", "Error Occured. Could not update details." );
		}
	}
}

