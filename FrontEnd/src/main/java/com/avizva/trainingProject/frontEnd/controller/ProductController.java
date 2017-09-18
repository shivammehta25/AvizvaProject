package com.avizva.trainingProject.frontEnd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

import com.avizva.trainingProject.backend.model.Product;
import com.avizva.trainingProject.backend.service.ProductService;

@Controller
public class ProductController {

	private static final Logger LOGGER = Logger.getLogger(ProductController.class);

	@Autowired
	ProductService productService;
	
	@RequestMapping("/adminmanageprod")
	public ModelAndView manageProducts(@ModelAttribute("msg") String msg) {
		List<Product> listProduct = productService.getAllProduct();
		LOGGER.info("<-- Inside Product Manager Controller -->" + listProduct + "Message" + msg.length());
		ModelAndView prodHome = new ModelAndView();
		prodHome.setViewName("admin/products");
		prodHome.addObject("listProduct",listProduct); 
		if(msg.length() == 0 ){
			LOGGER.info("It is empty");
			prodHome.addObject("msg" , "Product Management System");
		}
		return prodHome;
	}
	

	@RequestMapping("searchProductForm")
	public ModelAndView searchProduct(@RequestParam("name") String name) {
		List<Product> listProduct = productService.searchProduct(name);
		if (listProduct != null) {
			LOGGER.info("<-- Fetched searched Products -->" + listProduct.get(0).getProductName());
			return new ModelAndView("admin/products", "listProduct", listProduct).addObject("msg", "Product Found");
		} else {
			listProduct = productService.getAllProduct();
			LOGGER.error("<-- Erorr fetching searched Product therefore displaying all products -->");
			return new ModelAndView("admin/products", "listProduct", listProduct).addObject("msg",
					"Product Not Found Check the Search String Again");
		}
	}

	
	
	
	
	
	@RequestMapping("/addProductForm")
	public ModelAndView addProducts(@Valid @ModelAttribute Product product, BindingResult result,
			RedirectAttributes redir, HttpServletRequest request) {
		System.out.println("Controller"+product);
		if (productService.addProductService(product) && !(result.hasErrors())) {
			LOGGER.info("<-- Inside Add Product Success Controller -->");
			return new ModelAndView("redirect:/adminmanageprod");
		} else {
			LOGGER.error("<-- Coulnt Not Add Product. Inside error of controller -->");
			return new ModelAndView("redirect:/adminmanageprod").addObject("msg", "Product Could Not Be Added");
		}
	}

	
	
	
	
	
	
	@RequestMapping("updateProductForm")
	public ModelAndView updateProduct(@ModelAttribute Product product) {
		if (productService.updateProduct(product)) {
			LOGGER.info("<-- Update Product Controller -->");
			return new ModelAndView("redirect:/adminmanageprod").addObject("msg", "Product Updated Successfully");
		} else {
			LOGGER.error("<-- Could Not Update the Product");
			return new ModelAndView("redirect:/adminmanageprod").addObject("msg", "Error While Updating Product");
		}
	}
	
	
	
	
	

	@RequestMapping("deleteProductForm")
	public ModelAndView deleteProduct(@RequestParam("productId") int productId) {
		
		if (productService.deleteProduct(productId)) {
			return new ModelAndView("redirect:/adminmanageprod").addObject("msg", "Product Deleted Successfully");
		} else {
			return new ModelAndView("redirect:/adminmanageprod").addObject("msg", "Error Deleting Product Invalid Id");
		}
	}
}
