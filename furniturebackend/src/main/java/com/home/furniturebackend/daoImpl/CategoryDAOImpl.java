package com.home.furniturebackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.home.furniturebackend.dao.CategoryDao;
import com.home.furniturebackend.dto.Category;


@Repository("categoryDao")
@Transactional
public class CategoryDAOImpl implements CategoryDao
{
	
	@Autowired
	private SessionFactory sessionFactory;
	

	public List<Category> listAll() {
		
		String selectActiveCategory="FROM Category where active = :active";
		
		Query query=sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active",true);
				
		return query.getResultList();
	}

	public Category get(int id) {
	   
		return sessionFactory.getCurrentSession().get(Category.class,Integer.valueOf(id));
		
	}

	
	public boolean add(Category category) 
	{
		try
		{
			// add category to the databse table
			sessionFactory.getCurrentSession().persist(category);
			return true;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		   return false;
		}
		
		
	}

	//update the category
	public boolean update(Category category) {
		try
		{
			// update category to the databse table
			sessionFactory.getCurrentSession().update(category);
			return true;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		   return false;
		}
	}

	public boolean delete(Category category) {
		
		category.setActive(false);
		
		try
		{
			// update category to the databse table
			sessionFactory.getCurrentSession().update(category);
			return true;
			
		}catch(Exception e)
		{
			e.printStackTrace();
		   return false;
		}
	}
	

}
