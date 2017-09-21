package com.avizva.trainingProject.backend.service;

import java.util.Date;

public interface CheckoutService {
	public boolean addUserProduct(String orderNumber,String username ,String shippingAddress ,String shippingCountry ,String shippingCity ,int shippingPin , String orderPaymentDetails, Date orderDate);

	
}
