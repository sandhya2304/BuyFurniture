package com.home.buyfurniture.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.home.buyfurniture.exception.ProductNotFoundException;
import com.home.furniturebackend.dao.*;
import com.home.furniturebackend.dto.Category;
import com.home.furniturebackend.dto.Product;

@Controller
public class PageController 
{
	
	private static final Logger logger=LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDao categoryDao;
	
	
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping(value={"/", "/home" , "/index"})
	public ModelAndView index()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","home");
		
		logger.info("Inside page controller index -INFO");
		
		logger.debug("Inside page controller index -DEBUG");
		
		//passing the list of categories
		mv.addObject("categories",categoryDao.listAll());
		
		mv.addObject("userClickHome",true);
		
		return mv;
		
	}
	
	@RequestMapping(value="/about")
	public ModelAndView about()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout",true);
		
		return mv;
		
	}
	
	@RequestMapping(value="/contact")
	public ModelAndView contact()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","Contact Us");
		mv.addObject("userClickContact",true);
		
		return mv;
		
	}
	
	/*
	 * Methods to load all products and based on category
	 */
	
	@RequestMapping(value="/show/all/products")
	public ModelAndView showAllProducts()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","All Products");
		
		//passing the list of categories
		mv.addObject("categories",categoryDao.listAll());
		
		mv.addObject("userClickAllProducts",true);
		
		return mv;
		
	}
	
	/*
	 * Methods to load all products and based on category id
	 */
	
	@RequestMapping(value="/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id)
	{
		ModelAndView mv=new ModelAndView("page");
		
		//catgeory Dao to fetch single category
		
		Category category=null;
		
		category=categoryDao.get(id);
		
		mv.addObject("title",category.getName());
		
		//passing the list of categories
		mv.addObject("categories",categoryDao.listAll());
		
		
		//passing the single category object
		
		mv.addObject("category",category);
		
		mv.addObject("userClickCategoryProducts",true);
		
		return mv;
		
	}
	
	/*
	 * View Single Product
	 */
	@RequestMapping(value="/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException
	{
		ModelAndView mv=new ModelAndView("page");
		
		Product product=productDao.get(id);
		
		if(product == null)throw new ProductNotFoundException();
		
		//update the view count
		product.setViews(product.getViews() +1);
		productDao.updateProduct(product);
		
		mv.addObject("title",product.getName());
		mv.addObject("product",product);
		
		mv.addObject("userClickShowProduct",true);
		
		
		return mv;
	}
	
	//similar mapping to our flow id
	@RequestMapping(value="/register")
	public ModelAndView register()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout",true);
		
		return mv;
		
	}
	
	// login page
	@RequestMapping(value="/login")
	public ModelAndView login(@RequestParam(name="error",required=false)String error,
			@RequestParam(name="logout",required=false)String logout
			)
	{
		ModelAndView mv=new ModelAndView("login");
		
		if(error!=null)
		{
			mv.addObject("message","Invalid username and password");
		}
		
		if(logout!=null)
		{
			mv.addObject("logout","User has successfully logout!!! :) ");
		}
		mv.addObject("title","Login ");
	
		return mv;
		
	}
	
	
	//access denied
		@RequestMapping(value="/access-denied")
		public ModelAndView accessdenied()
		{
			ModelAndView mv=new ModelAndView("error");
			mv.addObject("title","403 - Access Denied");
			mv.addObject("errorTitle","Aha..Caught you :)");
			mv.addObject("errorDescription","You are not authorize to view this page!!");
			
			return mv;
			
		}
		
	/*
	 * logout
	 */
		@RequestMapping(value="/perofrm-logout")
		public String logout(HttpServletRequest request,HttpServletResponse response)
		{
			//first we are going to fetch the authentication
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			
			if(auth!=null)
			{
				new SecurityContextLogoutHandler().logout(request, response, auth);
			}
			
			
			return "redirect:/login?logout";
			
		}
		

	
}
