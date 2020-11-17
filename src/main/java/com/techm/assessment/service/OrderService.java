package com.techm.assessment.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.assessment.dao.OrderRepository;
import com.techm.assessment.model.Order;

@Service
public class OrderService {

	@Autowired
	OrderRepository repo;
	
	
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Optional<Order> getOrder(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	public Order saveOrder(Order Order) {
		Order o=new Order();
		BeanUtils.copyProperties(Order, o);
		o.setCreatedBy("Dileep");
		o.setCreatedDate(new Date());
		return repo.save(o);
	}

	public Order updatedOrder(Order newOrder, Long id) {
		return repo.findById(id).map(Order -> {
			Order.setId(id);
			Order.setDeliveryStatus(newOrder.getDeliveryStatus());
			Order.setPaymentStatus(newOrder.getPaymentStatus());
			Order.setUserId(newOrder.getUserId());
			Order.setProductId(newOrder.getProductId());
			Order.setLastUpdatedBy("Dileep");
			Order.setModifiedDate(new Date());
			return repo.save(Order);
		}).orElseGet(() -> {
			return repo.save(newOrder);
		});
	}

	public void deleteOrder(Long id) {
		// TODO Auto-generated method stub
		
		repo.deleteById(id);
	}

	
}
