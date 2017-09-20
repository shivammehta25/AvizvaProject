package com.avizva.trainingProject.frontEnd.controller;


import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.trainingProject.backend.dao.UserDAO;
import com.avizva.trainingProject.backend.model.Product;
import com.avizva.trainingProject.backend.model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
public class CheckoutController {
	
	private static final Logger LOGGER = Logger.getLogger(CheckoutController.class);
	
	
	@Autowired
	UserDAO userDAO;
	
	
	
	
	@RequestMapping("/checkout")
	public ModelAndView checkoutCart(@RequestParam("cartList") String cartList , @RequestParam("quantity") String quantity , @RequestParam("totalPrice") String totalPrice , HttpSession session){
		
		User user =  userDAO.getUserByUsername((String)session.getAttribute("username"));
		String orderNumber ;
		orderNumber = user.getName();
		
		LOGGER.info(cartList);
		LOGGER.info(quantity);
		LOGGER.info(totalPrice);
		Gson g = new Gson();
		Type type = new TypeToken<List<Product>>(){}.getType();
		List<Product> prodList =  g.fromJson(cartList, type);
		for(Product p : prodList){
			orderNumber += "-" + p.getProductId();
		}
		
		LOGGER.info("Checking Out Order Number" + orderNumber);
		
		
		return new ModelAndView("checkout").addObject("user" , user).addObject("quantity", quantity).addObject("totalPrice" , totalPrice).addObject("prodList", prodList);
		
	}
	
	
	
}
