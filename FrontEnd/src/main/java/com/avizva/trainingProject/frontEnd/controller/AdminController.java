package com.avizva.trainingProject.frontEnd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.trainingProject.backend.model.Supplier;
import com.avizva.trainingProject.backend.service.CategoryService;
import com.avizva.trainingProject.backend.service.ProductService;
import com.avizva.trainingProject.backend.service.SupplierService;

@Controller
public class AdminController {
	@Autowired
	SupplierService supplierService;
		
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;

	@RequestMapping("/admin")
	public ModelAndView adminPanel( ) {
		int totalsupp  = supplierService.getAllSupplier().size();
		int totalcat = categoryService.getAllCategory().size();
		int totalprod = productService.getAllProduct().size();
		List<Supplier> allSupp = supplierService.getAllSupplier();
		return new ModelAndView("admin/index").addObject("totalsupp" , totalsupp).addObject("totalcat" , totalcat).addObject("allSupp" , allSupp).addObject("totalprod" , totalprod);
	}

	@RequestMapping("/loginadmin")
	public ModelAndView callAdminLogin() {
		return new ModelAndView("admin/login");
	}
	
	@RequestMapping("/loginError")
	public ModelAndView loginError(){
		return new ModelAndView("redirect:/admin","msg" , "Invalid User Credentials");
	}
	
	//AdminManageSupplier in Supplier Controller
	
	//AdminManageCategory in Category Controller
	
	//AdminManageProduct in Product Controller

}
