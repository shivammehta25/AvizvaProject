package com.avizva.trainingProject.backend.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.avizva.trainingProject.backend.model.Supplier;



/**
 * 
 * @author Akshay Chourasia
 * @repository is been used as such beans are eligible for persistence exception translation.
 * @Transactional is been used such that if any of the four methods failed to execute
 * then the whole process will get rollback.
 * 
 *
 */

@Repository
@Transactional
public class SupplierDAOImpl implements SupplierDAO {
	
	private static final Logger LOGGER = Logger.getLogger(SupplierDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * @param Supplier.
	 * @return its return type is boolean.
	 * <p>
	 * This method is used to Create supplier 
	 * in which we have performed the operation 
	 * of saving the supplier object in Database and further returned flag. 
	 */
	public boolean createSupplier(Supplier supplier) {
		
		boolean flag=false;
		try{
		Session session=getSession();
		supplier.setEnabled(true);
		session.save(supplier);
		flag=true;
		LOGGER.info("<-- Supplier added " + supplier.getSupplierName() + "--> ");
		}
		catch(Exception e){
			LOGGER.error("<-- Error Adding Supplier -->");
		}
		return flag;
		
	}

	
	/**
	 * @param supplier.
	 * @return its return type is boolean.
	 * <p>
	 * This method is used to update supplier 
	 * in which we have performed the operation 
	 * of updating the supplier in Database and returned the flag . 
	 */
	public boolean updateSupplier(Supplier supplier) {
		
		boolean flag=false;
		Session session=getSession();
		try{
		supplier.setEnabled(true);
		session.update(supplier);
		flag=true;
		LOGGER.info("<-- Supplier Updated " + supplier.getSupplierName() + " -->");
		}catch(Exception e){
			LOGGER.error("<-- Error Updating Supplier ");
		}
		return flag;
	}
	
	/**
	 * @param supplier.
	 * @return its return type is List of type Product.
	 * <p>
	 * This method is used to remove supplier 
	 * in which we have performed the operation 
	 * of setting enable false and further update the supplier in Database and returned the flag . 
	 */
	public boolean deactivateSupplier(Supplier supplier) {
		boolean flag=false;
		try{
			Session session=getSession();
			supplier.setEnabled(false);
			session.update(supplier);
			flag=true;
			LOGGER.info("<-- Supplier Deactivated " + supplier.getSupplierName()  +"  -->");
		}catch (Exception e) {
			LOGGER.error("<-- Error Deactivating Suppplier  -->");
		}
		return flag;
	}

	/**
	 * @return its return type is List of type Supplier.
	 * <p>
	 * This method is used to get all supplier 
	 * in which we have performed the operation 
	 * of getting all the supplier from Database and returned List of supplier . 
	 */
	public List<Supplier> getAllSupplier() {
		List<Supplier> listSupplier = null;
		try{
		Session session = getSession();
		Query q = session.createQuery("from Supplier where enabled = 1");
		listSupplier = q.list();
		LOGGER.info("<-- Fetched all the Queries -->");
		}catch(Exception e){
			LOGGER.error("<-- Couldn't Not Fetch All Suppliers");
		}
		
		return listSupplier;
	}
	
	/**
	 * @param id.
	 * @return its return type is supplier.
	 * <p>
	 * This method is used to get the supplier by id 
	 * in which we have performed the operation 
	 * of getting supplier id from Database  and returned supplier object . 
	 */
	public Supplier getSupplierById(int id) {
		Session session = getSession();
		try{
		Supplier supplier = session.get(Supplier.class , id);
		LOGGER.info("<-- Fetched Supplier's Object");
		return supplier;
		}catch(Exception e){
			LOGGER.error("<-- Couldnt not fetch Supplier's Object from ID");
		}
		return null;
	}
	
	
	
	/**
	 * @param name.
	 * @return its return type is List of type supplier.
	 * <p>
	 * This method is used to search supplier 
	 * in which we have performed the operation 
	 * of searching the supplier in Database and further retrived and returned list of supplier . 
	 */
	public List<Supplier> searchSupplier(String name) {
		
		Session session  = getSession();
		try {
			Query q = session.createQuery("from Supplier where supplierName like :supplierName");
			q.setParameter("supplierName", name+"%");
			List<Supplier> listSupplier = q.list();
			LOGGER.info(listSupplier + "!!!!!!!List here");
			return listSupplier;
		}catch(Exception e){
			LOGGER.error("<-- Could Not Search Anything -->");
		}
		
		return null;
	}
	

}
