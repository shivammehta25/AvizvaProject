package com.avizva.trainingProject.frontEnd.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.trainingProject.backend.dao.CategoryDAO;
import com.avizva.trainingProject.backend.model.Category;
import com.avizva.trainingProject.backend.model.Product;
import com.avizva.trainingProject.backend.service.ProductService;
import com.google.gson.Gson;

@Controller
public class UserProduct {

	private static final Logger LOGGER = Logger.getLogger(UserProduct.class);

	@Autowired
	ProductService productService;
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	ServletContext context;
	
	
	@RequestMapping("/products")
	public ModelAndView callProduct(@RequestParam(value="categoryName",defaultValue="all") String productCatName){
		List<Category> listCategory = categoryDAO.getAllCategory();
		context.setAttribute("listCategory", listCategory);
		List<Product> list = null;
		if(productCatName.equals("all")){
		list = productService.getAllProduct();
		}
		else {
			list = productService.getProductByCategory(productCatName);
		}
		Gson gson = new Gson();
		String listProduct = gson.toJson(list);
		return new ModelAndView("products").addObject("listProduct" , listProduct);
	}
}
