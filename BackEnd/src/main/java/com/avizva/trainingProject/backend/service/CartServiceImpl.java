package com.avizva.trainingProject.backend.service;

import java.util.ArrayList;
import java.util.List;

import javax.mail.Session;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avizva.trainingProject.backend.dao.CartDAO;
import com.avizva.trainingProject.backend.dao.ProductDAO;
import com.avizva.trainingProject.backend.model.Cart;
import com.avizva.trainingProject.backend.model.Product;


@Service
public class CartServiceImpl implements CartService {
	
	private static final Logger LOGGER = Logger.getLogger(CartServiceImpl.class);


	@Autowired
	ProductDAO productDAO;
	@Autowired
	CartDAO cartDAO;
	
	public boolean addProductToCart(int productId , int productQuantity , HttpSession session) {
		boolean flag = false; 
		Product product = productDAO.getProductById(productId);
		Cart cart = new Cart();
		if(product != null){
			cart.setProductId(productId);
			if(product.getProductQuantity() < productQuantity){
				return false;
			}
			cart.setCartQuantity(productQuantity);
			cart.setUsername((String)session.getAttribute("username"));
			cartDAO.addProductToCart(cart);
			flag = true;
		}
		
		return flag;
	}

	
	
	public boolean removeProductFromCart(int cartId) {
		boolean flag = false;
		Cart cart = cartDAO.getCartById(cartId);
		if(cart != null){
			return cartDAO.removeProductFromCart(cart);
			
		}
		return flag;
	}

	
	
	public boolean updateCartQuantity(int productId, int cartQuantity , String username) {
		Cart cart = cartDAO.getCartByProductId(productId ,username);		
		if( cart != null)
		{
			Product product  = productDAO.getProductById(cart.getProductId());
		
			if(product != null){
				cart.setCartQuantity(cartQuantity);
				return cartDAO.updateCartQuantity(cart);
			}
		
	
		}
		return false;
		
		
	}

	
	
	public Long priceCalculator(String username, Long... discount) {
		List<Cart> listCart = cartDAO.getAllCartByUser(username);
		Long price = 0L;
		for(Cart c : listCart){
			Product p = productDAO.getProductById(c.getProductId());
			price += p.getProductPrice();
		}
		if(discount[0] != null){
			price -= discount[0];
		}
		return price;
	}



	public boolean hasCartProduct(int productId) {
		Cart cart = cartDAO.getCartById(productId);
		LOGGER.info("<-------------------------------------------- Product feetched " + cart);
		if(cart != null)
			return true;
		else
			return false;
	}



	public List<Product> allProductInCart() {
		List<Cart> listCart = cartDAO.getAllCart();
		LOGGER.info(listCart + "product");
		List<Product> listProduct = new ArrayList<Product>();
		try {
			LOGGER.info("fetced all roducts from List Product");
			for(Cart c : listCart){
				listProduct.add(productDAO.getProductById(c.getProductId()));
			}
		} catch (Exception e) {
			LOGGER.error("Error Retreiving Object from Cart Quantity!");
		}
		return listProduct;
	}



	public List<Integer> getQuantityOfProductInCart(List<Product> listCart , String username) {
		List<Integer> quantityList = new ArrayList<Integer>();
		LOGGER.info("INside get quantity of product in cart " + listCart);
		for(Product p : listCart){
		quantityList.add(cartDAO.getCartByProductId(p.getProductId(), username).getCartQuantity());
		}
		return quantityList;
	}



	public int getQuantity(int productId) {
		Cart c = cartDAO.getCartById(productId);
		
		return c.getCartQuantity();
	}



	public Cart getCartFromProductId(int productId, String username) {
		Cart c = cartDAO.getCartByProductId(productId, username);
		if(c != null){
			return c;
		}
		return null;
	}




}
