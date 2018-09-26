package com.home.furniturebackend.dao;

import java.util.List;

import com.home.furniturebackend.dto.Cart;
import com.home.furniturebackend.dto.CartLine;

public interface CartLineDao
{
	
	public CartLine get(int id);
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean delete(CartLine cartLine);
	public List<CartLine> listAll(int cartId);
	
	
	public List<CartLine> listAvailable(int cartId);
	public CartLine getByCartAndProduct(int cartId,int productId);
	
	
	public boolean updateCart(Cart cart);

}
