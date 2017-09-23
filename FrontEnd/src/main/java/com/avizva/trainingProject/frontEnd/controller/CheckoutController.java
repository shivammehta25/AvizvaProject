package com.avizva.trainingProject.frontEnd.controller;


import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.avizva.trainingProject.backend.service.CartService;
import com.avizva.trainingProject.backend.service.CheckoutService;
import com.avizva.trainingProject.backend.service.ProductService;
import com.avizva.trainingProject.backend.service.UserService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Controller
public class CheckoutController {
	
	private static final Logger LOGGER = Logger.getLogger(CheckoutController.class);
	
	
	@Autowired
	CheckoutService checkoutService;

	@Autowired
	CartService cartService;
	
	@Autowired
	UserService userService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, "orderDate", new CustomDateEditor(format, false));
		
	}
	
	
	@RequestMapping("/checkout")
	public ModelAndView checkoutCart(@RequestParam("cartList") String cartList , @RequestParam("quantity") String quantity , @RequestParam("totalPrice") String totalPrice , HttpSession session){
		
		User user =  userService.getUserByUsername((String)session.getAttribute("username"));
		String orderNumber ;
		orderNumber = user.getName();
		
		LOGGER.info(cartList);
		LOGGER.info(quantity);
		LOGGER.info(totalPrice);
		Gson g = new Gson();
		Type type = new TypeToken<List<Product>>(){}.getType();
		List<Product> prodList =  g.fromJson(cartList, type);
		for(Product p : prodList){
			Cart c = cartService.getCartFromProductId(p.getProductId(), user.getUsername());
			
			orderNumber += "-" + p.getProductId() +"," + c.getCartQuantity();
		}
		
		LOGGER.info("Checking Out Order Number" + orderNumber);
		
		return new ModelAndView("checkout").addObject("user" , user).addObject("quantity", quantity).addObject("totalPrice" , totalPrice).addObject("prodList", prodList).addObject("orderNumber",orderNumber);
		
	}
	
	
	@RequestMapping("/adduserproduct")
	public ModelAndView addUserProduct(@RequestParam("orderNumber") String orderNumber , @RequestParam("username") String username , @RequestParam("shippingAddress") String shippingAddress , @RequestParam("shippingCountry") String shippingCountry,
										@RequestParam("shippingCity")String shippingCity , @RequestParam("shippingPin")int shippingPin , @RequestParam("orderPaymentDetails") String orderPaymentDetails){
		Date orderDate = new Date();
		if(checkoutService.addUserProduct(orderNumber, username, shippingAddress, shippingCountry, shippingCity, shippingPin, orderPaymentDetails , orderDate)){
				String[] getProducts = orderNumber.split("-");
				
				for(int i = 1 ; i < getProducts.length ; i++ ){
					String temp = getProducts[i].split(",")[0];
						Cart c = cartService.getCartFromProductId(Integer.parseInt(temp), username);
						cartService.removeProductFromCart(c.getCartId());
			            LOGGER.info("Removed Product From Cart " + c.getCartId());
				}
			return new ModelAndView("orderconfirmation").addObject("msg" , "Order Placed Successfully");
		}
			return new ModelAndView("cart").addObject("Error while Placing Order ");		
	}
	
	
	@RequestMapping("orderconfirmation")
	public ModelAndView orderConfirm(){
		return new ModelAndView("orderconfirmation");
	}
	
	
	
}
