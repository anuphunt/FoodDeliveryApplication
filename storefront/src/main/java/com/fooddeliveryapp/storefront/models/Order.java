package com.fooddeliveryapp.storefront.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Order {
    @JsonIgnore
    private String id;
    private int customerId;
    private int restaurantId;
    private List<OrderEntity> orderItems;
    private int driverId;
    private OrderState orderState;
    private int modifiedBy;

    public Order(){}

    public Order(String id, int customerId, int restaurantId, List<OrderEntity> orderItems, int driverId, OrderState orderState, int modifiedBy) {
        this.id = id;
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.orderItems = orderItems;
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

    public List<OrderEntity> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderEntity> orderItems) {
        this.orderItems = orderItems;
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
