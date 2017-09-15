package com.avizva.trainingProject.backend;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.avizva.trainingProject.backend.config.ApplicationContextConfig;
import com.avizva.trainingProject.backend.config.TestApplicationContextConfig;
import com.avizva.trainingProject.backend.dao.ForgotPassDAO;
import com.avizva.trainingProject.backend.model.ForgotPass;
import com.avizva.trainingProject.backend.model.User;

public class ForgotPassDAOTest {

	private AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(TestApplicationContextConfig.class);
	private ForgotPassDAO forgotPassDAOImpl=(ForgotPassDAO)context.getBean("forgotPassDAOImpl");

	@Test
	public void testFindEmail(){
		
		String testEmail="Test@Test.Test";
		User user=forgotPassDAOImpl.findEmail(testEmail);
		assertTrue(user.getUsername().equals("Test"));
			
	}
	
	@Test
	public void testSaveOtp(){
		ForgotPass forgotPass=new ForgotPass();
		forgotPass.setEmail("test@test.test");
		forgotPass.setOtp("test");
		assertTrue(forgotPassDAOImpl.saveOtp(forgotPass));
	}
	
	@Test
	public void testGetOtp(){
		ForgotPass forgotPass=new ForgotPass();
		forgotPass.setEmail("test@test.test");
		assertTrue(forgotPassDAOImpl.getOtp(forgotPass).equals("test"));
	}
}
