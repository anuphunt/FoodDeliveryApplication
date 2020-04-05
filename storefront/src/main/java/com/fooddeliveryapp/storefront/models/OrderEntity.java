package com.fooddeliveryapp.storefront.models;

public class OrderEntity {
    private String id;
    private String foodId;
    private String Quantity;

    public OrderEntity(String id, String foodId, String quantity) {
        this.id = id;
        this.foodId = foodId;
        Quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }
}
