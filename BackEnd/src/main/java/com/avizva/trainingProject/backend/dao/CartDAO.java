package com.avizva.trainingProject.backend.dao;

import java.util.List;

import com.avizva.trainingProject.backend.model.Cart;
import com.avizva.trainingProject.backend.model.Product;
/**
 * 
 * @author Akshay.Chourasia
 * <p>
 *	This Interface is been used to manipulate the data in DataBase
 *	and this CartDAO interface contains method which is further implemented in
 *	cartDAOImpl class.
 */
public interface CartDAO {
	
	/**
	 * @param cart  This object is been passed to addProductToCart method as a parameter.
	 * @return Its return type is boolean.
	 * <p>
	 * This method is used to add the product to the cart. 
	 * 
	 */
	public boolean addProductToCart(Cart cart);
	
	
	
	/**
	 * @param cart  This object is been passed to removeProductFromProduct method as a parameter.
	 * @return Its return type is boolean.
	 * <p>
	 * This method is used to remove the product to the cart. 
	 * 
	 */
	public boolean removeProductFromCart(Cart cart);
	
	
	
	
	
	/**
	 * @param  cart  This object is been passed to updateCartQuantity method as a parameter.
	 * @return Its return type is boolean.
	 * <p>
	 * This method is used to update the product details in the cart. 
	 * 
	 */
	public boolean updateCartQuantity(Cart cart);
	
	
	
	
	
	
	/**
	 * @param Long    This object is been passed to priceCalculator method as a parameter.
	 * @return Its return type is Long.
	 * <p>
	 * This method is used to remove the product from the cart. 
	 * 
	 */
	 public Long priceCalculator(Long ...discount);
	
	 
	 
	 
	 
	 /**
	 * @param  cartId  This object is been passed to getCartById method as a parameter.
	 * @return Its return type is boolean.
	 * <p>
	 * This method is used to remove the product from the cart. 
	 * 
	 */
	public Cart getCartById(int cartId);
	
	
	/**
	 * @param  username  This object is been passed to getAllCartByUser method as a parameter.
	 * @return Its return type is List of type Cart.
	 * <p>
	 * This method is used to remove the product from the cart. 
	 * 
	 */
	public List<Cart> getAllCartByUser(String username);
	
	
	
	/**
	 * 
	 * @param  productId,username  This object is been passed to getCartByProductId method as a parameter.
	 * @return Its return type is Cart.
	 * <p>
	 * This method is used to remove the product from the cart. 
	 * 
	 */
	public Cart getCartByProductId(int productId , String username);
	
	
	/**
	 *@return Its return type is boolean.
	 * <p>
	 * This method is used to get all the product in cart from database. 
	 * 
	 */
	public List<Cart> getAllCart();
}
