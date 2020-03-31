package com.fooddeliveryapp.storefront.resources;

import com.fooddeliveryapp.storefront.models.Order;
import com.fooddeliveryapp.storefront.models.OrderEntity;
import com.fooddeliveryapp.storefront.models.OrderState;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(value = "All data regarding orders")
@RequestMapping("/orders")
public class OrderResource {
    @Autowired
    private RestTemplate restTemplate;

    private List<Order> getDummyData(){
        List<Order> orders = new ArrayList<>();
        List<OrderEntity> orderEntities = new ArrayList<>();
        orderEntities.add(new OrderEntity(1, 1));
        orderEntities.add(new OrderEntity(2,2));
        orderEntities.add(new OrderEntity(3, 3));

        orders.add(new Order(1, 2, 3, orderEntities, 4, OrderState.PENDING, 1));
        orders.add(new Order(1, 2, 3, orderEntities, 4, OrderState.DELIVERED, 2));
        orders.add(new Order(1, 2, 3, orderEntities, 4, OrderState.DELIVERED, 3));
        orders.add(new Order(1, 2, 3, orderEntities, 4, OrderState.ACCEPTED, 4));
        orders.add(new Order(1, 2, 3, orderEntities, 4, OrderState.PICKEDUP, 1));
        orders.add(new Order(1, 2, 3, orderEntities, 4, OrderState.REJECTED, 1));

        return orders;
    }

    //Get All Orders of a customer
    //Get All Orders of a restaurant
    //Get All picked up orders of a driver
    //Get active order of a driver
    //Get active order of a customer
    //Get active order of a restaurant
    //Place a new order by a user
    //Accept a new order by a restaurant
    //Reject a new order by a restaurant
    //book pick up by a driver
    //pick up order by a driver
    //deliver order by a driver
}
