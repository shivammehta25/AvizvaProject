package com.avizva.trainingProject.backend.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avizva.trainingProject.backend.dao.CartDAO;
import com.avizva.trainingProject.backend.dao.ProductDAO;
import com.avizva.trainingProject.backend.model.Cart;
import com.avizva.trainingProject.backend.model.Product;
/**
 * 
 * @author Akshay.Chourasia
 * @Service This makes the class a service bean
 * <p>
 *  Manages the Request and DAO of Cart
 */

@Transactional
@Service
public class CartServiceImpl implements CartService {
	
	private static final Logger LOGGER = Logger.getLogger(CartServiceImpl.class);


	@Autowired
	ProductDAO productDAO;
	@Autowired
	CartDAO cartDAO;
	/**
	 * Method used to add products to the Cart
	 */
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
			flag = true;
		}
		
		return flag;
	}

	/**
	 * Method used to remove products from cart
	 */
	
	public boolean removeProductFromCart(int cartId) {
		LOGGER.info("<-- CartService.removeProductfromCart Called--->");
		boolean flag = false;
		Cart cart = cartDAO.getCartById(cartId);
		if(cart != null){
			return cartDAO.removeProductFromCart(cart);
			
		}
		return flag;
	}

	/**
	 * Method used to Update Quantity in the cart
	 * 
	 */
	
	public boolean updateCartQuantity(int productId, int cartQuantity , String username) {
		LOGGER.info("<-- CartService.updateCartQuantity Called--->");
		Cart cart = cartDAO.getCartByProductId(productId ,username);	
		Product p = productDAO.getProductById(productId);
		LOGGER.info("Product Quantity " + p.getProductQuantity() + " Cart QUantity" + cartQuantity);
		if(p.getProductQuantity() < cartQuantity){
			LOGGER.error("Cart Has more product than Stock");
			return false;
		}
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

	
	/**
	 * Method used to calculate the total price of items into the cart
	 */
	
	public Long priceCalculator(String username, Long... discount) {
		LOGGER.info("<-- CartService.priceCalculator Called--->");
		List<Cart> listCart = cartDAO.getAllCartByUser(username);
		Long price = 0L;
		for(Cart c : listCart){
			Product p = productDAO.getProductById(c.getProductId());
			price += p.getProductPrice()* c.getCartQuantity();
		}
		if(discount[0] != null){
			price -= discount[0];
		}
		return price;
	}

/**
 *  This method checks weather the product already exists in the cart of not
 */

	public boolean hasCartProduct(int productId,String username) {
		Cart cart = cartDAO.getCartByProductId(productId, username);
		LOGGER.info("<-------------------------------------------- Product feetched " + cart);
		if(cart != null)
			return true;
		else
			return false;
	}

	/**
	 * 	This method returns all the products in the cart
	 * 
	 */


	public List<Product> allProductInCart(String username) {
		List<Cart> listCart = cartDAO.getAllCartByUser(username);
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


	/**
	 * 	This is used to fetch the quantity of all the  product from the cart
	 * 
	 */

	public List<Integer> getQuantityOfProductInCart(List<Product> listCart , String username) {
		List<Integer> quantityList = new ArrayList<Integer>();
		LOGGER.info("INside get quantity of product in cart " + listCart);
		for(Product p : listCart){
		quantityList.add(cartDAO.getCartByProductId(p.getProductId(), username).getCartQuantity());
		}
		return quantityList;
	}

	/**
	 * This is used to fetch quantity of the product from the cart
	 */

	public int getQuantity(int productId , String username) {
		Cart c = cartDAO.getCartByProductId(productId, username);
		
		return c.getCartQuantity();
	}

	/**
	 * This is used to fetch the cart from the product Id
	 */

	public Cart getCartFromProductId(int productId, String username) {
		Cart c = cartDAO.getCartByProductId(productId, username);
		if(c != null){
			return c;
		}
		return null;
	}




}
