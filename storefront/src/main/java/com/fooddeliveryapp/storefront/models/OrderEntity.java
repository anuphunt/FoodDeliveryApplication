package com.fooddeliveryapp.storefront.models;

public class OrderEntity {
    int foodId;
    int Quantity;

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public OrderEntity(int foodId, int quantity) {
        this.foodId = foodId;
        Quantity = quantity;
    }
}
