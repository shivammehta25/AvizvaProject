package com.avizva.trainingProject.backend.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
		try{
		Query q =  session.createQuery("from User where email =:email");
		q.setParameter("email", email);
		List<User> userList = q.list();
		if(!userList.isEmpty()){
		return userList.get(0);
		}}
		catch(Exception e){
			
			return null;

		}
		return null;
		
	}
	public boolean saveOtp(ForgotPass forgotPass){
		boolean flag = false;
		Session session = getSession();
		System.out.println(forgotPass  + " " + session);
		Query q = session.createQuery("from ForgotPass where email=:email");
		q.setParameter("email", forgotPass.getEmail());
		System.out.println(forgotPass);
		if(q.list().isEmpty()){
			session.save(forgotPass);
		}
		else {
			session.flush();
			session.clear();
			session.update(forgotPass);
		}
		
		flag = true;

		return flag;

	}
	
	public String getOtp(ForgotPass forgotPass){
		Session session=getSession();
		Query q =  session.createQuery("from ForgotPass where email =:email");
		q.setParameter("email", forgotPass.getEmail());
		List<ForgotPass> forgotPassList = q.list();
		System.out.println(forgotPassList.get(0));
		return forgotPassList.get(0).getOtp();
	}
	
	public void changePassword(User user){
		Session session = getSession();
		session.update(user);
	}
}
