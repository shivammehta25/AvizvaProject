package com.avizva.trainingProject.backend.dao;

import java.util.List;

import com.avizva.trainingProject.backend.model.Product;
import com.avizva.trainingProject.backend.model.Supplier;

/**
 * 
 * @author Akshay.Chourasia
 * <p>
 * This Interface is been used to manipulate the data in DataBase
 * and this CartDAO interface contains method addProduct,getProductById,
 * updateProduct,removeProduct,getAllProduct,searchProduct,
 * getProductByCategory which is further implemented in
 * ProductDAOImpl class
 *
 */

public interface ProductDAO {
	
	/**
	 * 
	 * @param product
	 * @return Its return type is boolean.
	 */
	public boolean addProduct(Product product);
	
	/**
	 * 
	 * @param id
	 * @return Its return type is boolean.
	 */
	public Product getProductById(int id);
	
	/**
	 * 
	 * @param product
	 * @return Its return type is boolean.
	 */
	public boolean updateProduct(Product product);
	
	/**
	 * 
	 * @param product
	 * @return Its return type is boolean.
	 */
	public boolean removeProduct(Product product);
	
	/**
	 * 
	 * @return Its return type is boolean.
	 */
	public List<Product> getAllProduct();
	
	/**
	 * 
	 * @param name
	 * @return Its return type is boolean.
	 */
	public List<Product> searchProduct(String name);
	
	/**
	 * 
	 * @param productCatName
	 * @return  Its return type is boolean. 
	 */
	public List<Product> getProductByCategory(String productCatName);

}
















