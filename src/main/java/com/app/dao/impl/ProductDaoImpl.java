package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IProductDao;
import com.app.model.Product;

@Repository
public class ProductDaoImpl implements IProductDao {
	@Autowired
	private HibernateTemplate ht;
	
	
	@Override
	public Integer saveProduct(Product p) {
		return (Integer) ht.save(p);
	}

	@Override
	public void deleteProduct(Integer id) {
		ht.delete(new Product(id));
	}

	@Override
	public List<Product> getAllProducts() {
		return ht.loadAll(Product.class);
	}

}
