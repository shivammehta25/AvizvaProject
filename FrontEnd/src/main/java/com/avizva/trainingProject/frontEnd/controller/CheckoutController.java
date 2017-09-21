package com.avizva.trainingProject.frontEnd.controller;


import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.trainingProject.backend.dao.CartDAO;
import com.avizva.trainingProject.backend.dao.UserDAO;
import com.avizva.trainingProject.backend.model.Cart;
import com.avizva.trainingProject.backend.model.Product;
import com.avizva.trainingProject.backend.model.User;
import com.avizva.trainingProject.backend.service.CheckoutService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
public class CheckoutController {
	
	private static final Logger LOGGER = Logger.getLogger(CheckoutController.class);
	
	
	@Autowired
	UserDAO userDAO;
//	
	@Autowired
	CheckoutService checkoutService;
//	
	@Autowired
	CartDAO cartDAO;
	
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, "orderDate", new CustomDateEditor(format, false));
		
	}
	
	
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
			Cart c = cartDAO.getCartByProductId(p.getProductId(), user.getUsername());
			
			orderNumber += "-" + p.getProductId() +"," + c.getCartQuantity();
		}
		
		LOGGER.info("Checking Out Order Number" + orderNumber);
		
		return new ModelAndView("checkout").addObject("user" , user).addObject("quantity", quantity).addObject("totalPrice" , totalPrice).addObject("prodList", prodList).addObject("orderNumber",orderNumber);
		
	}
	
	
	@RequestMapping("/adduserproduct")
	public ModelAndView addUserProduct(@RequestParam("orderNumber") String orderNumber , @RequestParam("username") String username , @RequestParam("shippingAddress") String shippingAddress , @RequestParam("shippingCountry") String shippingCountry,
										@RequestParam("shippingCity")String shippingCity , @RequestParam("shippingPin")int shippingPin , @RequestParam("orderPaymentDetails") String orderPaymentDetails){
	/*	LOGGER.info(" Order Date = " + orderDateString);
		Date orderDate = null;
		try {
			orderDate = new SimpleDateFormat("dd/MM/yyyy").parse(orderDateString);
		} catch (ParseException e) {
			LOGGER.error("Cannot Parse Date");
		}*/
		Date orderDate = new Date();
		if(checkoutService.addUserProduct(orderNumber, username, shippingAddress, shippingCountry, shippingCity, shippingPin, orderPaymentDetails , orderDate)){
			return new ModelAndView("orderconfirmation").addObject("msg" , "Order Placed Successfully");
		}
			return new ModelAndView("cart").addObject("Error while Placing Order ");		
	}
	
}
