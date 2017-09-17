package com.avizva.trainingProject.frontEnd.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AdminController {
	
	


	@RequestMapping("/admin")
	public ModelAndView adminPanel( ) {
		
		return new ModelAndView("admin/index");
	}

	@RequestMapping("/loginadmin")
	public ModelAndView callAdminLogin() {
		return new ModelAndView("admin/login");
	}

	

	@RequestMapping("/adminmanageprod")
	public ModelAndView manageProducts(){
		return new ModelAndView("admin/products");
	}

	//AdminManageCat in Supplier Controller
	
	
	@RequestMapping("/loginError")
	public ModelAndView loginError(){
		return new ModelAndView("redirect:/admin","msg" , "Invalid User Credentials");
	}
	//AdminManageSupplier in Supplier Controller
	
	//AdminManageCategory in Category Controller

}
