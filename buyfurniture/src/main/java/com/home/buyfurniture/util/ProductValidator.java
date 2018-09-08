package com.home.buyfurniture.util;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.home.furniturebackend.dto.Product;

public class ProductValidator implements Validator
{

	public boolean supports(Class<?> clazz) {
		return Product.class.equals(clazz);
	}

	public void validate(Object target, Errors errors)
	{
		Product product= (Product)target;
		
		//whether file has been selected or not
		if(product.getFile() == null || product.getFile().getOriginalFilename().equals(""))
		{
			
			errors.rejectValue("file",null,"Please upload the image file");
			return;
		}
		
		// for file extension not match
		if(!(product.getFile().getContentType().equals("image/jpeg") ||
				product.getFile().getContentType().equals("image/png")||	
				product.getFile().getContentType().equals("image/gif")
			))
		{
		   	
			errors.rejectValue("file",null,"Please use only image file for uplaod!!!"); 
			return; 
		}
		
		
		
	}
	
	
	

}
