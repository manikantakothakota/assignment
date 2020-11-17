package com.techm.assessment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techm.assessment.model.Category;
import com.techm.assessment.service.CatagoryService;

@RestController
@RequestMapping("/Category")
public class CategoryController {

	
	@Autowired
	CatagoryService service;
	

	@GetMapping
	private List<Category> getCategorys() {
		List<Category> Categorylist=service.getCategorys();
		return Categorylist;
	}

	// Single item
	@GetMapping("/{id}")
	Optional<Category> getCategory(@PathVariable Long id) {
		Optional<Category> Category=	service.getCategory(id);
		return Category;
	}

	@PostMapping
	private ResponseEntity<Category> saveCategory(@RequestBody Category Category) {
		Category Categoryobj=service.saveCategory(Category);
		return new ResponseEntity<Category>(Categoryobj, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	Category updateCategory(@RequestBody Category newCategory, @PathVariable Long id) {
		Category Categoryobj1=service.updatedCategory(newCategory, id);
		return Categoryobj1;
	}

	@DeleteMapping("/{id}")
	void deleteCategory(@PathVariable Long id) {
		service.deleteCategory(id);
	}
}
