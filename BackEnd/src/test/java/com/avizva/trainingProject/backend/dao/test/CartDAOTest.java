package com.avizva.trainingProject.backend.dao.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.avizva.trainingProject.backend.dao.CartDAO;
import com.avizva.trainingProject.backend.model.Cart;
import com.avizva.trainingProject.backend.model.Cart;
import com.avizva.trainingProject.backend.test.config.TestApplicationContextConfig;

@ContextConfiguration(classes=TestApplicationContextConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CartDAOTest {

	@Autowired
	private CartDAO cartDAO;
	
	@Test
	public void testAddProductToCart(){
		Cart cart=new Cart();
		cart.setUsername("Test");
		cart.setProductId(1);
		cart.setCartQuantity(1);
		
		assertTrue(cartDAO.addProductToCart(cart));
	}
	
	@Test
	public void testGetCartById(){
		Cart cart=cartDAO.getCartById(1);
		assertTrue(cart.getCartId()==1);
	}
	
	@Test
	public void testUpdateCartQuantity(){
		
		Cart cart=new Cart();
	cart.setCartId(1);
	cart.setUsername("Test");
	cart.setProductId(1);
	cart.setCartQuantity(1);
		
		assertTrue(cartDAO.updateCartQuantity(cart));
	}
	
//	@Test
//	public void testRemoveProductFromCart(){
//		
//		Cart cart=new Cart();
//	cart.setCartId(1);	
//	cart.setUsername("Test");
//	cart.setProductId(1);
//	cart.setCartQuantity(1);
//		
//		assertTrue(cartDAO.removeProductFromCart(cart));
//	}

}
