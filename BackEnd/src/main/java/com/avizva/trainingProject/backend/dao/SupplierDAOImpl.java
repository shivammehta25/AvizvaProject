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

@Repository
@Transactional
public class SupplierDAOImpl implements SupplierDAO {
	
	private static final Logger LOGGER = Logger.getLogger(SupplierDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public boolean createSupplier(Supplier supplier) {
		
		boolean flag=false;
		try{
		Session session=getSession();
		session.save(supplier);
		flag=true;
		LOGGER.info("<-- Supplier added " + supplier.getSupplierName() + "--> ");
		}
		catch(Exception e){
			LOGGER.error("<-- Error Adding Supplier -->");
		}
		return flag;
		
}

	

	public boolean updateSupplier(Supplier supplier) {
		
		boolean flag=false;
		Session session=getSession();
		try{
		session.update(supplier);
		flag=true;
			LOGGER.info("<-- Supplier Updated " + supplier.getSupplierName() + " -->");
		}catch(Exception e){
			LOGGER.error("<-- Error Updating Supplier ");
		}
		return flag;
	}

	public boolean deactivateSupplier(Supplier supplier) {
		boolean flag=false;
		try{
			Session session=getSession();
			supplier.setEnabled(false);
			session.delete(supplier);
			flag=true;
			LOGGER.info("<-- Supplier Deactivated " + supplier.getSupplierName()  +"  -->");
		}catch (Exception e) {
			LOGGER.error("<-- Error Deactivating Suppplier  -->");
		}
		return flag;
	}

	
	public List<Supplier> getallSupplier() {
		List<Supplier> listSupplier = null;
		try{
		Session session = getSession();
		Query q = session.createQuery("from Supplier");
		listSupplier = q.list();
		LOGGER.info("<-- Fetched all the Queries -->");
		}catch(Exception e){
			LOGGER.error("<-- Couldn't Not Fetch All Suppliers");
		}
		
		return listSupplier;
	}

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
	

}
