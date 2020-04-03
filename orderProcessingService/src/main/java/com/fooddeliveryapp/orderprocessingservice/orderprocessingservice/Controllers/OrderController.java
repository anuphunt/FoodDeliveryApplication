package com.fooddeliveryapp.orderprocessingservice.orderprocessingservice.Controllers;

import com.fooddeliveryapp.orderprocessingservice.orderprocessingservice.models.Order;
import com.fooddeliveryapp.orderprocessingservice.orderprocessingservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping(path = "/{id}")
    public Optional<Order> getById(@PathVariable String id){
        return orderRepository.findById(id);
    }

    @RequestMapping(value = "/newOrder", method = RequestMethod.POST)
    public Order addNewOrder(@RequestBody Order order){
        return orderRepository.insert(order);
    }

    @GetMapping(path = "/all")
    public Iterable<Order> getAll(){
        return orderRepository.findAll();
    }
}
