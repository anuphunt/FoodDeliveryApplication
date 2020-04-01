package com.fooddeliveryapp.storefront.resources;

import com.fooddeliveryapp.storefront.models.Order;
import com.fooddeliveryapp.storefront.models.OrderEntity;
import com.fooddeliveryapp.storefront.models.OrderState;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    @ApiOperation("Get all orders of a specific customer")
    @RequestMapping(value = "/customers/{customerId}")
    private Iterable<Order> getAllOrdersOfCustomer(@PathVariable int customerId){

        List<Order> allOrders = getDummyData();
        List<Order> customerOrders = new ArrayList<>();
        for(Order o: allOrders){
            if(o.getCustomerId() == customerId){
                customerOrders.add(o);
            }
        }
        return customerOrders;
    }
    //Get All Orders of a restaurant

    @ApiOperation("Get all orders of a specific restaurant")
    @RequestMapping(value = "restaurants/{restaurantId}")
    private Iterable<Order> getAllOrdersOfRestaurant(@PathVariable int restaurantId){
        List<Order> allOrders = getDummyData();
        List<Order> restaurantOrders = new ArrayList<>();
        for(Order o: allOrders){
            if(o.getRestaurantId() == restaurantId){
                restaurantOrders.add(o);
            }
        }
        return restaurantOrders;
    }


    //Get All picked up orders of a driver
    @ApiOperation("Get all picked up orders of a specific driver")
    @RequestMapping(value = "drivers/{driverId}")
    private Iterable<Order> getAllOrdersOfDriver(@PathVariable int driverId){
        List<Order> allOrders = getDummyData();
        List<Order> driverOrders = new ArrayList<>();
        for(Order o: allOrders){
            if(o.getDriverId() == driverId){
                driverOrders.add(o);
            }
        }
        return driverOrders;
    }

    //Get active order of a driver
    @ApiOperation("Get active order of a driver. Active order means the order which is selected by driver to pickup, but hasn't delivered yet. Returns null if there is no active orders, otherwise returns one Order")
    @RequestMapping(value = "drivers/active/{driverId}")
    private Order getActiveOrderOfDriver(@PathVariable int driverId){
        List<Order> allOrders = getDummyData();
        for(Order o: allOrders){
            if(o.getDriverId() == driverId && o.getOrderState() != OrderState.DELIVERED){
                return o;
            }
        }
        return null;
    }

    //Get active orders of a customer
    @ApiOperation("Get active order of a specific customer. Active order of customer means the orders of the customer which are not delivered yet. Returns an empty list if there is no active orders, otherwise returns list of orders.")
    @RequestMapping(value = "customers/active/{customerId}")
    private Iterable<Order> getActiveOrdersOfCustomer(@PathVariable int customerId){
        List<Order> allOrders = getDummyData();
        List<Order> activeOrders = getDummyData();
        for(Order o: allOrders){
            if(o.getCustomerId() == customerId && o.getOrderState() != OrderState.DELIVERED){
                activeOrders.add(o);
            }
        }
        return activeOrders;
    }
    //Get active order of a restaurant
    //Place a new order by a user
    //Accept a new order by a restaurant
    //Reject a new order by a restaurant
    //book pick up by a driver
    //pick up order by a driver
    //deliver order by a driver
}
