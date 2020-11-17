package com.techm.assessment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techm.assessment.model.Category;

public interface CategoryRespository extends JpaRepository<Category, Long>{

}
