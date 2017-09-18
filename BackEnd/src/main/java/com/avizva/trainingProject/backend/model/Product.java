package com.avizva.trainingProject.backend.model;

import javax.mail.Multipart;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.GeneratorType;
import org.springframework.stereotype.Component;

import com.sun.mail.handlers.multipart_mixed;

@Entity
@Component
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productId;
	
	@NotEmpty
	private String productName;
	
	@NotEmpty
	private String productBrand;
	
	
	@NotNull
	private Long productPrice;
	
	@NotEmpty
	private String productDesc;
	
	@NotNull
	private int productQuantity;
	
	@NotEmpty
	private String productCatName;
	
	@NotEmpty
	private String productSuppName;
	
	@Column(columnDefinition="BOOLEAN Default false")
	private boolean enabled;
	
	
	private Multipart productImage;


	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getProductBrand() {
		return productBrand;
	}


	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}


	public Long getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(Long productPrice) {
		this.productPrice = productPrice;
	}


	public String getProductDesc() {
		return productDesc;
	}


	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}


	public int getProductQuantity() {
		return productQuantity;
	}


	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}


	public String getProductCatName() {
		return productCatName;
	}


	public void setProductCatName(String productCatName) {
		this.productCatName = productCatName;
	}


	public String getProductSuppName() {
		return productSuppName;
	}


	public void setProductSuppName(String productSuppName) {
		this.productSuppName = productSuppName;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public Multipart getProductImage() {
		return productImage;
	}


	public void setProductImage(Multipart productImage) {
		this.productImage = productImage;
	}
	
	

	
	
	
}
