package com.avizva.trainingProject.backend.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.avizva.trainingProject.backend.dao.ProductDAO;
import com.avizva.trainingProject.backend.model.Product;
import com.avizva.trainingProject.backend.model.Supplier;

/**
 * This is the implementation of the Product Service which uses the ProductDAO to access and save Products
 * @author Shivam.Mehta
 *
 */
@Transactional
@Service
public class ProductServiceImpl implements ProductService {
	private static final Logger LOGGER = Logger.getLogger(ProductServiceImpl.class);
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	private FileUploadService fileUploadService;
	/**
	 *  This method adds product 
	 */
	public boolean addProductService(Product product, MultipartFile file) {
		LOGGER.info("<-- ProductService.addProductService Called--->");
		boolean flag=false;
		fileUploadService.uploadProductImage(product,file);
		if(productDAO.addProduct(product)){
			LOGGER.info("<-- Product Added Successfully-->");
			flag = true;
		}else{
			LOGGER.error("<-- Could Not Save the Product -->");
		}
		return flag;
	}

	/**
	 * This method searches for the product
	 */
	@SuppressWarnings("unused")
	public List<Product> searchProduct(String name) {
		LOGGER.info("<-- ProductService.searchProduct Called--->");
		List<Product> listProduct = productDAO.searchProduct(name);
		LOGGER.debug("searchProduct yielded" + listProduct.size());
		if(listProduct!=null)
		{
			return listProduct;
		}else{
			return null;
			
		}
		
	}
	/**
	 *	This method updates the product
	 */
	public boolean updateProduct(Product product, MultipartFile file) {
		LOGGER.info("<-- ProductService.updateProduct Called--->");
		boolean flag=false;
		fileUploadService.uploadProductImage(product,file);
		if(productDAO.updateProduct(product)){
			LOGGER.info("<-- Product Updated Successfully-->");
			flag = true;
			return flag;
		}else{
			LOGGER.error("<-- Could Not Update the Product -->");
			return flag;
		}
		
		
	}
	/**
	 * This method deletes the product
	 */
	@SuppressWarnings("unused")
	public boolean deleteProduct(int id) {
		LOGGER.info("<-- ProductService.deleteProduct Called--->");
		boolean flag=false;
		Product product=productDAO.getProductById(id);
		LOGGER.info("<-- Product id to be delteted "  + product.getProductId());
		if(product != null){
			LOGGER.info("<-- Product Deleted Successfully-->");
			flag = true;
			productDAO.removeProduct(product);
			return flag;
		}
		LOGGER.error("<-- Could Not Delete the Product -->");
		return flag;
	}
	/**
	 *  This method lists all the product 
	 */
	public List<Product> getAllProduct() {
		LOGGER.info("<-- ProductService.getAllProduct Called--->");
		List<Product> listProduct=productDAO.getAllProduct();
		LOGGER.info("getAllProduct yielded" + listProduct.size() );
		if(listProduct != null){
			return listProduct;
		}
		return null;
	}
	/**
	 * 	This methods gets the product by category sent using the get parameter
	 * 
	 */

	public List<Product> getProductByCategory(String productCatName) {
		LOGGER.info("<-- ProductService.getProductByCategory Called--->");
		List<Product> listProduct = productDAO.getProductByCategory(productCatName);
		LOGGER.info("<-- Products Fetched by Category"  + productCatName);
		if(listProduct !=null){
			return listProduct;
		}
		return null;
	}
	
	/**
	 * 	This methods is used to get products by ID
	 * 
	 */
	
	public Product getProductById(int productId) {

		LOGGER.info("<-- ProductService.getProductById Called--->");
		Product product = productDAO.getProductById(productId);
		LOGGER.info("<-- Product Fetched by Id"  + productId);

		if(product !=null){
			return product;
		}
		return null;
	}

	
	

}
