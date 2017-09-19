package com.avizva.trainingProject.frontEnd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
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

	private static final Logger LOGGER = Logger.getLogger(ExceptionController.class);

	@RequestMapping("/login")
	public ModelAndView loginView(@RequestParam(value="forwardUrl",defaultValue="home") String forwardUrl) {
		if(forwardUrl.equals("home")){
		return new ModelAndView("login");
		}else{
			return new ModelAndView("redirect:forwardUrl");
		}
	}

	@RequestMapping("/loginform")
	public ModelAndView loginAction(@RequestParam("username") String username,
			@RequestParam("password") String password, HttpServletRequest request) {

		if (userService.authLogin(username, password, request)) {
			LOGGER.info("Auth SuccessFull with " + username + " : " + password);
			return new ModelAndView("index").addObject("msg", "Logged In Successfully");

		}

		return new ModelAndView("login").addObject("msg", "Invalid Username and Password");

	}

	@RequestMapping("/deactivate")
	public ModelAndView deactivateUser(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (userService.deactivate(request)) {
			LOGGER.info("User Deactivated");
			session.invalidate();
			return new ModelAndView("index", "msg", "Deactivated Successfully");
		} else {
			LOGGER.error("User is already deactivated or User deactivation failed");
			return new ModelAndView("index", "msg", "User Already Deactivated");
		}
	}
}
