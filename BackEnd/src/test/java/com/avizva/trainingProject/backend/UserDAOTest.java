package com.avizva.trainingProject.backend;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.avizva.trainingProject.backend.config.ApplicationContextConfig;
import com.avizva.trainingProject.backend.config.TestApplicationContextConfig;
import com.avizva.trainingProject.backend.dao.UserDAO;
import com.avizva.trainingProject.backend.dao.UserDAOImpl;
import com.avizva.trainingProject.backend.model.Address;
import com.avizva.trainingProject.backend.model.User;

public class UserDAOTest {
	
	private AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(TestApplicationContextConfig.class);
	private UserDAO userDAOImpl=(UserDAO)context.getBean("userDAOImpl");
	
	@Test
	public void testRegisterUser(){
		
		
		
//		Address address=new Address();
//		address.setAddress("Test");
//		address.setCity("Test");
//		address.setCountry("Test");
//		User user=new User();
//		user.setUsername("Test3");
//		user.setName("Test");
//		user.setEmail("Test@Test.Test");
//		user.setPassword("Test");
//		user.setAddress(address);
//		user.setContact(0L);
//		assertTrue(userDAOImpl.registerUser(user));

//		//False User has a username with length 1  
//		User falseUser=new User();
//		falseUser.setUsername("T");
//		falseUser.setName("Test");
//		falseUser.setPassword("Test");
//		falseUser.setContact(0L);
//		falseUser.setAddress(address);
//		assertFalse(userDAOImpl.registerUser(falseUser));
	}
	
	@Test
	public void testAuthLogin(){
		assertTrue(userDAOImpl.authLogin("Test", "Test"));
	}
	
	@Test
	public void testGetUserByUsername(){
		User testUser=userDAOImpl.getUserByUsername("Test");
		assertTrue(testUser.getUsername().equals("Test"));
	}

	@Test
	public void testDeactivate(){
		Address address=new Address();
		address.setAddress("Test");
		address.setCity("Test");
		address.setCountry("Test");
		User user=new User();
		user.setUsername("Test");
		user.setName("Test");
		user.setPassword("Test");
		user.setAddress(address);
		user.setContact(0L);
		assertTrue(userDAOImpl.deactivate(user));
	}
	
	@Test
	public void testUpdateUser(){
		Address address=new Address();
		address.setAddress("Test");
		address.setCity("Test");
		address.setCountry("Test");
		User user=new User();
		user.setUsername("Test");
		user.setName("Test");
		user.setPassword("Test");
		user.setAddress(address);
		user.setContact(0L);
		user.setEnable(true);
		assertTrue(userDAOImpl.updateUser(user));
	}
}
