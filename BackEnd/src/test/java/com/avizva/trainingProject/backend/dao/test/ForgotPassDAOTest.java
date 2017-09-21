package com.avizva.trainingProject.backend.dao.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.avizva.trainingProject.backend.dao.ForgotPassDAO;
import com.avizva.trainingProject.backend.model.ForgotPass;
import com.avizva.trainingProject.backend.model.User;
import com.avizva.trainingProject.backend.test.config.TestApplicationContextConfig;

@ContextConfiguration(classes=TestApplicationContextConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ForgotPassDAOTest {

	@Autowired
	private ForgotPassDAO forgotPassDAO;
	
	@Test
	public void testFindEmail(){
		
		String testEmail="Test@Test.Test";
		User user=forgotPassDAO.findEmail(testEmail);
		assertTrue(user.getUsername().equals("Test"));
			
	}
	
	@Test
	public void testSaveOtp(){
		ForgotPass forgotPass=new ForgotPass();
		forgotPass.setEmail("test@test.test");
		forgotPass.setOtp("test");
		assertTrue(forgotPassDAO.saveOtp(forgotPass));
	}
	
	@Test
	public void testGetOtp(){
		ForgotPass forgotPass=new ForgotPass();
		forgotPass.setEmail("test@test.test");
		assertTrue(forgotPassDAO.getOtp(forgotPass).equals("test"));
	}
}
