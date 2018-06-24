package com.home.buyfurniture.dao;

import java.util.List;

import com.home.buyfurniture.dto.Category;

public interface CategoryDao 
{
	
	public List<Category> listAll();
	
	public Category get(int id);

}
