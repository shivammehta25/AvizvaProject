package com.avizva.trainingProject.backend.dao;

import java.util.List;

import org.hibernate.Session;

import com.avizva.trainingProject.backend.model.Category;

/**
 * 
 * @author Saurabh Miglani
 *This Interface is been used to manipulate the data in DataBase
 *and this DAO interface contains method which is further implemented in
 *CategoryDAOImpl class.
 * 
 */
public interface CategoryDAO {
	
	public Session getSession();
	
	public Category getCategoryById(int id);
	
	public List<Category> getAllCategory();
	
	public boolean createCategory(Category category);
	
	public boolean updateCategory(Category category);
	
	public boolean deactivateCategory(Category category);
	
}
