package com.home.buyfurniture.model;

import com.home.furniturebackend.dto.Address;
import com.home.furniturebackend.dto.User;

public class RegisterModel
{
	
	private User user;
	private Address address;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}


}
