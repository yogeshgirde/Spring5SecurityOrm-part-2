package com.app.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.model.User;
import com.app.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService service;
	
	//1. show User Register Page
	@RequestMapping("/register")
	public String showReg(ModelMap map) {
		//from backing object
		map.addAttribute("user", new User());
		return "UserRegister";
	}
	
	//2. save User , read modelattribute
	@RequestMapping(value="/save",method=POST)
	public String saveUser(
			@ModelAttribute User user,ModelMap map) 
	{
	   //call service layer and save
		Integer id=service.saveUser(user);
		//construct message and send to ui
		String message="User saved with '"+id+"' successfully";
		map.addAttribute("message", message);
		//clean form backing object
		map.addAttribute("user", new User());
		return "UserRegister";
	}
	
}