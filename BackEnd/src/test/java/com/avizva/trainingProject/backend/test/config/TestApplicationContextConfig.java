package com.avizva.trainingProject.backend.test.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.avizva.trainingProject.backend.config.ApplicationContextConfig;
import com.avizva.trainingProject.backend.model.User;

/**
 * 
 * @author Akshay Chourasia
 * @componentScan is been used to scan the basepackages.
 * @Configuration indicates that the class can be used by the Spring IoC container as a source of bean definitions.
 * @EnableTransactionManagement is been used to register the internalTransactionAdvisor.
 * 
 */
@Configuration
@EnableTransactionManagement
@ComponentScan("com")
public class TestApplicationContextConfig extends ApplicationContextConfig{
	
	
	/**
	 * @Bean is used to create the bean.
	 * @param dataSource is the object which contain the information related to database.
	 * <p>
	 * Below a method is defined named getDataSource whose return type is of datasource which contains
	 * all the information related to connection establishment.
	 * 
	 */
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
	   EmbeddedDatabaseBuilder builder= new EmbeddedDatabaseBuilder();
	   builder.setType(EmbeddedDatabaseType.H2);
	   
	   return builder.build();
	}
	
	
	/**
	 * @param properties is used to hold the information about the database.
	 * <p>
	 * The getHibernateproperties method is been defined
	 * whose return type is Properties which contains the 
	 * information related to database configuration.
	 * 
	 */
	public Properties getHibernateProperties()
	{
		Properties properties=new Properties();
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
		
	}
	
	/**
	 * Method to create sessionFactory bean
	 * 
	 * @param dataSource
	 *            the dataSource bean
	 * @return SessionFactory returns sessionFactory bean
	 */
	@Autowired
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {

	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	sessionBuilder.addProperties(getHibernateProperties());
	sessionBuilder.scanPackages("com");
	return sessionBuilder.buildSessionFactory();
	}
	
	/**
	 * 
	 * @param transactionManager is used as parameter to create the bean of transactionManager
	 * @return is been used to return the transactionmanager object.
	 */
	@Autowired
	@Bean(name ="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new   HibernateTransactionManager(sessionFactory);
	    return transactionManager;
	}

	
	
}
