package com.avizva.trainingProject.backend.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avizva.trainingProject.backend.dao.SupplierDAO;
import com.avizva.trainingProject.backend.model.Supplier;


@Service
public class SupplierServiceImpl implements SupplierService {
	
	private static final Logger LOGGER = Logger.getLogger(SupplierServiceImpl.class);

	@Autowired
	SupplierDAO supplierDAO;
	
	public boolean addSupplierService(Supplier supplier){
		boolean flag = false;
		if(supplierDAO.createSupplier(supplier)){
			LOGGER.info("<-- Supplier Added Successfully-->");
			flag = true;
			
		}else {
			LOGGER.error("<-- Could Not Save the Supplier -->");
		}
		return flag;
	}
	
	
	
	public List<Supplier> searchSupplier(String name){
		List<Supplier> listSupplier = supplierDAO.searchSupplier(name);
		LOGGER.debug("Supplier Search yielded" + listSupplier.size());
		if(listSupplier != null){
			return listSupplier;
		}
		else{
			return null;
		}
	}
	
	public boolean updateSupplier(Supplier supplier){
		boolean flag = false;
		if(supplierDAO.updateSupplier(supplier)){
			flag = true;
			return flag;
		}
		else{
			return flag;
		}
	}
	
	public boolean deleteSupplier(int id){
		boolean flag = false;
		Supplier supplier = supplierDAO.getSupplierById(id);
		LOGGER.info("<-- Supplied id to be delteted "  + supplier.getSupplierId());
		if(supplier != null){
			flag = true;
			supplierDAO.deactivateSupplier(supplier);
			return flag;
			
		}
			return flag;

		
	}



	public List<Supplier> getAllSupplier() {
		List<Supplier> listSupplier = supplierDAO.getAllSupplier();
		LOGGER.info("INside Service of supplier" + listSupplier );
		if(listSupplier != null){
			return listSupplier;
		}
		return null;
	}
	
	

}
