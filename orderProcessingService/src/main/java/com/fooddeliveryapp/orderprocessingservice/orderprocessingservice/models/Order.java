package com.fooddeliveryapp.orderprocessingservice.orderprocessingservice.models;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class Order {
       @Id
       private String id;
       private String customerId;
       private String restaurantId;
       private List<OrderEntity> foods;
       private String driverId;
       private OrderState orderState;
       private String modifiedBy;

       public Order(String id, String customerId, String restaurantId, List<OrderEntity> foods, String driverId, OrderState orderState, String modifiedBy) {
              this.id = id;
              this.customerId = customerId;
              this.restaurantId = restaurantId;
              this.foods = foods;
              this.driverId = driverId;
              this.orderState = orderState;
              this.modifiedBy = modifiedBy;
       }
}
