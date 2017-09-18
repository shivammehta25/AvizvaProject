package com.avizva.trainingProject.backend.service;

import java.util.List;

import com.avizva.trainingProject.backend.model.Product;


public interface ProductService {
	public boolean addProductService(Product product);
	public List<Product> searchProduct(String name);

	public boolean updateProduct(Product product );
	public boolean deleteProduct(int id);
	public List<Product> getAllProduct();
	public List<Product> getProductByCategory(String productCatName);

}
