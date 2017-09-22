package com.avizva.trainingProject.backend.service;

import java.util.List;

import com.avizva.trainingProject.backend.model.Category;

/**
 * These methods are used to access Catergory Data Access Object
 * @author Shivam.Mehta
 *
 */

public interface CategoryService {
	
	public boolean addCategoryService(Category category);
	
	public List<Category> searchCategory(String name);
	
	public boolean updateCategory(Category category);
	
	public boolean deleteCategory(int id);
	
	public List<Category> getAllCategory();
}
