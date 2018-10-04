package com.home.furniturebackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.home.furniturebackend.dao.CartLineDao;
import com.home.furniturebackend.dao.ProductDao;
import com.home.furniturebackend.dao.UserDao;
import com.home.furniturebackend.dto.Cart;
import com.home.furniturebackend.dto.CartLine;
import com.home.furniturebackend.dto.Product;
import com.home.furniturebackend.dto.User;

public class CartLineTestCase
{
	
	private static AnnotationConfigApplicationContext context;
	
	private static CartLineDao cartLineDao = null;
	private static ProductDao productDao = null;
	private static UserDao userDao = null;
	
	private Product product =null;
	private User user = null;
	private Cart cart = null;
	private CartLine cartLine ;
	
	@BeforeClass
	public static void init()
	{
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.home.furniturebackend");
		context.refresh();
		
		productDao = (ProductDao) context.getBean("productDao");
		userDao = (UserDao) context.getBean("userDao");
		cartLineDao = (CartLineDao) context.getBean("cartLineDao");
		
	}
	
	
	/*
	@Test
	public void testAddNewCartLine()
	{
		
		//get the user
		
		user = userDao.getByEmail("nimo@gmail.com");
		
		//fetch the cart
		cart = user.getCart();
		
		//get the product
		product = productDao.get(33);
		
		//create a new cartline
		cartLine = new CartLine();
		cartLine.setCartId(cart.getId());
		cartLine.setProduct(product);
		
		cartLine.setProductCount(cartLine.getProductCount() + 1);
		
		cartLine.setBuyingPrice(product.getUnitPrice());
		
		cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
		
		cartLine.setAvailable(true);
		

		assertEquals("failed to add cartline ",true,cartLineDao.add(cartLine));
		
		//update the cart
		cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
		cart.setCartLines(cart.getCartLines() + 1);
		
		
		assertEquals("failed to upcate cart ",true,cartLineDao.updateCart(cart));
	}
	
*/

}
