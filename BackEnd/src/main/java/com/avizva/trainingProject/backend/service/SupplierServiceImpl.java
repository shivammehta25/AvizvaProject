package com.avizva.trainingProject.backend.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.avizva.trainingProject.backend.dao.SupplierDAO;
import com.avizva.trainingProject.backend.model.Supplier;

@Transactional
@Service
public class SupplierServiceImpl implements SupplierService {
	private static final Logger LOGGER = Logger.getLogger(SupplierServiceImpl.class);

	@Autowired
	SupplierDAO supplierDAO;
	/**
	 * This methods add the suppliers
	 */
	public boolean addSupplierService(Supplier supplier){
		LOGGER.info("<-- SupplierService.addSupplierService Called--->");
		boolean flag = false;
		if(supplierDAO.createSupplier(supplier)){
			LOGGER.info("<-- Supplier Added Successfully-->");
			flag = true;
			
		}else {
			LOGGER.error("<-- Could Not Save the Supplier -->");
		}
		return flag;
	}
	
	/**
	 * This methods Searchs the suppliers
	 */
	
	public List<Supplier> searchSupplier(String name){
		LOGGER.info("<-- SupplierService.searchSupplier Called--->");
		List<Supplier> listSupplier = supplierDAO.searchSupplier(name);
		LOGGER.info("searchSupplier yielded" + listSupplier.size());
		if(listSupplier != null){
			return listSupplier;
		}
		else{
			return null;
		}
	}
	
	/**
	 * This methods update the suppliers
	 */
	
	public boolean updateSupplier(Supplier supplier){
		LOGGER.info("<-- SupplierService.updateSupplier Called--->");
		boolean flag = false;
		if(supplierDAO.updateSupplier(supplier)){
			LOGGER.info("<-- Supplier Updated Successfully-->");
			flag = true;
			return flag;
		}
		else{
			LOGGER.error("<-- Could Not Updated the Supplier -->");
			return flag;
		}
	}
	/**
	 * This methods delete the suppliers
	 */
	
	public boolean deleteSupplier(int id){
		LOGGER.info("<-- SupplierService.deleteSupplier Called--->");
		boolean flag = false;
		Supplier supplier = supplierDAO.getSupplierById(id);
		LOGGER.info("<-- Supplied Id to be deleted "  + supplier.getSupplierId());
		if(supplier != null){
			LOGGER.info("<-- Supplier Deleted Successfully-->");
			flag = true;
			supplierDAO.deactivateSupplier(supplier);
			return flag;
			
		}
		LOGGER.error("<-- Could Not Delete the Supplier -->");
		return flag;

		
	}

	/**
	 * This methods gets all the suppliers
	 */
	public List<Supplier> getAllSupplier() {
		LOGGER.info("<-- SupplierService.getAllSupplier Called--->");
		List<Supplier> listSupplier = supplierDAO.getAllSupplier();
		LOGGER.info("getAllSupplier yielded" + listSupplier.size() );
		if(listSupplier != null){
			return listSupplier;
		}
		return null;
	}
	
	

}
