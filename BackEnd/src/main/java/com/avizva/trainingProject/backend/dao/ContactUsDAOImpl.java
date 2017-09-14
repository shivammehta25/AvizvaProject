package com.avizva.trainingProject.backend.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avizva.trainingProject.backend.model.ContactUs;


/**
 * 
 * @author Akshay Chourasia
 * @repository is been used as such beans are eligible for persistence exception translation.
 * <p>
 * This class implements the DAO Interface which contains the unimplimented methods
 * named contactUs.It contain sessionfactory object which is been Autowired
 * further.The Business logic is been writeen in method contactUs to perform crud operation with Database. 
 * 
 */
@Repository
public class ContactUsDAOImpl implements ContactUsDAO {
	
	
	
	/**
	 * @Autowired This annotation is been used to Autowire the sessionfactory object.
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	/**
	 * 
	 * @return this getSession method is been to open the session which is returning the session object.
	 */
	public Session getSession() {
		return sessionFactory.openSession();
	}
	
	
	
	/**
	 * @return it is returning the boolean flag if the transaction is successful
	 * its returns true otherwise returns false.
	 * <p>
	 * This is an unimplemented method defined in ContactUsDAO interface,
	 * In this method using getSession we are getting the current session
	 * initially we are creating the transaction object and call the method
	 * begintransaction after that using save method we save the object in Database.
	 * <p>
	 * Exception is been handled using try catch
	 * because if the tansaction is not successfully it will rollback the changes. 
	 *   
	 */
	public boolean contactus(ContactUs contactUs) {
		boolean flag = false;
		Session session = getSession();
		
		System.out.println("Session created for ContactUs");

		Transaction tx = null;
		flag = true;
		try {
			tx = session.beginTransaction();

			session.save(contactUs);
			tx.commit();

			flag = true;
		} catch (Exception e) {
			tx.rollback();
			System.out.println("Exception while Saving the contactus" + e);
		}
		return flag;
	}
	

}
