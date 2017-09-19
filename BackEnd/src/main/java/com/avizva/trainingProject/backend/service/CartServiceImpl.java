package com.avizva.trainingProject.backend.service;

import java.util.List;

import javax.mail.Session;
import javax.servlet.http.HttpSession;

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
			
		}
		
		return false;
	}

	
	
	public boolean removeProductFromCart(int cartId) {
		boolean flag = false;
		Cart cart = cartDAO.getCartById(cartId);
		if(cart != null){
			return cartDAO.removeProductFromCart(cart);
			
		}
		return flag;
	}

	
	
	public boolean updateCartQuantity(int cartId, int cartQuantity) {
		Cart cart = cartDAO.getCartById(cartId);
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



	public int hasProduct(int productId) {
		Product product = productDAO.getProductById(productId);
		return product.getProductId();
	}

}
