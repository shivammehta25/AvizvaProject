package com.avizva.trainingProject.frontEnd.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.trainingProject.backend.model.Category;
import com.avizva.trainingProject.backend.model.Order;
import com.avizva.trainingProject.backend.model.Supplier;
import com.avizva.trainingProject.backend.service.CategoryService;
import com.avizva.trainingProject.backend.service.OrderService;
import com.avizva.trainingProject.backend.service.ProductService;
import com.avizva.trainingProject.backend.service.SupplierService;

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
	
	
	@RequestMapping("/adminmanageorder")
	public ModelAndView manageOrders(@ModelAttribute("msg") String msg) {
		List<Order> listOrder= orderService.getAllOrder();
		LOGGER.info("<-- Inisde Order Manager Controller -->" + listOrder + "Message" + msg.length() + "abc");
		ModelAndView orderHome = new ModelAndView();
		orderHome.setViewName("admin/orders");
		orderHome.addObject("listOrder",listOrder); 
		if(msg.length() == 0 ){
			orderHome.addObject("msg" , "Order Management System");
		}
		return orderHome;
	}

}
