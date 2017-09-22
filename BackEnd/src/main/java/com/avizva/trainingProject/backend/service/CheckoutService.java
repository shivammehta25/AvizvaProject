package com.avizva.trainingProject.backend.service;

import java.util.Date;
/**
 * This is the Service interface of checkout service used to checkout item and add them to orders
 * @author Shivam.Mehta
 *
 */
public interface CheckoutService {
	public boolean addUserProduct(String orderNumber,String username ,String shippingAddress ,String shippingCountry ,String shippingCity ,int shippingPin , String orderPaymentDetails, Date orderDate);

	
}
