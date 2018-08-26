package com.home.buyfurniture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.home.furniturebackend.dao.CategoryDao;
import com.home.furniturebackend.dto.Category;
import com.home.furniturebackend.dto.Product;


@Controller
@RequestMapping(value="/manage")
public class ManagementController
{
	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public ModelAndView showManageProduct()
	{
		
		ModelAndView mv=new ModelAndView("page");
		
		mv.addObject("userClickManageProducts",true);
		mv.addObject("title","Manage Products");
		
		Product nProduct=new Product();
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		
		mv.addObject("product",nProduct);
		
		return mv;
		
	}
	
	@ModelAttribute("categories")
	public List<Category> listCategorie()
	{
		return categoryDao.listAll();
	}
	

}
