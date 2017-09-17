package com.avizva.trainingProject.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Saurabh.Miglani	
 * This is to manage categories of products
 *
 */
@Entity
@Component
public class Category {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotEmpty
	private String categoryId;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String description;
	
	private boolean enabled;
	

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
	
}
