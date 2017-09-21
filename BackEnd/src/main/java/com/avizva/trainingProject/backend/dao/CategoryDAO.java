package com.avizva.trainingProject.backend.dao;

import java.util.List;

import org.hibernate.Session;

import com.avizva.trainingProject.backend.model.Category;

/**
 * 
 * @author Saurabh Miglani
 * 
 *This Interface is been used to manipulate the data in DataBase
 *and this DAO interface contains method which is further implemented in
 *CategoryDAOImpl class.
 * 
 */
public interface CategoryDAO {
	
	
	/**
	 * @return session 
 	 */
	public Session getSession();
	
	/**
	 * 
	 * @param id
	 * @return category
	 */
	public Category getCategoryById(int id);
	
	/**
	 * 
	 * @return List of type category.
	 */
	public List<Category> getAllCategory();
	
	
	/**
	 * 
	 * @param category
	 * @return boolean
	 */
	public boolean createCategory(Category category);
	
	
	/**
	 * 
	 * @param category
	 * @return boolean
	 */
	public boolean updateCategory(Category category);
	
	
	/**
	 * 
	 * @param category
	 * @return boolean
	 */
	public boolean deactivateCategory(Category category);
	
	/**
	 * 
	 * @param name
	 * @return List of type Category.
	 */
	public List<Category> searchCategory(String name);
	
}
