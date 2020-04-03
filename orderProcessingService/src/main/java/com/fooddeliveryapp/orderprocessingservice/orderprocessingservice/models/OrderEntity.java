package com.fooddeliveryapp.orderprocessingservice.orderprocessingservice.models;

import org.springframework.data.annotation.Id;

public class OrderEntity {
    @Id
    String id;
    int foodId;
    int quantity;

    public OrderEntity(String id, int foodId, int quantity) {
        this.id = id;
        this.foodId = foodId;
        this.quantity = quantity;
    }
    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
