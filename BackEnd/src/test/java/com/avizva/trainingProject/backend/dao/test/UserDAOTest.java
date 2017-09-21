package com.avizva.trainingProject.backend.dao.test;



import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.avizva.trainingProject.backend.dao.UserDAO;
import com.avizva.trainingProject.backend.model.Address;
import com.avizva.trainingProject.backend.model.User;
import com.avizva.trainingProject.backend.test.config.TestApplicationContextConfig;


@ContextConfiguration(classes=TestApplicationContextConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDAOTest {
	
	@Autowired
	private UserDAO userDAO;
	
	@Test
	public void testRegisterUser(){
		
		Address address=new Address();
		address.setAddress("Test");
		address.setCity("Test");
		address.setCountry("Test");
		address.setPin(0);
		User user=new User();
		user.setUsername("Test");
		user.setName("Test");
		user.setPassword("Test");
		user.setEmail("Test@Test.Test");
		user.setAddress(address);
		user.setContact(0L);
		assertTrue(userDAO.registerUser(user));

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
		assertTrue(userDAO.authLogin("Test", "Test"));
	}
	
	@Test
	public void testGetUserByUsername(){
		User testUser=userDAO.getUserByUsername("Test");
		assertTrue(testUser.getUsername().equals("Test"));
	}

	@Test
	public void testDeactivate(){
		Address address=new Address();
		address.setAddress("Test");
		address.setCity("Test");
		address.setCountry("Test");
		address.setPin(0);
		User user=new User();
		user.setUsername("Test");
		user.setName("Test");
		user.setPassword("Test");
		user.setEmail("Test@Test.Test");
		user.setAddress(address);
		user.setContact(0L);
		assertTrue(userDAO.deactivate(user));
	}
	
//	@Test
//	public void testUpdateUser(){
//		Address address=new Address();
//		address.setAddress("Test");
//		address.setCity("Test");
//		address.setCountry("Test");
//		address.setPin(0);
//		User user=new User();
//		user.setUsername("Test");
//		user.setName("TestUpdate");
//		user.setPassword("Test");
//		user.setEmail("Test@Test.Test");
//		user.setAddress(address);
//		user.setContact(0L);
//		user.setEnabled(true);
//		
//		System.out.println(user);
//		assertTrue(userDAO.updateUser(user));
//	}
}

