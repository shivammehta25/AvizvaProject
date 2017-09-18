package com.avizva.trainingProject.backend.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avizva.trainingProject.backend.dao.ProductDAO;
import com.avizva.trainingProject.backend.model.Product;
import com.avizva.trainingProject.backend.model.Supplier;

@Service
public class ProductServiceImpl implements ProductService {
	private static final Logger LOGGER = Logger.getLogger(ProductServiceImpl.class);
	
	@Autowired
	ProductDAO productDAO;

	public boolean addProductService(Product product) {
		System.out.println("Service"+product);

		boolean flag=false;
		if(productDAO.addProduct(product)){
			LOGGER.info("<-- Product Added Successfully-->");
			flag = true;
		}else{
			LOGGER.error("<-- Could Not Save the Product -->");
		}
		return flag;
	}

	@SuppressWarnings("unused")
	public List<Product> searchProduct(String name) {
		List<Product> listProduct = productDAO.searchProduct(name);
		LOGGER.debug("Product Search yielded" + listProduct.size());
		if(listProduct!=null)
		{
			return listProduct;
		}else{
			return null;
			
		}
		
	}

	public boolean updateProduct(Product product) {
		boolean flag=false;
		if(productDAO.updateProduct(product)){
			flag = true;
			return flag;
		}else{
			return flag;
		}
		
		
	}

	@SuppressWarnings("unused")
	public boolean deleteProduct(int id) {
		boolean flag=false;
		Product product=productDAO.getProductById(id);
		LOGGER.info("<-- Product id to be delteted "  + product.getProductId());
		if(product != null){
			flag = true;
			productDAO.removeProduct(product);
			return flag;
	}
		return flag;
	}

	public List<Product> getAllProduct() {
		List<Product> listProduct=productDAO.getAllProduct();
		LOGGER.info("INside Service of product" + listProduct );
		if(listProduct != null){
			return listProduct;
		}
		return null;
	}

	public List<Product> getProductByCategory(String productCatName) {
		List<Product> listProduct = productDAO.getProductByCategory(productCatName);
		LOGGER.info("<-- Product Fetched by category"  + productCatName);
		if(listProduct !=null){
			return listProduct;
		}
		return null;
	}

	
	

}
