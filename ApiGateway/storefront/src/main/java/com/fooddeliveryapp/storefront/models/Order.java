package com.fooddeliveryapp.storefront.models;

import java.util.List;

public class Order {
    private int orderId;
    private int customerId;
    private int restaurantId;
    private List<OrderEntity> orderItems;
    private int driverId;
    private OrderState orderState;
    private int modifiedBy;

    public Order(){}

    public Order(int orderId, int customerId, int restaurantId, List<OrderEntity> orderItems, int driverId, OrderState orderState, int modifiedBy) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.restaurantId = restaurantId;
        this.orderItems = orderItems;
        this.driverId = driverId;
        this.orderState = orderState;
        this.modifiedBy = modifiedBy;

    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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
