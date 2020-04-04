package com.fooddeliveryapp.storefront.models;

public class Food {
    private String id;
    private String name;
    private Double price;
    private String description;
    private String imageUrl;
    private String restaurantId;

    public Food(String id, String name, Double price, String description, String imageUrl, String restaurantId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getFoodId() {
        return id;
    }

    public void setFoodId(String id) {
        this.id = id;
    }
}
