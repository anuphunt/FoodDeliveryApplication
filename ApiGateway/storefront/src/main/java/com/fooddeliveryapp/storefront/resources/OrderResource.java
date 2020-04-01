package com.fooddeliveryapp.storefront.resources;

import com.fooddeliveryapp.storefront.models.Order;
import com.fooddeliveryapp.storefront.models.OrderEntity;
import com.fooddeliveryapp.storefront.models.OrderState;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api(value = "All data regarding orders")
@RequestMapping("/orders")
public class OrderResource {
    @Autowired
    private RestTemplate restTemplate;

    public List<Order> orders = new ArrayList<>();

    private List<Order> getDummyData(){
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
    @RequestMapping(value = "/customers/{customerId}", method = RequestMethod.GET, produces = "application/JSON")
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
    @RequestMapping(value = "restaurants/{restaurantId}", method = RequestMethod.GET, produces = "application/JSON")
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
    @RequestMapping(value = "drivers/{driverId}", method = RequestMethod.GET, produces = "application/JSON")
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
    @RequestMapping(value = "drivers/active/{driverId}", method = RequestMethod.GET, produces = "application/JSON")
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
    @RequestMapping(value = "customers/active/{customerId}", method = RequestMethod.GET, produces = "application/JSON")
    private Iterable<Order> getActiveOrdersOfCustomer(@PathVariable int customerId){
        List<Order> allOrders = getDummyData();
        List<Order> activeOrders = new ArrayList<>();
        for(Order o: allOrders){
            if(o.getCustomerId() == customerId && o.getOrderState() != OrderState.DELIVERED){
                activeOrders.add(o);
            }
        }
        return activeOrders;
    }

    @ApiOperation("Get active order of a specific restaurant. Active oder of a retaurant means all the orders of the restaurant that are accepted by restaurant but picked up by diver.")
    @RequestMapping(value = "restaurants/active/{restaurantId}", method = RequestMethod.GET, produces = "application/JSON")
    public Iterable<Order> geActiveOrdersOfRestaurant(@PathVariable int restaurantId){
        List<Order> allOrders = getDummyData();
        List<Order> activeOrders = new ArrayList<>();
        for(Order o: allOrders){
            if(o.getRestaurantId() == restaurantId && o.getOrderState() == OrderState.ACCEPTED){
                activeOrders.add(o);
            }
        }
        return activeOrders;
    }

    @ApiOperation(value = "Place an order by a customer.", consumes = "application/JSON")
    @RequestMapping(value = "orders/newOrder", method = RequestMethod.POST)
    public Order placeNewOrder(@Valid @RequestBody Order order){
        orders.add(order);
        return order;
    }
    //Accept a new order by a restaurant
    @ApiOperation(value = "Restaurant accepts the order", consumes = "application/JSON")
    @RequestMapping(value = "restaurant/acceptOrder", method = RequestMethod.PUT)
    public Order acceptOrderByRestaurant(@RequestBody Order order){
        Order o = null;
        for(Order o1: orders){
            if(o1.getOrderId() == order.getOrderId()){
                o = o1;
            }
        }
        if(o != null){
            o.setOrderState(OrderState.ACCEPTED);
        }
        //SEND Put REQUEST HERE.
        return o;
    }

    @ApiOperation(value = "Restaurant rejects the order. Returns an order with rejected status.")
    @RequestMapping(value = "restaurant/rejectOrder", method = RequestMethod.PUT)
    public Order rejectOrderByRestaurant(@Valid @RequestBody Order order){
        //Send put request here.
        return order;
    }
    //book pick up by a driver
    //pick up order by a driver
    //deliver order by a driver
}
