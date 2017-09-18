package com.avizva.trainingProject.backend.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.avizva.trainingProject.backend.model.Category;
import com.avizva.trainingProject.backend.model.Product;


@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {
	
	private SessionFactory sessionFactory;
	private static final Logger LOGGER = Logger.getLogger(SupplierDAOImpl.class);
	
	
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	

	public boolean addProduct(Product product) {
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


	public Product getProductById(int productid) {
		try{
		Session session=getSession();
		Product product=session.get(Product.class,productid);
		LOGGER.info("<-- Fetched Product Object");
		
		return product;
		
		
		}catch (Exception e) {
			LOGGER.error("<-- Couldnt not fetch Products Object from ID");
		}
		return null;
	}

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

	public List<Product> getAllProduct() {
		List<Product> listProduct=null;
		try {
			Session session=getSession();
			Query q=session.createQuery("from Product where enabled=1");
			listProduct=q.list();
			LOGGER.info("<-- Fetched all the Categories -->");
		}catch(Exception e){
			LOGGER.error("<-- Couldn't Not Fetch All Categories");
		}
		
		return listProduct;
		
		
	}

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

}
