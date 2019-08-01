package com.jpaproject.jpaapplication.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jpaproject.jpaapplication.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{
	
	@Query(value = "select p.product_name, p.price from product p  where p.product_id = ?1", nativeQuery=true)
	Map<String, Object> findByProductId(Integer productId);

	@Query(value = "select p.product_id, p.product_name, p.price,c.category_id,c.category_name from product p, category c where p.category_id = c.category_id", nativeQuery = true)
	List<Map<String, Object>> finndByJoin();
}
