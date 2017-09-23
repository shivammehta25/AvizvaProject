package com.avizva.trainingProject.backend.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avizva.trainingProject.backend.dao.CategoryDAO;
import com.avizva.trainingProject.backend.dao.SupplierDAO;
import com.avizva.trainingProject.backend.model.Category;
import com.avizva.trainingProject.backend.model.Supplier;

/**
 * These Methods are used to do CRUD operations onto categories
 * @author Shivam.Mehta
 * @Transactional This makes the class transactional
 * @Service Used to make the class a Service
 */

@Transactional
@Service
public class CategoryServiceImpl implements CategoryService{
	private static final Logger LOGGER = Logger.getLogger(CategoryServiceImpl.class);

	/**
	 * The Category DAO is autowired
	 */
	@Autowired
	CategoryDAO categoryDAO;
	
	/**
	 * A new category is added 
	 */
	
	public boolean addCategoryService(Category category){
		LOGGER.info("<-- CategoryService.addCategoryService Called--->");
		boolean flag = false;
		if(categoryDAO.createCategory(category)){
			LOGGER.info("<-- Category Added Successfully-->");
			flag = true;
			
		}else {
			LOGGER.error("<-- Could Not Save the Category -->");
		}
		return flag;
	}
	
	/**
	 * List of all Categories matching the search string is returned
	 */
	
	public List<Category> searchCategory(String name){
		LOGGER.info("<-- CategoryService.searchCategory Called--->");
		List<Category> listCategory= categoryDAO.searchCategory(name);
		LOGGER.info("searchCategory yielded" + listCategory.size());
		if(listCategory != null){
			return listCategory;
		}
			return null;
	}
	
	/**
	 * The Category is updated 
	 * 
	 */
	
	public boolean updateCategory(Category category){
		LOGGER.info("<-- CategoryService.updateCategory Called--->");
		boolean flag = false;
		if(categoryDAO.updateCategory(category)){
			LOGGER.info("<-- Category Updated Successfully-->");
			flag = true;
			return flag;
		}
		else{
			LOGGER.error("<-- Could Not Update the Category -->");
			return flag;
		}
	}
	
	/** 
	 *  The Cateogry is deleted
	 */
	
	public boolean deleteCategory(int id){
		LOGGER.info("<-- CategoryService.deleteCategory Called--->");
		boolean flag = false;
		Category category = categoryDAO.getCategoryById(id);
		LOGGER.info("<-- Category id to be delteted "  + category.getCategoryId());
		if(category != null){
			LOGGER.info("<-- Category Deleted Successfully-->");
			flag = true;
			categoryDAO.deactivateCategory(category);
		}
			LOGGER.error("<-- Could Not Delete the Category -->");
		return flag;

		
	}

	/**
	 * Used to fetch all the categories present
	 */

	public List<Category> getAllCategory() {
		LOGGER.info("<-- CategoryService.getAllCategory Called--->");
		List<Category> listCategory = categoryDAO.getAllCategory();
		LOGGER.info("getAllCategory yielded" + listCategory.size());
		if(listCategory != null){
			return listCategory;
		}
		return null;
	}
	
	
}
