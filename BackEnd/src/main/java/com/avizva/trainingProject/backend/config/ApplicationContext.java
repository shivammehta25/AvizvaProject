package com.avizva.trainingProject.backend.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class ApplicationContext {


	@Bean
	public JavaMailSender getJavaMailSender() {
		System.out.println("creating java bean of mailer");
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("saurabhino@gmail.com");
		mailSender.setPassword("message1");
		Properties properties = mailSender.getJavaMailProperties();
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.debug", "false");
		return mailSender;
	}

}
