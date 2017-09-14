package com.avizva.trainingProject.frontEnd.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.trainingProject.backend.service.UserService;

@Controller
public class SessionController {
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/login")
	public ModelAndView loginView(){
		return new ModelAndView("login");
	}
	
	
	
	@RequestMapping("/loginform")
	public ModelAndView loginAction(@RequestParam("username") String username , @RequestParam("password") String password , HttpServletRequest request){
		
		if(userService.authLogin(username , password , request )){
			return new ModelAndView("index").addObject("msg" , "Logged In Successfully");
			
		}
			
		return new ModelAndView("login").addObject("msg" , "Invalid Username and Password");
		
	}
	@RequestMapping("/deactivate")
	public ModelAndView deactivateUser(HttpServletRequest request){
	 HttpSession session=request.getSession(false);
	 if(userService.deactivate(request)){
	 session.invalidate();
	 return new ModelAndView("index" , "msg" , "Deactivated Successfully");
	 }
	 else {
		 return new ModelAndView("index" , "msg" ,"User Already Deactivated");
	 }
	}
}
