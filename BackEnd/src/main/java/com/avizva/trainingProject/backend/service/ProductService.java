package com.avizva.trainingProject.backend.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.avizva.trainingProject.backend.model.Product;


public interface ProductService {
	public boolean addProductService(Product product, MultipartFile file);
	public List<Product> searchProduct(String name);

	public boolean updateProduct(Product product, MultipartFile file);
	public boolean deleteProduct(int id);
	public List<Product> getAllProduct();
	public List<Product> getProductByCategory(String productCatName);

}
