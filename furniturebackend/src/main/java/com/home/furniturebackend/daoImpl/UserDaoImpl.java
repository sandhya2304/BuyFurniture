package com.home.furniturebackend.daoImpl;

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

	public boolean addCart(Cart cart)
	{
		try
		{
			sessionFactory.getCurrentSession().persist(cart);
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	
	
	
	

}
