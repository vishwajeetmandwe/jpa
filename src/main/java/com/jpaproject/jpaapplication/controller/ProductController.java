package com.jpaproject.jpaapplication.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpaproject.jpaapplication.model.Category;
import com.jpaproject.jpaapplication.model.Product;
import com.jpaproject.jpaapplication.repository.CategoryRepo;
import com.jpaproject.jpaapplication.repository.ProductRepo;

@RestController
public class ProductController {

	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private CategoryRepo categoryRepo;

	@PostMapping(value = "/savedata")
	public String saveProduct(@RequestBody Product product) {

		Optional<Category> c = categoryRepo.findById(product.getCategory().getCategoryId());
		if (c.isPresent()) {
		} else {
			categoryRepo.save(product.getCategory());
		}
		productRepo.save(product);
		return "Data saved";
	}

	@GetMapping(value = "/getalldata")
	public List<Product> getProduct() {
		return productRepo.findAll();
	}

	@PostMapping(value = "/updatedata")
	public String updateProduct(@RequestBody Product product) {

		Optional<Product> p = productRepo.findById(product.getProductId());

		if (p.isPresent()) {
			if (product.getProductName() != null)
				p.get().setProductName(product.getProductName());
			if (product.getPrice() != null)
				p.get().setPrice(product.getPrice());
			if (product.getProductDesc() != null)
				p.get().setProductDesc(product.getProductDesc());
		}
		productRepo.save(p.get());
		return "record updated";
	}

	@GetMapping(value = "/getbyid/{id}")
	public Map<String, Object> getProductById(@PathVariable Integer id) {
		return productRepo.findByProductId(id);
	}

	@GetMapping(value = "/getjoins")
	public List<Map<String, Object>> findByJoin(){
		return productRepo.finndByJoin();
	}
}
