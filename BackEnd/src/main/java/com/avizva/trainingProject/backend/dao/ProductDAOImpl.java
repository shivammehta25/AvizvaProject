package com.avizva.trainingProject.backend.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.avizva.trainingProject.backend.model.Category;
import com.avizva.trainingProject.backend.model.Product;

/**
 * 
 * @author Akshay.Chourasia
 * 
 * @repository
 * @transactional
 * <p>
 * This is the CartDAOImpl class in
 * which there are unimplemented methods
 * which contains the business logic of
 * add product to cart, removeProductFromCart,updateCartQuantity,
 * priceCalculator,getAllCartByUser,getCartByProductId,getAllCart.
 * 
 */

@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger LOGGER = Logger.getLogger(ProductDAOImpl.class);
	
	
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	/**
	 * @param product.
	 * @return its return type is boolean.
	 * <p>
	 * This method is used to add product in cart
	 * in which we have performed the operation 
	 * of saving product in Database. 
	 */
	public boolean addProduct(Product product) {
		System.out.println("DAO"+product);

		boolean flag=false;
		try{
		Session session=getSession();
		product.setEnabled(true);
		session.save(product);
		flag=true;
		LOGGER.info("<-- product added " + product.getProductName() + "--> ");
		}
		catch(Exception e){
			LOGGER.error("<-- Error Adding Product -->");
		}
		return flag;
		
	}

	/**
	 * @param ProductId.
	 * @return its return type is boolean.
	 * <p>
	 * This method is used to get the productId from cart
	 * which is further returned. 
	 */
	public Product getProductById(int productId) {
		try{
		Session session=getSession();
		Product product=session.get(Product.class,productId);
		LOGGER.info("<-- Fetched Product Object");
		
		return product;
		
		
		}catch (Exception e) {
			LOGGER.error("<-- Couldnt not fetch Products Object from ID");
		}
		return null;
	}
	
	/**
	 * @param product.
	 * @return its return type is boolean.
	 * <p>
	 * This method is used to update product in cart
	 * in which we have performed the operation 
	 * of updating product in Database. 
	 */
	public boolean updateProduct(Product product) {
		boolean flag=false;
		Session session=getSession();
		try{
		product.setEnabled(true);
		session.update(product);
		flag=true;
		LOGGER.info("<-- Product Updated " + product.getProductName()+ " -->");
		}catch (Exception e) {
			LOGGER.error("<-- Error Updating Product  -->");
			
		}
		
		return flag;
	}
	
	/**
	 * @param product.
	 * @return its return type is boolean.
	 * <p>
	 * This method is used to remove product in cart
	 * in which we have performed the operation 
	 * of saving product in Database. 
	 */
	public boolean removeProduct(Product product) {
		try{
		boolean flag=false;
		Session session=getSession();
		product.setEnabled(false);
		session.update(product);
		flag=true;
		LOGGER.info("<-- Product Removed " + product.getProductName()  +"  -->");
		}catch (Exception e) {
			LOGGER.error("<-- Error Removing Product  -->");
		}

		return false;
	}
	
	
	/**
	 *  
	 * @return its return type is boolean.
	 * <p>
	 * This method is used to add product in cart
	 * in which we have performed the operation 
	 * of saving product in Database. 
	 */
	public List<Product> getAllProduct() {
		List<Product> listProduct=null;
		try {
			Session session=getSession();
			Query q=session.createQuery("from Product where enabled=1");
			listProduct=q.list();
			LOGGER.info("<-- Fetched all the Products -->");
		}catch(Exception e){
			LOGGER.error("<-- Couldn't Not Fetch All Products");
		}
		
		return listProduct;
		
		
	}
	
	/**
	 * @param name.
	 * @return its return type is List of type Product.
	 * <p>
	 * This method is used to search product 
	 * in which we have performed the operation 
	 * of searching the product in Database and further retrived and returned . 
	 */
	public List<Product> searchProduct(String name) {
		Session session  = getSession();
		try{
		Query q = session.createQuery("from Product where productName like :name");
		q.setParameter("name", name+"%");
		List<Product> listProduct = q.list();
		LOGGER.info(listProduct + "!!!!!!!List here");
		return listProduct;
		
		}catch (Exception e) {
			LOGGER.error("<-- Could Not Search Anything -->");
		}
		return null;
		
	}

	/**
	 * @param productCatName.
	 * @return its return type is List of type Product.
	 * <p>
	 * This method is used to add product in cart
	 * in which we have performed the operation 
	 * of saving product in Database. 
	 */
	public List<Product> getProductByCategory(String productCatName) {
		Session session = getSession();
		try {
			Query q = session.createQuery("from Product where productCatName =:productCatName");
			q.setParameter("productCatName", productCatName);
			@SuppressWarnings("unchecked")
			List<Product> listProduct = q.list();
			LOGGER.info("Listed Product " +  listProduct);
			return listProduct;
		}catch(Exception e){
			LOGGER.error("<-- Could Not Fetch the Category-->");
		}
		return null;
	}

}
