package com.jpaproject.jpaapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpaproject.jpaapplication.model.Category;
import com.jpaproject.jpaapplication.model.Product;
import com.jpaproject.jpaapplication.repository.CategoryRepo;

@RestController
public class CategoryContrller {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@PostMapping(value = "/savecategory")
	public String saveCategoty(@RequestBody Category category) {
		categoryRepo.save(category);
		
		return "category inserted";
	}
	
	
}
