package com.avizva.trainingProject.backend.dao.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.avizva.trainingProject.backend.dao.SupplierDAO;
import com.avizva.trainingProject.backend.model.Supplier;
import com.avizva.trainingProject.backend.test.config.TestApplicationContextConfig;

@ContextConfiguration(classes=TestApplicationContextConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SupplierDAOTest {
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	
	
	@Test
	public void testCreateSupplier(){
		
		Supplier supplier=new Supplier();
		supplier.setSupplierName("TestCreateSupplier");
		supplier.setSupplierAddress("Test");
		supplier.setSupplierContact(0L);
		
		assertTrue(supplierDAO.createSupplier(supplier));
	}
	
//	@Test
//	public void testUpdateSupplier(){
//		
//		Supplier supplier=new Supplier();
//		supplier.setSupplierId(1);
//		supplier.setSupplierName("TestCreateSupplier");
//		supplier.setSupplierAddress("TestUpdate");
//		supplier.setSupplierContact(0L);
//		
//		assertTrue(supplierDAO.updateSupplier(supplier));
//	}
	
//	@Test
//	public void testDeactivateSupplier(){
//		
//		Supplier supplier=new Supplier();
//		supplier.setSupplierId(1);
//		supplier.setSupplierName("TestCreateSupplier");
//		supplier.setSupplierAddress("Test");
//		supplier.setSupplierContact(0L);
//		
//		assertTrue(supplierDAO.deactivateSupplier(supplier));
//	}
	
	@Test
	public void testGetSupplierById(){
		
		
		Supplier supplier=supplierDAO.getSupplierById(1);
		assertTrue(supplier.getSupplierId()==1);
		
	}
}
