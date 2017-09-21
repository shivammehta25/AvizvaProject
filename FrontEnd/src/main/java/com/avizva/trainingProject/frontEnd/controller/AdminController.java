package com.avizva.trainingProject.frontEnd.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.trainingProject.backend.model.Category;
import com.avizva.trainingProject.backend.model.Order;
import com.avizva.trainingProject.backend.model.Product;
import com.avizva.trainingProject.backend.model.Supplier;
import com.avizva.trainingProject.backend.service.CategoryService;
import com.avizva.trainingProject.backend.service.OrderService;
import com.avizva.trainingProject.backend.service.ProductService;
import com.avizva.trainingProject.backend.service.SupplierService;
import com.google.gson.Gson;

@Controller
public class AdminController {
	
	private static final Logger LOGGER = Logger.getLogger(AdminController.class);

	@Autowired
	SupplierService supplierService;
		
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	OrderService orderService;

	@RequestMapping("/admin")
	public ModelAndView adminPanel( ) {
		int totalsupp  = supplierService.getAllSupplier().size();
		int totalcat = categoryService.getAllCategory().size();
		int totalprod = productService.getAllProduct().size();
		int totalorder= orderService.getAllOrder().size();
		List<Supplier> allSupp = supplierService.getAllSupplier();
		List<Product> listProd = productService.getAllProduct();
		Map<String , Integer> quantList = new HashMap<String , Integer>();
		for(Product c : listProd ){
			quantList.put(c.getProductName(), c.getProductQuantity());
		}
		Gson g = new Gson();
		String listOfProd = g.toJson(quantList);
		return new ModelAndView("admin/index").addObject("totalsupp" , totalsupp).addObject("totalcat" , totalcat).addObject("allSupp" , allSupp).addObject("totalprod" , totalprod).addObject("totalorder" , totalorder)
				.addObject("listProd" , quantList);
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
	
	//AdminManageOrder in Order Controller
	

}
