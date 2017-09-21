package com.avizva.trainingProject.backend.service;

import java.util.List;

import com.avizva.trainingProject.backend.model.Order;

public interface OrderService {
	public boolean addOrder(Order order);
	
	public boolean updateOrder(Order order);
	
	public boolean deleteOrder(int orderId);
	
	public List<Order> getAllOrder();
	
	public List<Order> searchOrder(String orderNumber);
}
