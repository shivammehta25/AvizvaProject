package com.avizva.trainingProject.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
   @Configuration
	@ComponentScan(basePackages= "com")
	public class AppConfig implements TransactionManagementConfigurer{

		public PlatformTransactionManager annotationDrivenTransactionManager() {
			return null;
		}
	}
