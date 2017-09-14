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

/**
 * 
 * @author Akshay Chourasia
 * @repository is been used as such beans are eligible for persistence exception translation.
 * @Transactional is been used such that if any of the four methods failed to execute
 * then the whole process will get rollback.
 * 
 *
 */
@Repository
@Transactional
public class ForgotPassDAOImpl implements ForgotPassDAO {
	@Autowired
	private SessionFactory sessionFactory;
	

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
	/**
	 * @return use to return the list of object of user.
	 * <p>
	 * In this method we have performed the 'Select' crud 
	 * operation which is returning list of object stored
	 * in Database and further iterate on list to get the user object. 
	 * 
	 */
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
	
	
	
	
		/**
		 * @return it returns the boolean flag.
		 * <p>
		 * This method contain the logic of forgot password
		 * using createQuery we get the list of object.
		 * If the list is empty we will save the object of forgotpassword in Database.
		 * and if it is not empty then we will update the data by passing the forgotpassword object.
		 * 
		*/
		public boolean saveOtp(ForgotPass forgotPass){
		boolean flag = false;
		Session session = getSession();
		System.out.println(forgotPass  + " " + session);
		@SuppressWarnings("rawtypes")
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
		
		
		
	/**
	 * In this method we are fetching the one time password
	 * present in database by firing the query which
	 * returns the list so we store it in a list
	 * and returns the one time password. 
	 *  
	 */
	public String getOtp(ForgotPass forgotPass){
		Session session=getSession();

		Query q =  session.createQuery("from ForgotPass where email =:email");

		q.setParameter("email", forgotPass.getEmail());
		@SuppressWarnings("unchecked")
		List<ForgotPass> forgotPassList = q.list();
		System.out.println(forgotPassList.get(0));
		return forgotPassList.get(0).getOtp();
	}
	
	public void changePassword(User user){
		Session session = getSession();
		session.update(user);
	}
}
