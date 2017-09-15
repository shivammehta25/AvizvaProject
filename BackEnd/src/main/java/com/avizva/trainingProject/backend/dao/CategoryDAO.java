package com.avizva.trainingProject.backend.dao;

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
	
	public Category getCategory();
}
