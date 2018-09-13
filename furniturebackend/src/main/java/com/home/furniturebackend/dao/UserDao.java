package com.home.furniturebackend.dao;

import java.util.List;

import com.home.furniturebackend.dto.Address;
import com.home.furniturebackend.dto.Cart;
import com.home.furniturebackend.dto.User;

public interface UserDao
{
	
	public boolean addUser(User user);
	
	public boolean addAddress(Address address);
	
	//single address
	public Address getBillingAddress(User user);
	
	List<Address> listShippingAddress(User user);  //list shipping address for a user 
	
	public boolean updateCart(Cart cart);
	
	public User getByEmail(String email);
	

}
