package com.home.buyfurniture.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.home.buyfurniture.model.UserModel;
import com.home.furniturebackend.dao.UserDao;
import com.home.furniturebackend.dto.User;

/*
 * 
 * this controller is accessible by all controller
 */


@ControllerAdvice
public class GlobalController
{
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserDao userDao;
	
	
	private UserModel userModel = null;
	
	@ModelAttribute("userModel")
	public UserModel getuserModel()
	{
		
		if(session.getAttribute("userModel") == null)
		{
			
			//add the user model
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
			User user = userDao.getByEmail(authentication.getName());
			
			if(user!=null)
			{
				
				//create a new user model object to pass the user details
				
				userModel = new UserModel();
				userModel.setEmail(user.getContactNumber());
				userModel.setRole(user.getRole());
				userModel.setFullName(user.getFirstName()+" " +user.getLastName());
				
				if(userModel.getRole().equals("USER"))
				{
					//set the cart if the user is buyer
					userModel.setCart(user.getCart());
				}
				
				//set the usermodal in the session
				
				session.setAttribute("userModel",userModel);
				
				return userModel;
				
			}
			
			
		}
		
		
		return (UserModel)session.getAttribute("userModel");
		
	}
	
	
	

}
