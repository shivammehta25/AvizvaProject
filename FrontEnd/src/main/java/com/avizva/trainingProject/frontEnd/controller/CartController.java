package com.avizva.trainingProject.frontEnd.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.trainingProject.backend.dao.CartDAO;
import com.avizva.trainingProject.backend.dao.ProductDAO;
import com.avizva.trainingProject.backend.service.CartService;

/**
 * 
 * @author Akshay.Chourasia
 *
 */
@SuppressWarnings("unused")
@Controller
public class CartController {
	private static final Logger LOGGER = Logger.getLogger(CategoryController.class);
	
	@Autowired
	CartService cartService;
	//Have to add the the current request url for calling this thing xP
	
	@RequestMapping("/addtocart")
	public ModelAndView addToCart(@RequestParam("productId") int productId , @RequestParam(value="productQuantity",defaultValue="1") int productQuantity, @RequestParam("forwardUrl") String forwardUrl , HttpSession session){
		if(session.getAttribute("username") == null){
			return new ModelAndView("login?forwardUrl?="+ forwardUrl).addObject("msg", "You Must be Logged in to Shop");
		}
		int cartId  = cartService.hasProduct(productId);
		if(cartId != 0){
			return new ModelAndView("redirect:/updateCart?cartId=" +cartId + "&cartQuantity?=" + productQuantity );
		}
		
		if(cartService.addProductToCart(productId,productQuantity,session)){
			return new ModelAndView("cart").addObject("msg" , "Product Added to Cart Successfully");
		}
		return new ModelAndView("products").addObject("msg" , "Product Could Not be Added to Cart Please try again Later");
		
	}
	
	@RequestMapping("/removefromcart")
	public ModelAndView removeFromCart(@RequestParam("cartId") int cartId , HttpSession session ){
		if(session.getAttribute("username") == null){
			return new ModelAndView("login").addObject("msg", "You Must be Logged in to Shop");
		}
		if(cartService.removeProductFromCart(cartId)){
			return new ModelAndView("cart").addObject("msg" , "Item removed from Cart");
		}
		return new ModelAndView("cart").addObject("msg" , "Error removing Item from Cart Try again later");
		
		
	}
	
	@RequestMapping("/updateCart")
	public ModelAndView updateCart(@RequestParam("productId") int productId , @RequestParam("cartQuantity") int cartQuantity , HttpSession session ){
		if(session.getAttribute("username") == null){
			return new ModelAndView("login").addObject("msg", "You Must be Logged in to Shop");
		}
		if(cartService.updateCartQuantity(productId, cartQuantity , (String)session.getAttribute("username"))){
			return new ModelAndView("cart").addObject("msg" , "Cart Updated Successfully");
		}
		return new ModelAndView("cart").addObject("msg" , "Error While Updating Cart");

		
	}
	
	@RequestMapping("/cart")
	public ModelAndView viewCart(HttpSession session){
		if(session.getAttribute("username") == null){
			return new ModelAndView("login").addObject("msg", "You Must be Logged in to Shop");
		}
		return new ModelAndView("cart").addObject("msg" , "Shopping Cart");
		
	}
	
	
	
	
	
}
