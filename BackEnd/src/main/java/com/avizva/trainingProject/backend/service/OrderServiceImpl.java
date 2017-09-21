package com.avizva.trainingProject.backend.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avizva.trainingProject.backend.dao.OrderDAO;
import com.avizva.trainingProject.backend.model.Category;
import com.avizva.trainingProject.backend.model.Order;
import com.avizva.trainingProject.backend.model.Supplier;

@Service
public class OrderServiceImpl implements OrderService {
	private static final Logger LOGGER=Logger.getLogger(OrderServiceImpl.class);

	@Autowired
	OrderDAO orderDAO;
	
	public boolean addOrder(Order order){
		LOGGER.info("<-- OrderService.addOrder Called--->");
		boolean flag=false;
		if(orderDAO.addOrder(order)){
			LOGGER.info("<-- Order Added Successfully--->");
			flag=true;
		}
		else{
			LOGGER.info("<--Couldn't add order.--->");
		}
		return flag;
	}
	
	public boolean updateOrder(Order order){
		LOGGER.info("<-- OrderService.updateOrder Called--->");
		boolean flag = false;
		if(orderDAO.updateOrder(order)){
			LOGGER.info("<-- Order Updated Successfully-->");
			flag = true;
			return flag;
		}
		else{
			LOGGER.error("<-- Could Not Update the Order -->");
			return flag;
		}
	}
	
	public boolean deleteOrder(int orderId){
		LOGGER.info("<-- OrderService.deleteOrder Called--->");
		boolean flag = false;
		Order order=orderDAO.getOrderById(orderId);
		if(order!=null){
			orderDAO.removeOrder(order);
			flag=true;
			LOGGER.info("<-- Order Deleted Successfully-->");
		}else{
			LOGGER.error("<-- Could Not Delete the Order -->");
		}
		return flag;
	}
	

	public List<Order> getAllOrder() {
		LOGGER.info("<-- OrderService.getAllOrder Called--->");
		List<Order> listOrder = orderDAO.getAllOrder();
		LOGGER.info("getAllOrder yielded" + listOrder.size());
		if(listOrder != null){
			return listOrder;
		}else{
			return null;
		}
	}
	
	public List<Order> searchOrder(String orderNumber){
		LOGGER.info("<-- OrderService.searchOrder Called--->");
		List<Order> listOrder = orderDAO.getOrderByOrderNumber(orderNumber);
		LOGGER.info("searchOrder yielded" + listOrder.size());
		if(listOrder != null){
			return listOrder;
		}
		else{
			return null;
		}
	}
}
