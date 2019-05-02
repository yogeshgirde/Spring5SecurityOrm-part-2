package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.model.User;
import com.app.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private IUserDao dao;
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	
	@Transactional
	public Integer saveUser(User user) {
		//read pwd
		String pwd=user.getUserPwd();
		//encode pwd
		String encPwd=pwdEncoder.encode(pwd);
		//set back enc Pwd to user
		user.setUserPwd(encPwd);
		return dao.saveUser(user);
	}
	
}
