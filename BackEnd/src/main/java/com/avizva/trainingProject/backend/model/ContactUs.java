package com.avizva.trainingProject.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

import com.sun.istack.internal.NotNull;
/**
 * 
 * @author Akshay.Chourasia
 * This is used to generate contactus requests.
 * @entity annotation used to map the class instances with the entities of Database. 
 */
@Entity
@Component
public class ContactUs {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotEmpty
	private String name;
	@NotEmpty
	@Email
	private String email;
	@NotNull
	private Long contact;
	@NotEmpty
	private String description;
	
	private String message;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
