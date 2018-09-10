package com.home.buyfurniture.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;



@ControllerAdvice
public class GloablDefaultExceptionHandler
{
		
	//if someone misusing your url and write there like string or id so this error occurs which come from web.xml 
	
	//this exception occur on all product url
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleNoFoundException()
	{
		
		ModelAndView mv=new ModelAndView("error");
		
		mv.addObject("errorTitle","this page is not construted");
		
		mv.addObject("errorDescription","this page you are looking is no there!!");
		
		mv.addObject("title","404 page");
		
		return mv;
	}
	
   //product not found exception class its a custom exception is someone writing in url
	//occur on single product writing numeric 
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleProductNotFoundException()
	{
		
		ModelAndView mv=new ModelAndView("error");
		
		mv.addObject("errorTitle","this product is not available!!");
		
		mv.addObject("errorDescription","this product you are looking is not available now!!");
		
		mv.addObject("title","Product Unavailable!!");
		
		return mv;
	}
	
//occur on single product writing string
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex)
	{
		
		ModelAndView mv=new ModelAndView("error");
		
		mv.addObject("errorTitle","Contact Your Administartor!!");
		
		/*
		 * only for debugging your application
		 * 
		 * 
		StringWriter sw=new StringWriter();
		PrintWriter pw=new PrintWriter(sw);
		
		ex.printStackTrace(pw);
		 */
		
		
		
		mv.addObject("errorDescription",ex.toString());
		
		mv.addObject("title","Error!!");
		
		return mv;
	}
	
	
	

}
