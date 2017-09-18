/**
 * 
 */
package com.avizva.trainingProject.backend.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.avizva.trainingProject.backend.model.Category;
import com.avizva.trainingProject.backend.model.Supplier;

/**
 * @author Saurabh.Miglani
 *
 */
@Repository
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	private static final Logger LOGGER = Logger.getLogger(SupplierDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public boolean createCategory(Category category) {
		
		boolean flag=false;
		try{
		Session session=getSession();
		category.setEnabled(true);
		session.save(category);
		flag=true;
		LOGGER.info("<-- Category added " + category.getCategoryName() + "--> ");
		}
		catch(Exception e){
			LOGGER.error("<-- Error Adding Category -->");
		}
		return flag;
		
	}
	
	public Category getCategoryById(int categoryId) {
		Session session = getSession();
		try{
			Category category = session.get(Category.class , categoryId);
			LOGGER.info("<-- Fetched Category's Object");
			return category;
			}catch(Exception e){
				LOGGER.error("<-- Couldnt not fetch Category's Object from ID");
			}
			return null;	
	}
	
	
	public List<Category> getAllCategory(){
		List<Category> listCatgeory=null;
		try {
			Session session=getSession();
			Query q=session.createQuery("from Category where enabled=1");
			listCatgeory=q.list();
			LOGGER.info("<-- Fetched all the Categories -->");
		}catch(Exception e){
			LOGGER.error("<-- Couldn't Not Fetch All Categories");
		}
		
		return listCatgeory;
	}
	

	

	public boolean updateCategory(Category category) {
		
		boolean flag=false;
		Session session=getSession();
		try{
			category.setEnabled(true);
		session.update(category);
		flag=true;
		LOGGER.info("<-- Category Updated " + category.getCategoryName() + " -->");
		}catch(Exception e){
			LOGGER.error("<-- Error Updating Category ");
		}
		return flag;
	}

	public boolean deactivateCategory(Category category) {
		boolean flag=false;
		try{
			Session session=getSession();
			category.setEnabled(false);
			session.update(category);
			flag=true;
			LOGGER.info("<-- Category Deactivated " + category.getCategoryName()  +"  -->");
		}catch (Exception e) {
			LOGGER.error("<-- Error Deactivating Category  -->");
		}
		return flag;
	}
	
	public List<Category> searchCategory(String name) {
		
		Session session  = getSession();
		try {
			Query q = session.createQuery("from Category where categoryName like :name");
			q.setParameter("name", name+"%");
			List<Category> listCategory = q.list();
			LOGGER.info(listCategory + "!!!!!!!List here");
			return listCategory;
		}catch(Exception e){
			LOGGER.error("<-- Could Not Search Anything -->");
		}
		
		return null;
	}
}
