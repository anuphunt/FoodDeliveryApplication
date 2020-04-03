package com.fooddeliveryapp.orderprocessingservice.orderprocessingservice.Controllers;

import com.fooddeliveryapp.orderprocessingservice.orderprocessingservice.Exceptions.OrderNotFoundException;
import com.fooddeliveryapp.orderprocessingservice.orderprocessingservice.models.Order;
import com.fooddeliveryapp.orderprocessingservice.orderprocessingservice.models.OrderState;
import com.fooddeliveryapp.orderprocessingservice.orderprocessingservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping(path = "/{id}")
    public Optional<Order> getById(@PathVariable String id) {
        return orderRepository.findById(id);
    }

    @RequestMapping(value = "/neworder", method = RequestMethod.POST)
    public Order addNewOrder(@RequestBody Order order) {
        order.setModifiedBy(order.getCustomerId());
        return orderRepository.save(order);
    }

    @GetMapping(path = "/all")
    public Iterable<Order> getAll() {
        return orderRepository.findAll();
    }

    //All order of specific customer
    @RequestMapping(path = "/customers/{customerId}", method = RequestMethod.GET)
    private Iterable<Order> getAllOrdersOfCustomer(@PathVariable int customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    //All order of specific restaurant
    @RequestMapping(path = "/customers/{restaurantId}", method = RequestMethod.GET)
    private Iterable<Order> getAllOrdersOfRestaurant(@PathVariable int restaurantId) {
        return orderRepository.findByRestaurantId(restaurantId);
    }

    //All active orders of a customer
    @RequestMapping(path = "/customers/active/{customerId}", method = RequestMethod.GET)
    private Iterable<Order> getActiveOrdersOfCustomer(@PathVariable int customerId) {
        Iterable<Order> allOrders = getAllOrdersOfCustomer(customerId);
        List<Order> activeOrders = new ArrayList<>();
        for (Order o : allOrders) {
            if (!o.getOrderState().equals(OrderState.DELIVERED) && !o.getOrderState().equals(OrderState.REJECTED)) {
                activeOrders.add(o);
            }
        }
        return activeOrders;
    }

    //All pending orders of restaurant
    @RequestMapping(path = "/restaurants/pendingOrders/{restaurantId}")
    private Iterable<Order> getAllPendingOrdersOfRestaurant(@PathVariable int restaurantId) {
        Iterable<Order> allRestaurantOrders = getAllOrdersOfRestaurant(restaurantId);
        List<Order> orders = new ArrayList<Order>();
        for (Order o : allRestaurantOrders) {
            if (o.getOrderState().equals(OrderState.PENDING)) {
                orders.add(o);
            }
        }
        return orders;
    }

    //All active orders of a customer
    @RequestMapping(path = "/restaurants/active/{restaurantId}", method = RequestMethod.GET)
    private Iterable<Order> getActiveOrdersOfRestaurant(@PathVariable int restaurantId) {
        Iterable<Order> allOrders = getAllOrdersOfRestaurant(restaurantId);
        List<Order> activeOrders = new ArrayList<>();
        for (Order o : allOrders) {
            if (!o.getOrderState().equals(OrderState.DELIVERED)) {
                activeOrders.add(o);
            }
        }
        return activeOrders;
    }

    //Accept order
    @RequestMapping(path = "restaurants/acceptorder/{orderId}", method = RequestMethod.GET)
    private Order acceptOrder(@PathVariable String orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() ->
                new OrderNotFoundException("Order with id " + orderId + " not found."));
        order.setOrderState(OrderState.ACCEPTED);
        return orderRepository.save(order);
    }

    //Reject order
    @RequestMapping(path = "restaurants/rejectOrder/{orderId}", method = RequestMethod.GET)
    private Order rejectOrder(@PathVariable String orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("Order with id " + orderId + " not found."));
        order.setOrderState(OrderState.REJECTED);
        return orderRepository.save(order);
    }
}


