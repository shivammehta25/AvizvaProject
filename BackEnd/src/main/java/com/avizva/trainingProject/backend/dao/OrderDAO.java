package com.avizva.trainingProject.backend.dao;

import java.util.List;

import com.avizva.trainingProject.backend.model.Order;

public interface OrderDAO {
	/**
	 * This method takes an order object and save it in the database
	 * @param order
	 * @return boolean weather the order placement is successful or not
	 */
	public boolean addOrder(Order order);
	
	/**
	 * This method takes an order object and updates it
	 * @param order
	 * @return boolean on success
	 */
	public boolean updateOrder(Order order);
	/**
	 * This method deletes the order can only be accessed from admin panel
	 * @param order
	 * @return true on success
	 */
	public boolean removeOrder(Order order);
	/**
	 * Used to fetch all the orders
	 * @return List of all the orders
	 */
	public List<Order> getAllOrder();
	/**
	 * Get order from the order Id
	 * @param orderId
	 * @return Order 
	 */
	public Order getOrderById(int orderId);
	/**
	 * Returns the List of order using the orderNumber
	 * @param orderNumber
	 * @return List of orders
	 */
	public List<Order> getOrderByOrderNumber(String orderNumber);
}
