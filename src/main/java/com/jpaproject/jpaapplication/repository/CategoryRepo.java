package com.jpaproject.jpaapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpaproject.jpaapplication.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
