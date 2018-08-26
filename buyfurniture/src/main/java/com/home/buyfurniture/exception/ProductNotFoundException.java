package com.home.buyfurniture.exception;

import java.io.Serializable;

public class ProductNotFoundException extends Exception implements Serializable
{
	
	String message;
	
	
	public ProductNotFoundException()
	{
		this("Product Not Found!!!");
	}
	
	
	public ProductNotFoundException(String message)
	{
		this.message = System.currentTimeMillis() + ": " +message; 
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	

}
