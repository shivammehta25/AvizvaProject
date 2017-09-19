package com.avizva.trainingProject.backend.service;

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

	@Autowired
	ProductDAO productDAO;
	@Autowired
	CartDAO cartDAO;
	
	private static final Logger LOGGER = Logger.getLogger(CartServiceImpl.class);

	
	public boolean addProductToCart(int productId , int productQuantity , HttpSession session) {
		LOGGER.info("<-- CartService.addProductToCart Called--->");
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
		}
		
		return false;
	}

	
	
	public boolean removeProductFromCart(int cartId) {
		LOGGER.info("<-- CartService.removeProductfromCart Called--->");
		boolean flag = false;
		Cart cart = cartDAO.getCartById(cartId);
		if(cart != null){
			return cartDAO.removeProductFromCart(cart);
			
		}
		return flag;
	}

	
	
	public boolean updateCartQuantity(int productId, int cartQuantity , String username) {
		LOGGER.info("<-- CartService.updateCartQuantity Called--->");
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
		LOGGER.info("<-- CartService.priceCalculator Called--->");
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



	public int hasProduct(int productId) {
		LOGGER.info("<-- CartService.hasProduct Called--->");
		Product product = productDAO.getProductById(productId);
		return product.getProductId();
	}



	public List<Product> allProductInCart() {
		List<Cart> listCart = cartDAO.getAllCart();
		List<Product> listProduct = null;
		for(Cart c : listCart){
			listProduct.add(productDAO.getProductById(c.getProductId()));
		}
		return listProduct;
	}


}
