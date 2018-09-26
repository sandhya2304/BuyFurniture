package com.home.furniturebackend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.home.furniturebackend.dao.CartLineDao;
import com.home.furniturebackend.dto.Cart;
import com.home.furniturebackend.dto.CartLine;


@Repository("cartLineDao")
@Transactional
public class CartLineDAOImpl implements CartLineDao
{
	
	@Autowired
	private SessionFactory sessionFactory;

	public CartLine get(int id)
	{	
		return sessionFactory.getCurrentSession().get(CartLine.class,id);
	}

	public boolean add(CartLine cartLine) 
	{
		try
		{
			sessionFactory.getCurrentSession().persist(cartLine);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(CartLine cartLine) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(cartLine);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(CartLine cartLine) 
	{
		
		try
		{
			sessionFactory.getCurrentSession().update(cartLine);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	public List<CartLine> listAll(int cartId)
	{
		String query = "from CartLine where cartId = :cartId";
		return sessionFactory.getCurrentSession()
				              .createQuery(query,CartLine.class)
				              .setParameter("cartId",cartId)
		                       .getResultList();
		
	}

	public List<CartLine> listAvailable(int cartId) 
	{
		String query = "from CartLine where cartId = :cartId and available = :available";
		return sessionFactory.getCurrentSession()
				              .createQuery(query,CartLine.class)
				              .setParameter("cartId",cartId)
				              .setParameter("available", true)
		                       .getResultList();
		
	}

	public CartLine getByCartAndProduct(int cartId, int productId)
	{
		String query = "from CartLine where cartId = :cartId and product.id = :productId";
		
		try
		{
		   return sessionFactory.getCurrentSession()
				              .createQuery(query,CartLine.class)
				              .setParameter("cartId",cartId)
				              .setParameter("productId", productId)
		                       .getSingleResult();
		}catch(Exception e)
		{
			return null;
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

	
	

}
