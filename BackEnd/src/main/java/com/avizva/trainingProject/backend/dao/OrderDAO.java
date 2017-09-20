package com.avizva.trainingProject.backend.dao;

import java.util.List;

import com.avizva.trainingProject.backend.model.Order;

public interface OrderDAO {
	public boolean addOrder(Order order);
	public boolean updateOrder(Order order);
	public boolean removeOrder(Order order);
	public List<Order> getAllOrder();
	public Order getOrderById(int orderId);
}
