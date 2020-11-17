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

import com.techm.assessment.model.Product;
import com.techm.assessment.service.ProductService;

@RestController
@RequestMapping("/Product")
public class ProductController {

	@Autowired
	ProductService service;
	
	

	@GetMapping
	private List<Product> getProducts() {
		List<Product> Productlist=service.getProducts();
		return Productlist;
	}

	// Single item
	@GetMapping("/{id}")
	Optional<Product> getProduct(@PathVariable Long id) {
		Optional<Product> Product=	service.getProduct(id);
		return Product;
	}

	@PostMapping
	private ResponseEntity<Product> saveProduct(@RequestBody Product Product) {
		Product Productobj=service.saveProduct(Product);
		return new ResponseEntity<Product>(Productobj, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	Product updateProduct(@RequestBody Product newProduct, @PathVariable Long id) {
		Product Productobj1=service.updatedProduct(newProduct, id);
		return Productobj1;
	}

	@DeleteMapping("/{id}")
	void deleteProduct(@PathVariable Long id) {
		service.deleteProduct(id);
	}
}
