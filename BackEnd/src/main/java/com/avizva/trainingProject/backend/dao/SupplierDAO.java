package com.avizva.trainingProject.backend.dao;

import java.util.List;


import com.avizva.trainingProject.backend.model.Supplier;

/**
 * 
 * @author Akshay.Chourasia
 * <p>
 *	This Interface is been used to manipulate the data in DataBase
 *	and this SupplierDao interface contains method which is further implemented in
 *	SupplierDAOImpl class.
 */
public interface SupplierDAO {
	
	/**
	 * 
	 * @param supplier
	 * @return
	 */
	public boolean createSupplier(Supplier supplier);
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Supplier getSupplierById(int id);
	
	/**
	 * 
	 * @param supplier
	 * @return
	 */
	public boolean updateSupplier(Supplier supplier);
	
	/**
	 * 
	 * @param supplier
	 * @return
	 */
	public boolean deactivateSupplier(Supplier supplier);
	/**
	 * 
	 * @return
	 */
	public List<Supplier> getAllSupplier();
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public List<Supplier> searchSupplier(String name);
 }
