package com.home.furniturebackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.home.furniturebackend.dao.CategoryDao;
import com.home.furniturebackend.dto.Category;

public class CategoryTestCase 
{
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDao categoryDao;
	
	
	private Category category;
	
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.home.furniturebackend");
		context.refresh();
		
		categoryDao= (CategoryDao) context.getBean("categoryDao");
				
	}
	
	/*
	@Test
	public void testAddCategory()
	{
		category=new Category();
		category.setName("Machine");
		category.setDescription("machine dsec of my catgeory");
		category.setImageURL("imageurl.jpg");
		
		
		assertEquals("succsuflly added the category",true,categoryDao.add(category));
		
	}
	*/
	/*@Test
	public void testgetCategory()
	{
		category=categoryDao.get(1);
		
		assertEquals("succsuflly fetch the category from the table","Clothes",category.getName());
	}
	
	@Test
	public void testupdateCategory()
	{
		category=categoryDao.get(1);
		category.setName("TV");
		
		assertEquals("succsuflly update the category from the table",true,categoryDao.update(category));
	}
	
	@Test
	public void testDeleteCategory()
	{
		category=categoryDao.get(1);
		
		assertEquals("succsuflly delete single the category from the table",true,categoryDao.delete(category));
	}

	
	
	
	@Test
	public void testListCategory()
	{
		assertEquals("fetch List category from the table",1,categoryDao.listAll().size());
	}
*/
	@Test
	public void testCrudCategory()
	{
		//add operation 
		
		category=new Category();
		category.setName("Laptop");
		category.setDescription("Laptop dsec of my catgeory");
		category.setImageURL("image12.jpg");
		
		
		assertEquals("succsuflly added the category",true,categoryDao.add(category));
		
		category=new Category();
		category.setName("Fridge");
		category.setDescription("fridge dsec of my catgeory");
		category.setImageURL("imageurl.jpg");
		
		
		assertEquals("succsuflly added the category",true,categoryDao.add(category));
		
		//fetching nad updating the category
		category=categoryDao.get(1);
		category.setName("Washing");
		
		assertEquals("succsuflly update the category from the table",true,categoryDao.update(category));
		
		//delete the category
		assertEquals("succsuflly delete single the category from the table",true,categoryDao.delete(category));
		
		//fetching the list
		assertEquals("fetch List category from the table",1,categoryDao.listAll().size());
		
	}
	
	
	
}
