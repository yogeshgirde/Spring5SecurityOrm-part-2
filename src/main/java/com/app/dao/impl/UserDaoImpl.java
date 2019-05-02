package com.app.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUserDao;
import com.app.model.User;

@Repository
public class UserDaoImpl implements IUserDao{
	@Autowired
	private HibernateTemplate ht;
	
	public Integer saveUser(User user) {
		return (Integer)ht.save(user);
	}
	
	
	
	
	
	
}
