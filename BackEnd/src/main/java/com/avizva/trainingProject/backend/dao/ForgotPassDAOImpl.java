package com.avizva.trainingProject.backend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.avizva.trainingProject.backend.model.ForgotPass;
import com.avizva.trainingProject.backend.model.User;

@Repository
@Transactional
public class ForgotPassDAOImpl implements ForgotPassDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public User findEmail(String email){
		Session session = getSession();
		Query<User> q = (Query<User>) session.createQuery("from User where email =:email");
		q.setParameter("email", email);
		List<User> userList = q.list();
		return userList.get(0);
		
	}
	public void saveOtp(ForgotPass forgotPass){
		//Save onetimepass in forgotpass table
		Session session = getSession();
		session.update(forgotPass);


	}
	
	public String getOtp(ForgotPass forgotPass){
		//Get onetimepass from forgotpass table
		Session session=getSession();
		Query<ForgotPass> q = (Query<ForgotPass>) session.createQuery("from ForgotPass where username =:username");
		q.setParameter("username", forgotPass.getUsername());
		List<ForgotPass> forgotPassList = q.list();
		return forgotPassList.get(0).getOtp();
	}
	
	public void changePassword(User user){
		Session session = getSession();
		session.update(user);
	}
}