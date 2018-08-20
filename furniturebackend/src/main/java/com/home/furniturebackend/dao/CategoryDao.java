package com.home.furniturebackend.dao;

import java.util.List;

import com.home.furniturebackend.dto.Category;

public interface CategoryDao 
{
		
	public List<Category> listAll();
	
	public Category get(int id);
	
	public boolean add(Category category);
	public boolean update(Category category);
	public boolean delete(Category category);
	
	

}
