package com.fooddeliveryapp.storefront.models;

import javax.validation.constraints.NotBlank;

public class Food {
    Long foodId;

    @NotBlank(message = "Name of the food is mandatory.")
    String name;
    String description;
    String imageUrl;
    String restaurantId;

    public Food(Long foodId, String name, String description, String imageUrl, Long restaurantId) {
        this.foodId = foodId;
        this.name = name;
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

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Long getFoodId() {
        return foodId;
    }

    public void setFoodId(Long foodId) {
        this.foodId = foodId;
    }
}
