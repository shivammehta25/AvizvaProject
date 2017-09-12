package com.avizva.trainingProject.backend.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.avizva.trainingProject.backend.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.openSession();
	}

	public boolean registerUser(User user) {
		boolean flag = false;
		Session session = getSession();
		
		System.out.println("Session created");

		Transaction tx = null;
		flag = true;
		try {
			tx = session.beginTransaction();

			session.persist(user);
			tx.commit();

			flag = true;
		} catch (Exception e) {
			tx.rollback();
			System.out.println("Exception while Saving the Product" + e);
		}
		return flag;
	}

}
