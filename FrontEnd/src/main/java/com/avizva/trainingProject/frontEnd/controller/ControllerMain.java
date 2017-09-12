package com.avizva.trainingProject.frontEnd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControllerMain {

	@RequestMapping("/")
	public ModelAndView viewIndex(){
		return new ModelAndView("index");
	}
	@RequestMapping("registration")
	public ModelAndView registerit(){
		return new ModelAndView("registration");
	}
	@RequestMapping("contact")
	public ModelAndView contactcall(){
		return new ModelAndView("contactus");
	}
	@RequestMapping("aboutus")
	public ModelAndView aboutuscall(){
		return new ModelAndView("aboutus");
	}
	
}
