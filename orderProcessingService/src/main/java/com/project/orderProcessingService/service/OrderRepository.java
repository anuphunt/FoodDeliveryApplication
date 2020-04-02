package com.project.orderProcessingService.service;

import com.project.orderProcessingService.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	Order findByFoodname(String foodname);
}
