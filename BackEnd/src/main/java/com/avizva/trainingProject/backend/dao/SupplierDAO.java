package com.avizva.trainingProject.backend.dao;

import java.util.List;

import com.avizva.trainingProject.backend.model.Supplier;

public interface SupplierDAO {
	
	public boolean createSupplier(Supplier supplier);
	public Supplier getSupplierById(int id);
	public boolean updateSupplier(Supplier supplier);
	public boolean deactivateSupplier(Supplier supplier);
	public List<Supplier> getallSupplier();
 }
