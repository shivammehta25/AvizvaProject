package com.avizva.trainingProject.frontEnd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.avizva.trainingProject.backend.model.Supplier;
import com.avizva.trainingProject.backend.service.SupplierService;

@Controller
public class SupplierController {

	private static final Logger LOGGER = Logger.getLogger(SupplierController.class);

	@Autowired
	SupplierService supplierService;

	@RequestMapping("/adminmanagesupp")
	public ModelAndView manageSuppliers(@ModelAttribute("msg") String msg) {
		List<Supplier> listSupplier = supplierService.getAllSupplier();
		LOGGER.info("<-- Inisde Supplier Manger Controller -->" + listSupplier + "Message" + msg.length() + "abc");
		LOGGER.info("didnt came here");
		ModelAndView suppHome = new ModelAndView();
		suppHome.setViewName("admin/suppliers");
		suppHome.addObject("listSupplier",listSupplier); 
		if(msg.length() == 0 ){
			LOGGER.info("It is empty");
			suppHome.addObject("msg" , "Supplier Management System");
		}
		return suppHome;

	}
	
	@RequestMapping("/searchSupplierForm")
	public ModelAndView searchSupplier(@RequestParam("name") String name) {
		List<Supplier> listSupplier = supplierService.searchSupplier(name);
		if (listSupplier != null) {
			LOGGER.info("<-- Fetches searched Suppliers -->" + listSupplier.get(0).getSupplierName());
			return new ModelAndView("admin/suppliers", "listSupplier", listSupplier).addObject("msg", "Supplier Found");
		} else {
			listSupplier = supplierService.getAllSupplier();
			LOGGER.error("<-- Erorr fethcing searched Supplier therefore displaying all suppliers -->");
			return new ModelAndView("admin/suppliers", "listSupplier", listSupplier).addObject("msg",
					"Supplier Not Found Check the Search String Again");
		}
	}

	
	
	
	
	
	@RequestMapping("/addSupplierForm")
	public ModelAndView addSupplier(@Valid @ModelAttribute Supplier supplier, BindingResult result,
			RedirectAttributes redir, HttpServletRequest request) {

		if (supplierService.addSupplierService(supplier) && !(result.hasErrors())) {
			LOGGER.info("<-- Inside AddSupplier Success Controller -->");
			return new ModelAndView("redirect:/adminmanagesupp");
		} else {
			LOGGER.error("<-- Coulnt Not Add Supplier Inside error of controller -->");
			return new ModelAndView("redirect:/adminmanagesupp").addObject("msg", "Supplier Could Not Be Added");
		}
	}

	
	
	
	
	
	
	@RequestMapping("/updateSupplierForm")
	public ModelAndView updateSupplier(@ModelAttribute Supplier supplier) {
		if (supplierService.updateSupplier(supplier)) {
			LOGGER.info("<-- Update Supplier Controller -->");
			return new ModelAndView("redirect:/adminmanagesupp").addObject("msg", "Supplier Updated Successfully");
		} else {
			LOGGER.error("<-- Could Not Update the Supplier");
			return new ModelAndView("redirect:/adminmanagesupp").addObject("msg", "Error While Updating Supplier");
		}
	}
	
	
	
	
	

	@RequestMapping("/deleteSupplierForm")
	public ModelAndView deleteSupplier(@RequestParam("supplierId") int supplierId) {
		
		if (supplierService.deleteSupplier(supplierId)) {
			return new ModelAndView("redirect:/adminmanagesupp").addObject("msg", "Supplied Deleted Successfully");
		} else {
			return new ModelAndView("redirect:/adminmanagesupp").addObject("msg", "Error Deleting Supplier Invalid Id");
		}
	}

}