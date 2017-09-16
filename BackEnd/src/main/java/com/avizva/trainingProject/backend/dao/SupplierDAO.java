package com.avizva.trainingProject.backend.dao;

import java.util.List;

import com.avizva.trainingProject.backend.model.Supplier;

public interface SupplierDAO {
	
	public boolean createSupplier(Supplier supplier);
	public List<Supplier> getSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public boolean deleteSupplier(Supplier supplier);
	public List<Supplier> getallSupplier(Supplier supplier);
	
 }
