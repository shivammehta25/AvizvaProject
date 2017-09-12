package com.avizva.trainingProject.backend.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avizva.trainingProject.backend.model.ContactUs;

@Repository
public class ContactUsDAOImpl implements ContactUsDAO {
	
	
	
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.openSession();
	}
	

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
