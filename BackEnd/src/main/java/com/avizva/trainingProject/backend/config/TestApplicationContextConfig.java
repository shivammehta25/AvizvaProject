package com.avizva.trainingProject.backend.config;
import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.avizva.trainingProject.backend.model.User;

/**
 * 
 * @author Akshay Chourasia
 * @componentScan is been used to scan the basepackages.
 * @Configuration indicates that the class can be used by the Spring IoC container as a source of bean definitions.
 * @EnableTransactionManagement is been used to register the internalTransactionAdvisor.
 * 
 */
@SuppressWarnings("unused")
@ComponentScan("com")
@Configuration
@EnableTransactionManagement
public class TestApplicationContextConfig {
	
	
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
	   DriverManagerDataSource dataSource=new DriverManagerDataSource();
	   
	   dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/testProject");
	    dataSource.setUsername("root"); 
	    dataSource.setPassword("");

	    return dataSource;
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
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
		
	}
	
	
	/**
	 * @param sessionFactory  bean is been created.
	 * @Autowired is been used on sessionfactory object to inject
	 * sessionFactory object dependency implicitly
	 * which uses setter and constructor injection.
	 * @return it returns the session.
	 *  <p>
	 * In the below method we have created the object of class LocalSessionFactoryBuilder
	 * and using that object we have accessed the method addProperties and call the method named 
	 * getHibernateProperties.
	 * 
	 */
	@Autowired
	@Bean(name = "sessionFactory")
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
