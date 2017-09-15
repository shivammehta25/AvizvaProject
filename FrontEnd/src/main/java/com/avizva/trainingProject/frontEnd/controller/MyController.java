package com.avizva.trainingProject.frontEnd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping("/managecat")
	public ModelAndView manageCategories(){


	return new ModelAndView("admin/categories");

	}
}
