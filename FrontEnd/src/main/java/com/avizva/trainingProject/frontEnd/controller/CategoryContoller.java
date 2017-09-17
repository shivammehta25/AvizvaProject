package com.avizva.trainingProject.frontEnd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.avizva.trainingProject.backend.model.Category;

@Controller
public class CategoryContoller {
	
	@RequestMapping("/testmanagecat")
	public ModelAndView testManageCategories(){
		
		
		return new ModelAndView("admin/categories");
		
	}
	
	@RequestMapping("/adminmanagecat")
	public ModelAndView manageCategories() {
		return new ModelAndView("admin/categories");

	}

	@RequestMapping("/searchCategoryForm")
	public ModelAndView searchCategoryForm(@RequestParam("name") String name){
//		if(Service Call)
		{
			return new ModelAndView("admin/categories").addObject("msg", "Category Found");
		}
//		else
//		{
//			return new ModelAndView("admin/categories").addObject("msg", "Category does not exist");
//		}
	}
	
	@RequestMapping("/addCategoryForm")
	public ModelAndView addCategoryForm(@ModelAttribute Category category, BindingResult result){
//		if(Service Call)
		{
			return new ModelAndView("admin/categories").addObject("msg", "Category Added");
		}
//		else
//		{
//			return new ModelAndView("admin/categories").addObject("msg", "Could not add category");
//		}
	}
	
	@RequestMapping("/updateCategoryForm")
	public ModelAndView updateCategoryForm(@ModelAttribute Category category, BindingResult result){
//		if(Service Call)
		{
			return new ModelAndView("admin/categories").addObject("msg", "Category Updated");
		}
//		else
//		{
//			return new ModelAndView("admin/categories").addObject("msg", "Could not update category");
//		}
	}
	
	@RequestMapping("/deactivateCategoryForm")
	public ModelAndView deactivateCategoryForm(@RequestParam("name") String name){
//		if(Service Call)
		{
			return new ModelAndView("admin/categories").addObject("msg", "Category Deactivated");
		}
//		else
//		{
//			return new ModelAndView("admin/categories").addObject("msg", "Category could not be deactivated");
//		}
	}
}
