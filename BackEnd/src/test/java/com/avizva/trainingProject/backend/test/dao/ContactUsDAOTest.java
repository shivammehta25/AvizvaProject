package com.avizva.trainingProject.backend.test.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.avizva.trainingProject.backend.dao.ContactUsDAO;
import com.avizva.trainingProject.backend.model.ContactUs;
import com.avizva.trainingProject.backend.test.config.TestApplicationContextConfig;

@ContextConfiguration(classes=TestApplicationContextConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ContactUsDAOTest {
	
	@Autowired
	private ContactUsDAO contactUsDAO;
	@Test
	public void testContactUs(){
		ContactUs contactUs=new ContactUs();
		contactUs.setName("Test");
		contactUs.setEmail("Test@Test.Test");
		contactUs.setDescription("Test");
		contactUs.setContact(0L);
		
		assertTrue(contactUsDAO.contactus(contactUs));
	}

}
