package com.app.service;

import java.util.List;

import com.app.model.Product;

public interface IProductService {

	public Integer saveProduct(Product p);
	public void deleteProduct(Integer id);
	
	public List<Product> getAllProducts();
}
