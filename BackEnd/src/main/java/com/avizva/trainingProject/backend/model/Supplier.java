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
	private int supplierid;
	
	@NotNull
	private String supplieraddress;
	
	@NotNull
	private Long suppliercontact;

	public int getSupplierid() {
		return supplierid;
	}

	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}

	public String getSupplieraddress() {
		return supplieraddress;
	}

	public void setSupplieraddress(String supplieraddress) {
		this.supplieraddress = supplieraddress;
	}

	public Long getSuppliercontact() {
		return suppliercontact;
	}

	public void setSuppliercontact(Long suppliercontact) {
		this.suppliercontact = suppliercontact;
	}
	
	
	
	
	
	
	

}
