package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IProductDao;
import com.app.model.Product;
import com.app.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	private IProductDao dao;
	
	
	@Transactional
	public Integer saveProduct(Product p) {
		return dao.saveProduct(p);
	}

	@Transactional
	public void deleteProduct(Integer id) {
		dao.deleteProduct(id);
	}

	@Transactional(readOnly = true)
	public List<Product> getAllProducts() {
		return dao.getAllProducts();
	}

}
