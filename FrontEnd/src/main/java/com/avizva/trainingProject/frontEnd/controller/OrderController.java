package com.avizva.trainingProject.frontEnd.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.avizva.trainingProject.backend.model.Order;
import com.avizva.trainingProject.backend.model.Supplier;
import com.avizva.trainingProject.backend.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	private static final Logger LOGGER = Logger.getLogger(OrderController.class);

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, "orderDate", new CustomDateEditor(format, false));
		
	}
	
	@RequestMapping("/adminmanageorder")
	public ModelAndView manageOrders(@ModelAttribute("msg") String msg) {
		List<Order> listOrder= orderService.getAllOrder();
		LOGGER.info("<-- Inisde Order Manager Controller -->" + listOrder + "Message" + msg.length() + "abc");
		ModelAndView orderHome = new ModelAndView();
		orderHome.setViewName("admin/orders");
		orderHome.addObject("listOrder",listOrder); 
		if(msg.length() == 0 ){
			orderHome.addObject("msg" , "Order Management System");
		}
		return orderHome;
	}
	
	@RequestMapping("/searchOrderForm")
	public ModelAndView searchOrder(@RequestParam("orderNumberSearch") String orderNumber){
		List<Order> listOrder=orderService.searchOrder(orderNumber);
		if (listOrder != null) {
			LOGGER.info("<-- Fetches searched Orders -->" + listOrder.get(0).getOrderNumber());
			return new ModelAndView("admin/orders", "listOrder", listOrder).addObject("msg", "Order Found");
		} else {
			listOrder = orderService.getAllOrder();
			LOGGER.error("<-- Erorr fethcing searched Order therefore displaying all orders -->");
			return new ModelAndView("admin/orders", "listOrder", listOrder).addObject("msg",
					"Order Not Found Check the Search String Again");
		}
	}
	
	@RequestMapping("/addOrderForm")
	public ModelAndView addOrder(@Valid @ModelAttribute Order order, BindingResult result,
			RedirectAttributes redir, HttpServletRequest request){
		if (orderService.addOrder(order) && !(result.hasErrors())) {
			LOGGER.info("<-- Inside AddOrder Success Controller -->");
			return new ModelAndView("redirect:/adminmanageorder");
		} else {
			LOGGER.error("<-- Coulnt Not Add Order Inside error of controller -->");
			return new ModelAndView("redirect:/adminmanageorder").addObject("msg", "Order Could Not Be Added");
		}
	}
	
	@RequestMapping("/updateOrderForm")
	public ModelAndView updateOrder(@Valid @ModelAttribute Order order, BindingResult result,
			RedirectAttributes redir, HttpServletRequest request){
		if (orderService.updateOrder(order)) {
			LOGGER.info("<-- Inside UpdateOrder Success Controller -->");
			return new ModelAndView("redirect:/adminmanageorder");
		} else {
			LOGGER.error("<-- Coulnt Not Update Order Inside error of controller -->");
			return new ModelAndView("redirect:/adminmanageorder").addObject("msg", "Order Could Not Be Added");
		}
	}
	
	
	@RequestMapping("/deleteOrderForm")
	public ModelAndView deleteOrder(@RequestParam("orderId") int orderId) {
		
		if (orderService.deleteOrder(orderId)) {
			return new ModelAndView("redirect:/adminmanageorder").addObject("msg", "Order Deleted Successfully");
		} else {
			return new ModelAndView("redirect:/adminmanageorder").addObject("msg", "Error Deleting Order Invalid Id");
		}
	}
}
