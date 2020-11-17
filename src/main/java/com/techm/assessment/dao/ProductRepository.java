package com.techm.assessment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techm.assessment.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
