package com.avizva.trainingProject.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;


/**
 * 
 * @author Akshay Chourasia
 * @Entity
 */
@Entity
@Component
public class Supplier {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int supplierId;
	
	@NotNull
	private String supplierName;
	
	@NotNull
	private String supplierAddress;
	
	@NotNull
	private Long supplierContact;

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public Long getSupplierContact() {
		return supplierContact;
	}

	public void setSupplierContact(Long supplierContact) {
		this.supplierContact = supplierContact;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	
	
	
	

}
