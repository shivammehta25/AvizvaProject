package com.avizva.trainingProject.backend.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avizva.trainingProject.backend.dao.CategoryDAO;
import com.avizva.trainingProject.backend.dao.SupplierDAO;
import com.avizva.trainingProject.backend.model.Category;
import com.avizva.trainingProject.backend.model.Supplier;

@Service
public class CategoryServiceImpl implements CategoryService{
	private static final Logger LOGGER = Logger.getLogger(CategoryServiceImpl.class);

	@Autowired
	CategoryDAO categoryDAO;
	
	public boolean addCategoryService(Category category){
		boolean flag = false;
		if(categoryDAO.createCategory(category)){
			LOGGER.info("<-- Category Added Successfully-->");
			flag = true;
			
		}else {
			LOGGER.error("<-- Could Not Save the Category -->");
		}
		return flag;
	}
	
	
	
	public List<Category> searchCategory(String name){
		List<Category> listCategory= categoryDAO.searchCategory(name);
		LOGGER.debug("Category Search yielded" + listCategory.size());
		if(listCategory != null){
			return listCategory;
		}
			return null;
	}
	
	public boolean updateCategory(Category category){
		boolean flag = false;
		if(categoryDAO.updateCategory(category)){
			flag = true;
			return flag;
		}
		else{
			return flag;
		}
	}
	
	public boolean deleteCategory(int id){
		boolean flag = false;
		Category category = categoryDAO.getCategoryById(id);
		LOGGER.info("<-- Category id to be delteted "  + category.getCategoryId());
		if(category != null){
			flag = true;
			categoryDAO.deactivateCategory(category);
			return flag;
			
		}
			return flag;

		
	}



	public List<Category> getAllCategory() {
		List<Category> listCategory = categoryDAO.getAllCategory();
		LOGGER.info("Inside Service of Category" + listCategory );
		if(listCategory != null){
			return listCategory;
		}
		return null;
	}
	
	
}
