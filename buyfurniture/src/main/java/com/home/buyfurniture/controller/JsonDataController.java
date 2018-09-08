package com.home.buyfurniture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import com.home.furniturebackend.dao.ProductDao;
import com.home.furniturebackend.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

	@Autowired
	private ProductDao productDao;

	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts() {
		return productDao.listActiveProducts();
	}
	
	

	@RequestMapping("/admin/all/products")
	@ResponseBody
	public List<Product> getAllProductsforAdmin() {
		return productDao.listAll(); 
	}

	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getAllProducts(@PathVariable int id) {
		return productDao.listActiveProductByCategory(id);
	}

}
