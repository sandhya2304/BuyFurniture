package com.home.buyfurniture.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.home.buyfurniture.util.FileUplaodUtility;
import com.home.furniturebackend.dao.CategoryDao;
import com.home.furniturebackend.dao.ProductDao;
import com.home.furniturebackend.dto.Category;
import com.home.furniturebackend.dto.Product;


@Controller
@RequestMapping(value="/manage")
public class ManagementController
{
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ProductDao productDao;
	
	
	private static final Logger logger=LoggerFactory.getLogger(ManagementController.class);
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public ModelAndView showManageProduct(@RequestParam(name="operation",required=false)String operation)
	{
		
		ModelAndView mv=new ModelAndView("page");
		
		mv.addObject("userClickManageProducts",true);
		mv.addObject("title","Manage Products");
		
		Product nProduct=new Product();
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		
		mv.addObject("product",nProduct);
		
		/*
		 * for displaying message after submitting 
		 */
		if(operation!=null)
		{
			if(operation.equals("product"))
			{
				mv.addObject("message","Product Submitted Successfully!!!");
			}
			
		}
		
		
		return mv;
		
	}
	/*
	 * handling product submission
	 * for save product
	 */
	
	@RequestMapping(value="/products",method=RequestMethod.POST)   
	public String handleProductSubmission(@Valid @ModelAttribute("product")Product mPRoduct,BindingResult results,
		             	Model model,HttpServletRequest request)
	{
		// to pass any data we use model here and here we user server side validation
		//check if there are any errors
		if(results.hasErrors())
		{

			model.addAttribute("userClickManageProducts",true);
			model.addAttribute("title","Manage Products");
			model.addAttribute("message","validation fields for product submission");
			
			
			return "page";
		}
		
		logger.info(mPRoduct.toString());
		
		//create a new Product
		productDao.addProduct(mPRoduct);
		
		
		if(!mPRoduct.getFile().getOriginalFilename().equals(""))
		{
			
			FileUplaodUtility.uploadFile(request,mPRoduct.getFile(),mPRoduct.getCode());
			
		}
		
		
		
		return "redirect:/manage/products?operation=product";
	}
	
	// for displaying all categories from database
	@ModelAttribute("categories")
	public List<Category> listCategorie()
	{
		return categoryDao.listAll();
	}
	

}
