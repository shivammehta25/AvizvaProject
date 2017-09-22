package com.avizva.trainingProject.backend.service;

import java.util.List;

import com.avizva.trainingProject.backend.model.Supplier;

/**
 * This interface uses the CRUD operations of Suppliers	 
 * @author Shivam.Mehta
 *
 */
public interface SupplierService {
	public boolean addSupplierService(Supplier supplier);
	public List<Supplier> searchSupplier(String name);
	public boolean updateSupplier(Supplier supplier);
	public boolean deleteSupplier(int id);
	public List<Supplier> getAllSupplier();

}
