package com.techm.assessment.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.assessment.dao.ProductRepository;
import com.techm.assessment.model.Product;

@Service
public class ProductService {

	@Autowired
	ProductRepository repo;
	
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Optional<Product> getProduct(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	public Product saveProduct(Product Product) {
		Product p=new Product();
		BeanUtils.copyProperties(Product, p);
		p.setCreatedBy("Dileep");
		p.setCreatedDate(new Date());
		return repo.save(p);
	}

	public Product updatedProduct(Product newProduct, Long id) {
		return repo.findById(id).map(Product -> {
			Product.setId(id);
			Product.setName(newProduct.getName());
			Product.setCost(newProduct.getCost());
			Product.setBrand(newProduct.getBrand());
			Product.setImagepath(newProduct.getImagepath());
			Product.setLastUpdatedBy("Dileep");
			Product.setModifiedDate(new Date());
			return repo.save(Product);
		}).orElseGet(() -> {
			return repo.save(newProduct);
		});
	}

	public void deleteProduct(Long id) {
		// TODO Auto-generated method stub
		
		repo.deleteById(id);
	}
}
