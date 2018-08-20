package com.home.furniturebackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.home.furniturebackend.dao.ProductDao;
import com.home.furniturebackend.dto.Product;



@Repository("productDao")
@Transactional
public class ProductDAOImpl implements ProductDao
{
	
	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * 
	 *Single
	 */
	public Product get(int productId) 
	{
		return sessionFactory.getCurrentSession().get(Product.class,Integer.valueOf(productId));
	}
 /*
  * 
  * List
  */
	public List<Product> listAll()
	{
		return sessionFactory.getCurrentSession()
				                 .createQuery("from Product",Product.class)
				                   .getResultList();
	}
/*
 * Insert
 * 
 */
	public boolean addProduct(Product p) 
	{
		try
		{
		   sessionFactory.getCurrentSession().persist(p);
		   return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		return false;
		
	}
/*
 * delete
 */
	public boolean deleteProduct(Product p) 
	{
		p.setActive(false);
		
		try
		{
		   sessionFactory.getCurrentSession().update(p);
		   return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		return false;
	}
/*
 * update
 * 
 */
	public boolean updateProduct(Product p)
	{
		try
		{
		   sessionFactory.getCurrentSession().update(p);
		   return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		return false;
	}

	public List<Product> listActiveProducts() 
	{
		String SetActiveProduct="from Product where active = :active";
		return sessionFactory
				  .getCurrentSession()
				    .createQuery(SetActiveProduct,Product.class)
				      .setParameter("active",true)
				        .getResultList();
				    
	}

	public List<Product> listActiveProductByCategory(int categoryId)
   {
		
		String SetActiveProductByCategory="from Product where active = :active and categoryId =:categoryId";
		return sessionFactory
				  .getCurrentSession()
				    .createQuery(SetActiveProductByCategory,Product.class)
				      .setParameter("active",true)
				      .setParameter("categoryId",categoryId)
				        .getResultList();
	}

	public List<Product> getLatestActiveProducts(int count) {
		String SetLatestActiveProduct="from Product where active = :active order by id";
		return sessionFactory
				  .getCurrentSession()
				    .createQuery(SetLatestActiveProduct,Product.class)
				      .setParameter("active",true)
				      .setFirstResult(0)
				      .setMaxResults(count)
				        .getResultList();
	}
	

}
