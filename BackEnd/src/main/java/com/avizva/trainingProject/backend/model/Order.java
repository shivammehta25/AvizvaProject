package com.avizva.trainingProject.backend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import com.sun.istack.internal.NotNull;

@Entity(name="Orders")
@Component
@Table(name="Orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int orderId;
	
	@NotNull
	private String orderNumber;
	
//	@Column(columnDefinition="VARCHAR DEFAULT 'Placed'")
	private String orderStatus;
	
//	@CreationTimestamp
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date orderDate;
	
	@NotNull
	private int orderQuantity;
	
	@NotEmpty
	private String orderPaymentDetails;
	
	@NotEmpty
	private String username;
	
	@NotNull
	private int productId;
	
	private String shippingAddress;
	
	private String shippingCity;
	
	private String shippingCountry;
	
	private int shippingPin;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public String getOrderPaymentDetails() {
		return orderPaymentDetails;
	}

	public void setOrderPaymentDetails(String orderPaymentDetails) {
		this.orderPaymentDetails = orderPaymentDetails;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getShippingCity() {
		return shippingCity;
	}

	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}

	public String getShippingCountry() {
		return shippingCountry;
	}

	public void setShippingCountry(String shippingCountry) {
		this.shippingCountry = shippingCountry;
	}

	public int getShippingPin() {
		return shippingPin;
	}

	public void setShippingPin(int shippingPin) {
		this.shippingPin = shippingPin;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderNumber=" + orderNumber + ", orderStatus=" + orderStatus
				+ ", orderDate=" + orderDate + ", orderQuantity=" + orderQuantity + ", orderPaymentDetails="
				+ orderPaymentDetails + ", username=" + username + ", productId=" + productId + ", shippingAddress="
				+ shippingAddress + ", shippingCity=" + shippingCity + ", shippingCountry=" + shippingCountry
				+ ", shippingPin=" + shippingPin + "]";
	}
	
	
	
	
}
