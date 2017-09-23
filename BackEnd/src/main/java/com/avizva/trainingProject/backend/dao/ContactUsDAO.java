package com.avizva.trainingProject.backend.dao;

import com.avizva.trainingProject.backend.model.ContactUs;

/**
 * 
 * @author Akshay Chourasia
 *<p>
 *This Interface is been used to manipulate the data in DataBase
 *and this DAO interface contains method which is further implemented in
 *ContactUsDAOImpl class.
 * 
 */
public interface ContactUsDAO {
	
	/**
	 * 
	 * @param contactUs object is been passed as an argument
	 * in the method which is been implemented in ContactUsDAOImpl class 
	 * @return this method is defined as it returns boolean to service layer.
	 */
public boolean contactus(ContactUs contactUs);
}
