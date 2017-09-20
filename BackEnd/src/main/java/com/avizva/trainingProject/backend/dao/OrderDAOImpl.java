package com.avizva.trainingProject.backend.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.avizva.trainingProject.backend.model.Order;

@Repository
@Transactional
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger LOGGER=Logger.getLogger(OrderDAOImpl.class);
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public boolean addOrder(Order order){
		boolean flag=false;
		try {
			Session session=getSession();
			session.save(order);
			flag=true;
			LOGGER.info("<-- Order " + order.getOrderNumber() + " added --> ");
		} catch (Exception e) {
			LOGGER.error("<-- Error Adding Order -->");
		}
		return flag;
	}
	
	public boolean updateOrder(Order order){
		boolean flag=false;
		try {
			Session session=getSession();
			session.update(order);
			flag=true;
			LOGGER.info("<-- Order " + order.getOrderNumber() + " Updated --> ");
		} catch (Exception e) {
			LOGGER.error("<-- Error Updating Order  -->");
		}
		return flag;
	}
	
	public boolean removeOrder(Order order){
		boolean flag=false;
		try {
			Session session=getSession();
			session.delete(order);
			flag=true;
			LOGGER.info("<-- Order " + order.getOrderNumber() + " Deleted --> ");
		} catch (Exception e) {
			LOGGER.error("<-- Error Deleting Order  -->");
		}
		return flag;
	}

	public List<Order> getAllOrder(){
		List<Order> listOrder=null;
		try {
			Session session=getSession();
			Query query=session.createQuery("from Orders");
			listOrder=query.list();
			LOGGER.info("<-- Fetched all the Orders -->");
		} catch (Exception e) {
			LOGGER.error("<-- Couldn't Fetch All Orders");
		}
		return listOrder;
	}
	
	public Order getOrderById(int orderId){
		Session session=getSession();
		try {
			Order order=session.get(Order.class, orderId);
			LOGGER.info("<-- Fetched Order's Object");
			return order;
		} catch (Exception e) {
			LOGGER.error("<-- Couldn't Fetch All Order's Object from ID");
		}
		return null;
	}
}
