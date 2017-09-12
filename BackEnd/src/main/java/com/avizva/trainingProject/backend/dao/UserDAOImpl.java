package com.avizva.trainingProject.backend.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.avizva.trainingProject.backend.model.User;


@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public boolean registerUser(User user) {
		boolean flag= false;
		Session session  = getSession();
		try{
		session.save(user);
		flag = true;
		}catch(Exception e){
			System.out.println("Exception while Saving the Product" + e);
		}
		return flag;
	}

}
