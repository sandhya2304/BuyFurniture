package com.home.furniturebackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.home.furniturebackend.dao.ProductDao;
import com.home.furniturebackend.dto.Product;

public class ProductTestCase
{
	private static AnnotationConfigApplicationContext context;
     
	private static ProductDao productDao;
	
	private Product product;
	
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.home.furniturebackend");
		context.refresh();
		productDao = (ProductDao) context.getBean("productDao");
	}
	
	/*@Test
	public void testCrudProduct()
	{
		//create operation
		product=new Product();
		product.setName("oppo Selfie");
		product.setBrand("oppo");
		product.setDescription("new oppo phones");
		product.setUnitPrice(23000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		
		assertEquals("Somethong went wrong insert new prodcut",true,productDao.addProduct(product));
		
		//reading and update product
		product = productDao.get(1);
		product.setName("Samsung");
		
		assertEquals("Somethong went wrong update prodcut",true,productDao.updateProduct(product));
		
		//delete
		//assertEquals("Somethong went wrong delete prodcut",true,productDao.deleteProduct(product));
		
		//list
		assertEquals("Somethong went wrong Listing the product",9,productDao.listAll().size());
		
	}
	*/
	
/*	@Test
	public void listActiveProduct()
	{
		assertEquals("Somethong went wrong Listing the active product",8,productDao.listActiveProducts().size());
	}
	*/
	
	/*@Test
	public void listActiveProductByCategory()
	{
		assertEquals("Somethong went wrong Listing the active product by category",6,productDao.listActiveProductByCategory(3).size());
		
		
		assertEquals("Somethong went wrong Listing the active product by category",2,productDao.listActiveProductByCategory(1).size());
	}
	*/
	
	@Test
	public void testLatestActiveProduct()
	{
		
		assertEquals("Somethong went wrong Latest the active product",3,productDao.getLatestActiveProducts(3).size());
		
	}
	
	
	
	
}
