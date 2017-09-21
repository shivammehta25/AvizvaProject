package com.avizva.trainingProject.backend.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.avizva.trainingProject.backend.model.Cart;
import com.avizva.trainingProject.backend.model.Product;

@Repository
@Transactional
public class CartDAOImpl implements CartDAO {

	private static final Logger LOGGER = Logger.getLogger(CartDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public boolean addProductToCart(Cart cart) {
		boolean flag = false; 
		Session session = getSession();
		try{
			session.save(cart);
			LOGGER.info("<-- Added Product to the Cart -->");
			flag =true;
		
		}catch (Exception e){
			LOGGER.error("<-- Could Not add Product to the cart -->");
		}
		return flag;
	}

	public boolean removeProductFromCart(Cart cart) {
		boolean flag = false;
		Session session = getSession();
		try{
			session.flush();
			session.clear();
			session.delete(cart);
			flag = true;
			LOGGER.info("<-- Item from Cart Deleted -->");
			
		}catch (Exception e) {
			LOGGER.error("<-- Error while deleting Item from cart");
		}
		
		return flag;
	}

	public boolean updateCartQuantity(Cart cart) {
		boolean flag = false;
		Session session = getSession();
		try{
			session.flush();
			session.clear();
			session.update(cart);
			flag = true;
			LOGGER.info("<--  Cart Quantity Updated -->");
		}catch (Exception e) {
			LOGGER.error("<-- Erorr while updating Cart Quantity");
		}
		return flag;
	}

	public Long priceCalculator(Long... discount) {
		return null;
	}

	public Cart getCartById(int cartId) {
		Session session = getSession();
		Cart cart = null;
		try {
			cart = session.get(Cart.class, cartId);
			LOGGER.info("<-- Got Cart from the cartId : " + cartId);
		}catch (Exception e) {
			LOGGER.error("<-- Error while fetching the cart ID");
		}
		
		
		return cart;
	}

	public List<Cart> getAllCartByUser(String username) {
		Session session = getSession();
		List<Cart> cartList = new ArrayList<Cart>();
		try{
			Query q = session.createQuery("from Cart where username =:username");
			q.setParameter("username", username);
			cartList = q.list();
			LOGGER.info("<-- Fetched all queries --> " + cartList);
		}catch (Exception e) {
			LOGGER.error("<-- Erorr fetching all Query -->");
		}
		
		return cartList;
	}

	public Cart getCartByProductId(int productId , String username) {
		Session session = getSession();
		LOGGER.info("<-- Getting Cart By Product -->" + productId + username);
		Cart cart = null;
		try {
			Query q = session.createQuery("from Cart where productId =:productId and username =:username");
			q.setParameter("productId", productId);
			q.setParameter("username", username);
			cart =(Cart) q.list().get(0);
			LOGGER.info("<-- Fetched Cart from Product Id -->" );
			
		}catch(Exception e){
			LOGGER.error("<-- Error fetching element from product iD -->");
		}
		return cart;
	}

	public List<Cart> getAllCart() {
		Session session = getSession();
		try{
			Query q = session.createQuery("from Cart");
			List<Cart> listCart =  q.list();
			LOGGER.info("<-- Fetched all cart -->");
			return listCart;
		}catch (Exception e) {
			LOGGER.error("<-- Cannot fetch cart-->");
		}
		
		return null;
	}

}
