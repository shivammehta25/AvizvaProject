package com.avizva.trainingProject.backend.dao;

import java.util.List;

import com.avizva.trainingProject.backend.model.Product;
import com.avizva.trainingProject.backend.model.Supplier;

public interface ProductDAO {
	public boolean addProduct(Product product);
	public Product getProductById(int id);
	public boolean updateProduct(Product product);
	public boolean removeProduct(Product product);
	public List<Product> getAllProduct();
	public List<Product> searchProduct(String name);
	

}
















