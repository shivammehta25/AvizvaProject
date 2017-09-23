package com.avizva.trainingProject.backend.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;


/**
 * @Configuration indicates that the class can be used by the Spring IoC container as a source of bean definitions.
 * @Component is been used to autodetect and autoconfigure beans using classpath scanning.
 */
@Configuration
@Component
public class ApplicationContext {

	/**
	 * @Bean is used to explicitly declare a single bean of JavaMailSender
	 * <p>
	 * In the below method named getJavaMailSender we are creating the object of
	 * class JavaMailSenderImpl and setting the Properties using JavaMailSenderImpl object. 
	 * 
	 */
	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("YourEmail@gmail.com");
		mailSender.setPassword("SomethingEz");
		Properties properties = mailSender.getJavaMailProperties();
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.debug", "false");
		return mailSender;
	}

}
