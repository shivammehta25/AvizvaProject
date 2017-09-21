package com.avizva.trainingProject.backend.dao.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.avizva.trainingProject.backend.dao.OrderDAO;
import com.avizva.trainingProject.backend.model.Order;
import com.avizva.trainingProject.backend.test.config.TestApplicationContextConfig;

@ContextConfiguration(classes=TestApplicationContextConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderDAOTest {

	@Autowired
	private OrderDAO orderDAO;
	
	@Test
	public void testAddOrder(){
		Order order=new Order();
		order.setOrderNumber("Test");
		order.setOrderStatus("Test");
		order.setOrderQuantity(1);
		order.setOrderPaymentDetails("Test");
		order.setUsername("Test");
		order.setProductId(1);
		
		assertTrue(orderDAO.addOrder(order));
	}
	
	@Test
	public void testGetOrderById(){
		Order order=orderDAO.getOrderById(1);
		assertTrue(order.getOrderId()==1);
	}
	
//	@Test
//	public void testUpdateOrder(){
//		Order order=new Order();
//		order.setOrderId(1);
//		order.setOrderNumber("Test");
//		order.setOrderStatus("Test");
//		order.setOrderQuantity(1);
//		order.setOrderPaymentDetails("Test");
//		order.setUsername("Test");
//		order.setProductId(1);
//		
//		assertTrue(orderDAO.updateOrder(order));
//	}
	
//	@Test
//	public void testRemoveOrder(){
//		
//		Order order=new Order();
//	order.setOrderId(1);
//	order.setOrderNumber("Test");
//	order.setOrderStatus("Test");
//	order.setOrderQuantity(1);
//	order.setOrderPaymentDetails("Test");
//	order.setUsername("Test");
//	order.setProductId(1);
//		
//		assertTrue(orderDAO.removeOrder(order));
//	}
}
