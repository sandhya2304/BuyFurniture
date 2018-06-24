package com.home.buyfurniture.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.home.buyfurniture.dao.CategoryDao;
import com.home.buyfurniture.dto.Category;


@Repository("categoryDao")
public class CategoryDAOImpl implements CategoryDao
{
	
	public static  List<Category> categories=new ArrayList<Category>();
	
	
	static
	{
		Category category1=new Category(1,"clothes", "description", "imageURL",true);
		
		Category category2=new Category(2,"machine", "description", "imageURL",true);
		
		Category category3=new Category(3,"television", "description", "imageURL",true);
		
		Category category4=new Category(4,"electronic", "description", "imageURL",true);
		
		Category category5=new Category(5,"vehicles", "description", "imageURL",true);
		
		
		categories.add(category1);categories.add(category2);
		categories.add(category3);categories.add(category4);
		categories.add(category5);
		
	}

	public List<Category> listAll() {
		
		return categories;
	}

	public Category get(int id) {
	   
		for(Category cat:categories)
		{
			if(cat.getId()==id) return cat;
		}
		
		
		return null;
	}
	

}
