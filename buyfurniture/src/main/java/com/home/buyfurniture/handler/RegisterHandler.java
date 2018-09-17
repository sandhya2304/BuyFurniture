package com.home.buyfurniture.handler;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.home.buyfurniture.model.RegisterModel;
import com.home.furniturebackend.dto.Address;
import com.home.furniturebackend.dto.User;

@Component
public class RegisterHandler implements Serializable
{
	
	public RegisterModel init()
	{
		return new RegisterModel();
	}
	
	
	public void addUser(RegisterModel registerModel,User user)
	{
		registerModel.setUser(user);
	}
	
	public void addBilling(RegisterModel registerModel,Address billing)
	{
		registerModel.setBilling(billing);
	}


}
