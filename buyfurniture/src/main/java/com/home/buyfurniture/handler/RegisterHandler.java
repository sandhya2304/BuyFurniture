package com.home.buyfurniture.handler;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.home.buyfurniture.model.RegisterModel;
import com.home.furniturebackend.dao.UserDao;
import com.home.furniturebackend.dto.Address;
import com.home.furniturebackend.dto.Cart;
import com.home.furniturebackend.dto.User;

@Component
public class RegisterHandler implements Serializable
{
	@Autowired
	private UserDao userDao;
	
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
	
	public String saveAll(RegisterModel model)
	{
		String transitionValue = "success";
		
		//fetch the user
		
		User user = model.getUser();
		
		if(user.getRole().equals("USER"))
		{
			Cart cart =new Cart();
			cart.setUser(user);
			user.setCart(cart);			
		}
		
		//save the user
		userDao.addUser(user);
		
		//get the address
		
		Address billing =model.getBilling();
		billing.setUser(user);
		billing.setBilling(false);
		
		
		//save the address
		userDao.addAddress(billing);
		
		return transitionValue;
	}
	
	//custom validation
	public String validateUser(User user,MessageContext error)
	{
		String transitionValue="success";
		
		
		if(!(user.getPassword().equals(user.getConfirmPassword())))
		{
			
			error.addMessage(new MessageBuilder()
					.error()
					.source("confirmPassword")
					.defaultText("password does not matxh to confirm password!!")
					.build()
					);
			
			transitionValue ="failure";
			
		}
		
		//check the uniqness email id
		
		if(userDao.getByEmail(user.getEmail())!=null)
		{
			
			error.addMessage(new MessageBuilder()
					.error()
					.source("email")
					.defaultText("email already used!!")
					.build()
					);
			
			
			transitionValue ="failure";
		}
		
		
		return transitionValue;
	}
	

}
