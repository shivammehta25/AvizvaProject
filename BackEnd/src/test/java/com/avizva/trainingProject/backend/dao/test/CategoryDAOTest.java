package com.avizva.trainingProject.backend.dao.test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.avizva.trainingProject.backend.dao.CategoryDAO;
import com.avizva.trainingProject.backend.model.Category;
import com.avizva.trainingProject.backend.model.Order;
import com.avizva.trainingProject.backend.test.config.TestApplicationContextConfig;

@ContextConfiguration(classes=TestApplicationContextConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryDAOTest {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Test
	public void testCreateCategory(){
		Category category=new Category();
		category.setCategoryName("Test");
		category.setCategoryDescription("Test");
	
		assertTrue(categoryDAO.createCategory(category));
	}
	
	@Test
	public void testGetCategoryById(){
		Category category=categoryDAO.getCategoryById(1);
		assertTrue(category.getCategoryId()==1);
	}
	
//	@Test
//	public void testUpdateCategory(){
//		
//		Category category=new Category();
//		category.setCategoryId(1);
//		category.setCategoryName("Test");
//		category.setCategoryDescription("Test");
//		
//		assertTrue(categoryDAO.updateCategory(category));
//	}
	
//	@Test
//	public void testDeactivateCategory(){
//		
//		Category category=new Category();
//		category.setCategoryId(1);
//		category.setCategoryName("Test");
//		category.setCategoryDescription("Test");
//		
//		assertTrue(categoryDAO.deactivateCategory(category));
//	}
	

}
