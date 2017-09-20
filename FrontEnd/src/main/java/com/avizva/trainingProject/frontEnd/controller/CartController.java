package com.avizva.trainingProject.frontEnd.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.trainingProject.backend.dao.CartDAO;
import com.avizva.trainingProject.backend.dao.ProductDAO;
import com.avizva.trainingProject.backend.model.Cart;
import com.avizva.trainingProject.backend.model.Product;
import com.avizva.trainingProject.backend.service.CartService;
import com.avizva.trainingProject.backend.service.ProductService;
import com.google.gson.Gson;

/**
 * 
 * @author Akshay.Chourasia
 *
 */
@SuppressWarnings("unused")
@Controller
public class CartController {
	private static final Logger LOGGER = Logger.getLogger(CartController.class);
	
	@Autowired
	CartService cartService;
	//Have to add the the current request url for calling this thing xP
	
	@RequestMapping("/addtocart")
	public ModelAndView addToCart(@RequestParam("productId") int productId , @RequestParam(value="productQuantity",defaultValue="1") int productQuantity, HttpSession session , HttpServletRequest request){
		if(session.getAttribute("username") == null){
			return new ModelAndView("redirect:/login?forwardUrl?="+request.getHeader("Referer")).addObject("msg", "You Must be Logged in to Shop");
		}
		LOGGER.info("<-- Inside add to Cart Controller -->" + productId + productQuantity);
		boolean cartQuantity  = cartService.hasCartProduct(productId , (String)session.getAttribute("username"));
		
		LOGGER.info("Cart ID that came " + cartQuantity);
		if(cartQuantity){
			int quantity = cartService.getQuantity(productId , (String)session.getAttribute("username") );
			LOGGER.info("Cart Quantity fetched" + quantity);
			productQuantity += quantity;
			LOGGER.info(productId + " ALready Present Rather Updating with quantity" + productQuantity);
			return new ModelAndView("redirect:/updateCart?productId=" +productId + "&cartQuantity=" + productQuantity );
		}
		
		if(cartService.addProductToCart(productId,productQuantity,session)){
			return new ModelAndView("redirect:/cart").addObject("msg" , "Product Added to Cart Successfully");
		}
		return new ModelAndView("products").addObject("msg" , "Product Could Not be Added to Cart Please try again Later");
		
	}
	
	@RequestMapping("/removefromcart")
	public ModelAndView removeFromCart(@RequestParam("productId") int productId , HttpSession session ){
		if(session.getAttribute("username") == null){
			return new ModelAndView("redirect:/login").addObject("msg", "You Must be Logged in to Shop");
		}
		Cart c = cartService.getCartFromProductId(productId , (String)session.getAttribute("username"));
		if(cartService.removeProductFromCart(c.getCardId())){
			return new ModelAndView("redirect:/cart").addObject("msg" , "Item removed from Cart");
		}
		return new ModelAndView("redirect:/cart").addObject("msg" , "Error removing Item from Cart Try again later");
		
		
	}
	
	@RequestMapping("/updateCart")
	public ModelAndView updateCart(@RequestParam("productId") int productId , @RequestParam("cartQuantity") int cartQuantity , HttpSession session ){
		LOGGER.error("<-- Add To Cart bhejde idhar -->" + cartQuantity + productId);
		if(session.getAttribute("username") == null){
			return new ModelAndView("redirect:/login").addObject("msg", "You Must be Logged in to Shop");
		}
		if(cartService.updateCartQuantity(productId, cartQuantity , (String)session.getAttribute("username"))){
			return new ModelAndView("redirect:/cart").addObject("msg" , "Cart Updated Successfully");
		}
		return new ModelAndView("redirect:/cart").addObject("msg" , "Error While Updating Cart");

		
	}
	
	@RequestMapping("/cart")
	public ModelAndView viewCart(HttpSession session , @RequestParam(value="discount",defaultValue="0")Long discount , HttpServletRequest request){
		if(session.getAttribute("username") == null){
			return new ModelAndView("redirect:/login").addObject("msg", "You Must be Logged in to Shop");
		}
		
		List<Product> listCart = cartService.allProductInCart();
		List<Integer> quantityList = cartService.getQuantityOfProductInCart(listCart, (String)session.getAttribute("username"));
		
		Gson g = new Gson();
		String cartList = g.toJson(listCart);
		String quantity = g.toJson(quantityList);
		Long totalPrice = cartService.priceCalculator((String)session.getAttribute("username"),discount);
		String totalPriceJ = g.toJson(totalPrice);
		return new ModelAndView("cart").addObject("msg" , "Shopping Cart")
				.addObject("cartList" , cartList)
				.addObject("quantity" , quantity)
				.addObject("totalPrice" , totalPriceJ)
				.addObject("cartactive" , "active");
		
	}
	
	
	
	
	
}
