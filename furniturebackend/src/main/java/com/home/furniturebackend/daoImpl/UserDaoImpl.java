package com.home.furniturebackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.home.furniturebackend.dao.UserDao;
import com.home.furniturebackend.dto.Address;
import com.home.furniturebackend.dto.Cart;
import com.home.furniturebackend.dto.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao
{
	@Autowired
	private SessionFactory sessionFactory;

	public boolean addUser(User user)
	{
		try
		{
			
			sessionFactory.getCurrentSession().persist(user);
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		
		
	}

	public boolean addAddress(Address address) 
	{
	
		try
		{
			
			sessionFactory.getCurrentSession().persist(address);
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		
	}

	public boolean updateCart(Cart cart)
	{
		try
		{
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		
	}

	public User getByEmail(String email) 
	{
		
		String query="from User where email =:email";
		try
		{		
			return sessionFactory.getCurrentSession()
					     .createQuery(query,User.class)
					          .setParameter("email",email).getSingleResult();
			
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			return null;
		}
		
		
	}

	public Address getBillingAddress(User user)
	{
		
		String query = "From Address where user = :user and billing = :billing";
		
		try
		{
			return sessionFactory.getCurrentSession()
					  .createQuery(query,Address.class)
					   .setParameter("user",user)
			           .setParameter("billing",true)
			            .getSingleResult();
			
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
		
	}

	public List<Address> listShippingAddress(User user)
	{
       String query = "From Address where user = :user and shipping = :shipping";
		
		try
		{
			return sessionFactory.getCurrentSession()
					  .createQuery(query,Address.class)
					   .setParameter("user",user)
			           .setParameter("shipping",true)
			            .getResultList();
			
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	
	
	
	

}
