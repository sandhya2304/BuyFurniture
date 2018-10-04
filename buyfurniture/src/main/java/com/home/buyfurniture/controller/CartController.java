package com.home.buyfurniture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.home.buyfurniture.service.CartService;

@Controller
@RequestMapping(value="/cart")
public class CartController 
{
	
	@Autowired
	private CartService cartService;
	
	
	@RequestMapping(value="/show")
	public ModelAndView showCart(@RequestParam(name="result",required=false)String result)
	{
		ModelAndView mv=new ModelAndView("page");
		
		if(result!=null)
		{
			switch (result) 
			{
			    case "updated": mv.addObject("message","cartline has updated!!!");				    
				break;
				
			    case "error": mv.addObject("message","Something went wrong!!!!");				    
				break;
			}
			
		}
		
		mv.addObject("title","User Cart");
		mv.addObject("clickOnShowCart",true);
		mv.addObject("cartLines",cartService.getCartLines());
		
		return mv;
	}
	
	@RequestMapping(value="/{cartLineId}/update")
	public String updateCart(@PathVariable int cartLineId,@RequestParam int count)
	{
		String response = cartService.updateCartLine(cartLineId,count);
		
		return "redirect:/cart/show?"+response;
	}

}
