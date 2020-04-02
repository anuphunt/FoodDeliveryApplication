package com.project.orderProcessingService.controller;

import com.project.orderProcessingService.model.Order;
import com.project.orderProcessingService.service.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepo;

	@PostMapping("/register")
	public Order register(@RequestBody Order order) {
		orderRepo.save(order);
		return order;
	}

}
