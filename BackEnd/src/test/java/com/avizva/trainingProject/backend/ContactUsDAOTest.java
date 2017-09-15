//package com.avizva.trainingProject.backend;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import com.avizva.trainingProject.backend.config.ApplicationContextConfig;
//import com.avizva.trainingProject.backend.config.TestApplicationContextConfig;
//import com.avizva.trainingProject.backend.dao.ContactUsDAO;
//import com.avizva.trainingProject.backend.dao.ForgotPassDAO;
//import com.avizva.trainingProject.backend.model.ContactUs;
//
//public class ContactUsDAOTest {
//	
//	private AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(TestApplicationContextConfig.class);
//	private ContactUsDAO contactUsDAOImpl=(ContactUsDAO)context.getBean("contactUsDAOImpl");
//	
//	@Test
//	public void testContactUs(){
//		ContactUs contactUs=new ContactUs();
//		contactUs.setName("Test");
//		contactUs.setEmail("Test@Test.Test");
//		contactUs.setDescription("Test");
//		contactUs.setContact(0L);
//		
//		assertTrue(contactUsDAOImpl.contactus(contactUs));
//	}
//
//}
