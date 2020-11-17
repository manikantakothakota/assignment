package com.techm.assessment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techm.assessment.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
