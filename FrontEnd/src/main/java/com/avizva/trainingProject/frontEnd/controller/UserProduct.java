package com.avizva.trainingProject.frontEnd.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserProduct {

	private static final Logger LOGGER = Logger.getLogger(UserProduct.class);

	
	@RequestMapping("/products")
	public ModelAndView callProduct(){
		return new ModelAndView("products");
	}
}
