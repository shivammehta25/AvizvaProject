package com.avizva.trainingProject.backend.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.avizva.trainingProject.backend.model.Cart;
import com.avizva.trainingProject.backend.model.Product;

/**
 * 
 * @author Akshay.Chourasia
 * <p>
 *	This Interface is been used to apply the busniess logic
 *  which is communicating with the methods of DAO
 *	and this CartService interface contains method which is further implemented in
 *	CartServiceImpl class.
 */
public interface CartService {
	
	/**
	 * 
	 * @param productId
	 * @param productQuantity
	 * @param session
	 * @return
	 */
	public boolean addProductToCart(int productId , int productQuantity , HttpSession session);
	
	/**
	 * 
	 * @param cartId
	 * @return
	 */
	public boolean removeProductFromCart(int cartId);
	
	/**
	 * 
	 * @param productId
	 * @param CartQuantity
	 * @param username
	 * @return
	 */
	public boolean updateCartQuantity(int productId,int CartQuantity,String username);
	
	/**
	 * 
	 * @param username
	 * @param discount
	 * @return
	 */
	public Long priceCalculator(String username,Long ...discount);
	
	/**
	 * 
	 * @param productId
	 * @return
	 */
	public boolean hasCartProduct(int productId , String username);
	
	/**
	 * 
	 * @return
	 */
	public List<Product> allProductInCart(String username);
	/**
	 * 
	 * @param listCart
	 * @param username
	 * @return
	 */
	public List<Integer> getQuantityOfProductInCart(List<Product> listCart,String username);
	
	/**
	 * 
	 * @param productId
	 * @return
	 */
	public int getQuantity(int productId,String username);
	/**
	 * 
	 * @param productId
	 * @param username
	 * @return
	 */
	public Cart getCartFromProductId(int productId , String username);
	
}
