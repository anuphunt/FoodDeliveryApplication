package com.fooddeliveryapp.orderprocessingservice.orderprocessingservice.models;

import org.springframework.data.annotation.Id;

public class Food {
    int foodId;
    int quantity;

    public Food(int id, int quantity) {
        this.foodId = id;
        this.quantity = quantity;
    }

    public int getId() {
        return foodId;
    }

    public void setId(int id) {
        this.foodId = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
