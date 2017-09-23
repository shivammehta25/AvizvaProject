package com.avizva.trainingProject.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
    
	/**
	 * @author Akshay Chourasia
	 * @configuration indicates that the class can be used by the Spring IoC container as a source of bean definitions.
	 * @componentScan is been used to scan the basepackages.
	 * <p>
	 *Class AppConfig is implementing the TransactionManagementConfigurer for the configuration of transaction
	 * 
	 */
	@Configuration
	@ComponentScan(basePackages= "com")
	public class AppConfig implements TransactionManagementConfigurer{

		/**
		 * annotationDrivenTransactionManager is the method defined 
		 * in the interface named TransactionManagementConfigurer
		 * which is allowing Transactional annotaion. 
		 * 
		 */
		public PlatformTransactionManager annotationDrivenTransactionManager() {
			return null;
		}
	}
