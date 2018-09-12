package com.home.furniturebackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.home.furniturebackend.dao.UserDao;
import com.home.furniturebackend.dto.Address;
import com.home.furniturebackend.dto.Cart;
import com.home.furniturebackend.dto.User;

public class UserTestCase
{
	
	private static AnnotationConfigApplicationContext context;
	private static UserDao userDao;
	private User user= null;
	
	private Address address =null;
	
	private Cart cart =null ;
	
	
	
	
	@BeforeClass
	public static void init()
	{
		
		context=new AnnotationConfigApplicationContext();
		context.scan("com.home.furniturebackend");
		context.refresh();
		
		userDao = (UserDao) context.getBean("userDao");
		
	}
	
	/*@Test
	public void testAdd()
	{
		
		User user=new User();
		user.setFirstName("Ram");
		user.setLastName("Sharma");
		user.setEmail("ram@gmail.com");
		user.setContactNumber("98730000");
		user.setRole("USER");
		user.setPassword("1234");
		
		//add the user
		assertEquals("Failed To Add user",true, userDao.addUser(user));
		
		
		//
		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);
		
		//link the user withe the adrress with user id
		address.setUserId(user.getId());
		
		//add the address
		assertEquals("Failed To Add address",true, userDao.addAddress(address));
		
		if(user.getRole().equals("USER"))
		{
			//create a cart for this user
			
			cart = new Cart();
			cart.setUser(user);
			
			//add the cart
			
			assertEquals("Failed To Add Cart",true, userDao.addCart(cart));
			
			//add shipping addres for this user
			address = new Address();
			address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
			address.setAddressLineTwo("Near Kudrat Store");
			address.setCity("Mumbai");
			address.setState("Maharashtra");
			address.setCountry("India");
			address.setPostalCode("400001");
			//set shipping to true
			address.setShipping(true);
			
			//link it with the user
			address.setUserId(user.getId());
			
			assertEquals("Failed To Add shipping address",true, userDao.addAddress(address));
		}
		
		
	}*/
	
	
	/*@Test
	public void testAdd()
	{
		
		User user=new User();
		user.setFirstName("Ram");
		user.setLastName("Sharma");
		user.setEmail("ram@gmail.com");
		user.setContactNumber("98730000");
		user.setRole("USER");
		user.setPassword("1234");

		
		if(user.getRole().equals("USER"))
		{
			//create a cart for this user
			
			cart = new Cart();
			cart.setUser(user);
			
			//attach cart with the user
			user.setCart(cart);
				
		}
		
		//add the user
		assertEquals("Failed To Add user",true, userDao.addUser(user));
		
	}*/
	
	@Test
	public void testUpdateCart()
	{
		//fetch the user by its email
		user = userDao.getByEmail("ram@gmail.com");
		
		//get the cart of the user
		cart = user.getCart();
		
		cart.setGrandTotal(9765);
		cart.setCartLines(2);
		
		
		assertEquals("Failed To update the cart",true, userDao.updateCart(cart));
	}
	

}
