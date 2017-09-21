package com.avizva.trainingProject.backend.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avizva.trainingProject.backend.dao.OrderDAO;
import com.avizva.trainingProject.backend.model.Order;

@Service
public class CheckoutServiceImpl implements CheckoutService {

	@Autowired
	OrderDAO orderDAO;

	public boolean addUserProduct(String orderNumber, String username, String shippingAddress, String shippingCountry,
			String shippingCity, int shippingPin, String orderPaymentDetails, Date orderDate) {

		String[] orders = orderNumber.split("-");
		System.out.println(orders);
		int orderQuantity;
		int productId;
		for (int i = 1; i < orders.length; i++) {
			orderQuantity = Integer.parseInt(orders[i].split(",")[1]);
			productId = Integer.parseInt(orders[i].split(",")[0]);
			Order order = new Order();
			order.setProductId(productId);
			order.setOrderDate(orderDate);
			order.setOrderNumber(orderNumber);
			order.setUsername(username);
			order.setShippingAddress(shippingAddress);
			order.setShippingCountry(shippingCountry);
			order.setShippingCity(shippingCity);
			order.setShippingPin(shippingPin);
			order.setOrderPaymentDetails(orderPaymentDetails);
			order.setOrderQuantity(orderQuantity);
			order.setOrderStatus("Placed");
			if(!(orderDAO.addOrder(order))){
				return false;
			}
			
		}
		return true;
	}

}
