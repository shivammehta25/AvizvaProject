package com.avizva.trainingProject.frontEnd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	@RequestMapping("/admin")
	public ModelAndView adminPanel(){
		return new ModelAndView("admin/index");
	}
	
	@RequestMapping("/loginadmin")
	public ModelAndView callAdminLogin(){
		return new ModelAndView("admin/login");
	}
	@RequestMapping("/adminx")
	public ModelAndView callX(){
		return new ModelAndView("admin/x");
	}
	
	@RequestMapping("/managecat")
	public ModelAndView manageCategories(){
		
		
		return new ModelAndView("admin/categories");
		
	}
	
	@RequestMapping("/manageprod")
	public ModelAndView manageProducts(){
		
		
		return new ModelAndView("admin/products");
		
	}
	
	@RequestMapping("/managesup")
	public ModelAndView manageSuppliers(){
		return new ModelAndView("admin/suppliers");
		
	}
	
}
