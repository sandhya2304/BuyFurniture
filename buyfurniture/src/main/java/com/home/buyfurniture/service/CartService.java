package com.home.buyfurniture.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.buyfurniture.model.UserModel;
import com.home.furniturebackend.dao.CartLineDao;
import com.home.furniturebackend.dto.Cart;
import com.home.furniturebackend.dto.CartLine;
import com.home.furniturebackend.dto.Product;



@Service("cartService")
public class CartService 
{
	@Autowired
	CartLineDao cartLineDao;
	
	
	@Autowired
	HttpSession httpSession;
	
	
	//return the cart of the user who has logged in //fetch cart of the user from the session
	public Cart getCart()
	{
		return ((UserModel)httpSession.getAttribute("userModel")).getCart();
	}
	
	
	//return the entire cartLine //fetch the cartLine form the database
	public List<CartLine> getCartLines()
	{ 
		//Cart cart = this.getCart();	or write in	below one line
		return cartLineDao.listAll(this.getCart().getId());
	}


	public String updateCartLine(int cartLineId, int count)
	{
	
		//fetch the cartline
		CartLine cartLine = cartLineDao.get(cartLineId);
		
		if(cartLine == null)
		{
			return "result=error";
		}
		else
		{
			Product product = cartLine.getProduct();
			
			double oldTotal = cartLine.getTotal();
			
			if(product.getQuantity() <= count)
			{
				count = product.getQuantity();
			}
			cartLine.setProductCount(count);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setTotal(product.getUnitPrice() * count);
			
			cartLineDao.update(cartLine);
			Cart cart = this.getCart();
			
			cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());
			cartLineDao.updateCart(cart);
			
			
			return "result=updated";
			
		}
		
	}
	
	

}
