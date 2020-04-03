package com.fooddeliveryapp.orderprocessingservice.orderprocessingservice.models;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class Order {
       @Id
       private String id;
       private int customerId;
       private int restaurantId;
       private List<OrderEntity> foods;
       private int driverId;
       private OrderState orderState;
       private int modifiedBy;

       public Order(String id, int customerId, int restaurantId, List<OrderEntity> foods, int driverId, OrderState orderState, int modifiedBy) {
              this.id = id;
              this.customerId = customerId;
              this.restaurantId = restaurantId;
              this.foods = foods;
              this.driverId = driverId;
              this.orderState = orderState;
              this.modifiedBy = modifiedBy;
       }

       public String getId() {
              return id;
       }

       public void setId(String id) {
              this.id = id;
       }

       public int getCustomerId() {
              return customerId;
       }

       public void setCustomerId(int customerId) {
              this.customerId = customerId;
       }

       public int getRestaurantId() {
              return restaurantId;
       }

       public void setRestaurantId(int restaurantId) {
              this.restaurantId = restaurantId;
       }

       public List<OrderEntity> getFoods() {
              return foods;
       }

       public void setFoods(List<OrderEntity> foods) {
              this.foods = foods;
       }

       public int getDriverId() {
              return driverId;
       }

       public void setDriverId(int driverId) {
              this.driverId = driverId;
       }

       public OrderState getOrderState() {
              return orderState;
       }

       public void setOrderState(OrderState orderState) {
              this.orderState = orderState;
       }

       public int getModifiedBy() {
              return modifiedBy;
       }

       public void setModifiedBy(int modifiedBy) {
              this.modifiedBy = modifiedBy;
       }
}
