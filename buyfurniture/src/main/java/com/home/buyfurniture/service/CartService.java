package com.home.buyfurniture.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.buyfurniture.model.UserModel;
import com.home.furniturebackend.dao.CartLineDao;
import com.home.furniturebackend.dao.ProductDao;
import com.home.furniturebackend.dto.Cart;
import com.home.furniturebackend.dto.CartLine;
import com.home.furniturebackend.dto.Product;



@Service("cartService")
public class CartService 
{
	@Autowired
	CartLineDao cartLineDao;
	
	@Autowired
	ProductDao productDao;
	
	
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


	public String manageCartLine(int cartLineId, int count)
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
			
			
			//check if the product is available
			if(product.getQuantity() <= count)
			{
				return "result=unavailable";
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


	public String deleteCartLine(int cartLineId)
	{
		//fetch the cartline
		
				CartLine cartLine=cartLineDao.get(cartLineId);
				
				if(cartLine==null)
				{
					return "result=error";
				}
				
				//update the cart
				
				Cart cart=this.getCart();
				cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
				cart.setCartLines(cart.getCartLines() -1);
				
				cartLineDao.updateCart(cart);
				
				
				//remove the cartLine
				cartLineDao.delete(cartLine);
				
				
				return "result=deleted";
			
		}
		



	public String addCartLine(int productId)
	{
		String response = null;
		Cart cart = this.getCart(); 
		CartLine cartLine = cartLineDao.getByCartAndProduct(cart.getId(), productId);
		
		if(cartLine == null)
		{
			//add a new cartLine
			cartLine = new CartLine();
			
			//fetch the product
			Product product = productDao.get(productId);
			
			cartLine.setCartId(cart.getId());
			cartLine.setProduct(product);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setProductCount(1);
			cartLine.setTotal(product.getUnitPrice());
            cartLine.setAvailable(true);
            
            cartLineDao.add(cartLine);
            
            cart.setCartLines(cart.getCartLines() + 1);
			cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
			cartLineDao.updateCart(cart);
			
			
			return "result=added";
			
		}
		else
		{
			
			//check if cartline reached maximum 3
			
			if(cartLine.getProductCount() < 3)
			{
				//update the product count for that cartline
				response = this.manageCartLine(cartLine.getId(),cartLine.getProductCount() +1);
				
			}
			else
			{
				response = "result=maximum";
			}
			
			
		}
		return response;
		
		
	}
	
	

}
