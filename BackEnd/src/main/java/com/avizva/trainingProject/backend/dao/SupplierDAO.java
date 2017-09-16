package com.avizva.trainingProject.backend.dao;

import java.util.List;

import com.avizva.trainingProject.backend.model.Supplier;

public interface SupplierDAO {
	
	public boolean createSupplier(Supplier supplier);
	public Supplier getSupplierById(int id);
	public boolean updateSupplier(Supplier supplier);
<<<<<<< HEAD
	public boolean deleteSupplier(Supplier supplier);
	public List<Supplier> getallSupplier(Supplier supplier);
	
=======
	public boolean deactivateSupplier(Supplier supplier);
	public List<Supplier> getallSupplier();
>>>>>>> 648fa0194027fe28dd99ee2869aa9e79fce2ff9d
 }
