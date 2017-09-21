package com.avizva.trainingProject.backend.dao.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.avizva.trainingProject.backend.dao.ProductDAO;
import com.avizva.trainingProject.backend.model.Product;
import com.avizva.trainingProject.backend.test.config.TestApplicationContextConfig;

@ContextConfiguration(classes=TestApplicationContextConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductDAOTest {

	@Autowired
	private ProductDAO productDAO;
	
	@Test
	public void testAddProduct(){
		
		Product product=new Product();
		product.setProductName("Test");
		product.setProductBrand("Test");
		product.setProductPrice(1L);
		product.setProductDesc("Test");
		product.setProductQuantity(1);
		product.setProductCatName("Test");
		product.setProductSuppName("Test");

		assertTrue(productDAO.addProduct(product));
	}
	
	@Test
	public void testGetProductById(){
		Product product=productDAO.getProductById(1);
		assertTrue(product.getProductId()==1);
	}
	
//	@Test
//	public void testUpdateProduct(){
//		
//		Product product=new Product();
//		product.setProductName("Test");
//		product.setProductBrand("Test");
//		product.setProductPrice(1L);
//		product.setProductDesc("Test");
//		product.setProductQuantity(1);
//		product.setProductCatName("Test");
//		product.setProductSuppName("Test");
//		
//		assertTrue(productDAO.updateProduct(product));
//	}
	
//	@Test
//	public void testRemoveProduct(){
//		
//		Product product=new Product();
//		product.setProductId(1);
//		product.setProductName("Test");
//		product.setProductBrand("Test");
//		product.setProductPrice(1L);
//		product.setProductDesc("Test");
//		product.setProductQuantity(1);
//		product.setProductCatName("Test");
//		product.setProductSuppName("Test");
//		
//		assertTrue(productDAO.removeProduct(product));
//	}
	
	
}
