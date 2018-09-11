package com.home.furniturebackend.dao;

import com.home.furniturebackend.dto.Address;
import com.home.furniturebackend.dto.Cart;
import com.home.furniturebackend.dto.User;

public interface UserDao
{
	
	public boolean addUser(User user);
	
	public boolean addAddress(Address address);
	
	public boolean addCart(Cart cart);
	

}
