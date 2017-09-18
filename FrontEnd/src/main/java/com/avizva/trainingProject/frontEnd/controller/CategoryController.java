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

import com.avizva.trainingProject.backend.model.Category;
import com.avizva.trainingProject.backend.service.CategoryService;

@Controller
public class CategoryController {
	
	private static final Logger LOGGER = Logger.getLogger(CategoryController.class);
	
	@Autowired
	CategoryService categoryService;
	

	@RequestMapping("/adminmanagecat")
	public ModelAndView manageCategories(@ModelAttribute("msg") String msg) {
		List<Category> listCategory = categoryService.getAllCategory();
		LOGGER.info("<-- Inisde Category Manager Controller -->" + listCategory + "Message" + msg.length() + "abc");
		ModelAndView catHome = new ModelAndView();
		catHome.setViewName("admin/categories");
		catHome.addObject("listCategory",listCategory); 
		if(msg.length() == 0 ){
			LOGGER.info("It is empty");
			catHome.addObject("msg" , "Category Management System");
		}
		return catHome;
	}

	@RequestMapping("/searchCategoryForm")
	public ModelAndView searchCategoryForm(@RequestParam("name") String name){
		List<Category> listCategory = categoryService.searchCategory(name);
		if (listCategory != null) {
			LOGGER.info("<-- Fetches searched Categories -->" + listCategory.get(0).getCategoryName());
			return new ModelAndView("admin/categories", "listCategory", listCategory).addObject("msg", "Category Found");
		} else {
			listCategory = categoryService.getAllCategory();
			LOGGER.error("<-- Erorr fethcing searched Category therefore displaying all categories -->");
			return new ModelAndView("admin/categories", "listCategory", listCategory).addObject("msg",
					"Category Not Found Check the Search String Again");
		}
	}
	
	@RequestMapping("/addCategoryForm")
	public ModelAndView addCategoryForm(@Valid @ModelAttribute Category category, BindingResult result, 
			RedirectAttributes redir, HttpServletRequest request){
		if(categoryService.addCategoryService(category) && !(result.hasErrors()))
		{
			LOGGER.info("<-- Inside AddCategory Success Controller -->");
			return new ModelAndView("redirect:/adminmanagecat").addObject("msg" , "Category Added Successfully");
		}
		else
		{
			LOGGER.error("<-- Coulnt Not Add Category Inside error of controller -->");
			return new ModelAndView("redirect:/adminmanagecat").addObject("msg", "Category Could Not Be Added");		}
	}
	
	@RequestMapping("/updateCategoryForm")
	public ModelAndView updateCategoryForm(@ModelAttribute Category category){
		if(categoryService.updateCategory(category))
		{	
			LOGGER.info("<-- Update Category Controller -->");
			return new ModelAndView("redirect:/adminmanagecat").addObject("msg", "Category Updated");
		}
		else
		{
			LOGGER.info("<-- Could not update the Category -->");
			return new ModelAndView("redirect:/adminmanagecat").addObject("msg", "Could Not Update Category");
		}
	}
	
	@RequestMapping("/deactivateCategoryForm")
	public ModelAndView deactivateCategoryForm(@RequestParam("categoryId") int categoryId){
		if(categoryService.deleteCategory(categoryId))
		{
			LOGGER.info("<-- Update Deactivate Controller -->");
			return new ModelAndView("redirect:/adminmanagecat").addObject("msg", "Category Deactivated");
		}
		else
		{	
			LOGGER.info("<-- Could not deactivate the Category -->");
			return new ModelAndView("redirect:/adminmanagecat").addObject("msg", "Category could not be deactivated");
		}
	}
}
