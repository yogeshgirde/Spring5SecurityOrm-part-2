package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Product;
import com.app.service.IProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private IProductService service;
	
	//1. show Register Page
	@RequestMapping("/register")
	public String showPage(ModelMap map) {
		map.addAttribute("product", new Product());
		return "ProductRegister";
	}
	
	
	//2. on click save data
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveData(@ModelAttribute Product product,ModelMap map) {
		//call service
		Integer id=service.saveProduct(product);
		//send message to UI
		map.addAttribute("message", "Product '"+id+"' saved successfully");
		//clean form backing object
		map.addAttribute("product", new Product());
		return "ProductRegister";
	}
	
	
	//3. display data
	@RequestMapping("/all")
	public String getAll(ModelMap map) {
		List<Product> list=service.getAllProducts();
		map.addAttribute("list",list);
		return "ProductData";
	}
	
	
	//4. delete and get new data
	@RequestMapping("/delete")
	public String deleteProd(@RequestParam Integer id,ModelMap map) {
		//delete row based on Id
		service.deleteProduct(id);
		map.addAttribute("message", "Product '"+id+"' Deleted successfully");
		//fetch new data
		List<Product> list=service.getAllProducts();
		map.addAttribute("list",list);
		return "ProductData";
	}
	
	
	
	
	
	
	
	
}
