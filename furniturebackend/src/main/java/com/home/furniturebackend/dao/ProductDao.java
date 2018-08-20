package com.home.furniturebackend.dao;

import java.util.List;

import com.home.furniturebackend.dto.Product;

public interface ProductDao 
{
	
	Product get(int productId);
	List<Product> listAll();
	
	boolean addProduct(Product p);
	boolean deleteProduct(Product p);
	boolean updateProduct(Product p);
	
	
	//business methods
	List<Product> listActiveProducts();
	List<Product> listActiveProductByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
	
	
}
