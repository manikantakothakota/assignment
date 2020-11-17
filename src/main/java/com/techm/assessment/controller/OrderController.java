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

import com.techm.assessment.model.Order;
import com.techm.assessment.service.OrderService;

@RestController
@RequestMapping("/Order")
public class OrderController {

	
	@Autowired
	OrderService service;
	

	@GetMapping
	private List<Order> getOrders() {
		List<Order> Orderlist=service.getOrders();
		return Orderlist;
	}

	// Single item
	@GetMapping("/{id}")
	Optional<Order> getOrder(@PathVariable Long id) {
		Optional<Order> Order=	service.getOrder(id);
		return Order;
	}

	@PostMapping
	private ResponseEntity<Order> saveOrder(@RequestBody Order Order) {
		Order Orderobj=service.saveOrder(Order);
		return new ResponseEntity<Order>(Orderobj, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	Order updateOrder(@RequestBody Order newOrder, @PathVariable Long id) {
		Order Orderobj1=service.updatedOrder(newOrder, id);
		return Orderobj1;
	}

	@DeleteMapping("/{id}")
	void deleteOrder(@PathVariable Long id) {
		service.deleteOrder(id);
	}
}
