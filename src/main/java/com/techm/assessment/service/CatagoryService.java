package com.techm.assessment.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.assessment.dao.CategoryRespository;
import com.techm.assessment.model.Category;

@Service
public class CatagoryService {

	@Autowired
	CategoryRespository repo;

	public List<Category> getCategorys() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Optional<Category> getCategory(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	public Category saveCategory(Category Category) {
		Category c=new Category();
		BeanUtils.copyProperties(Category, c);
		c.setCreatedBy("Dileep");
		c.setCreatedDate(new Date());
		return repo.save(c);
	}

	public Category updatedCategory(Category newCategory, Long id) {
		return repo.findById(id).map(Category -> {
			Category.setId(id);
			Category.setParentCategory(newCategory.getParentCategory());
			Category.setLastUpdatedBy("Dileep");
			Category.setModifiedDate(new Date());
			return repo.save(Category);
		}).orElseGet(() -> {
			return repo.save(newCategory);
		});
	}

	public void deleteCategory(Long id) {
		
		repo.deleteById(id);
	}
	
}
