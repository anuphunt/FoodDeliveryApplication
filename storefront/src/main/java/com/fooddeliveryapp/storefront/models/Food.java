package com.fooddeliveryapp.storefront.models;


import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class Food {
    private String id;
    private String name;
    private double price;
    private String description;
    private String imageUrl;
    private String restaurantId;
    private LocalDate date;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    private int rating;



    public Food(String id, String name, double price, String description, String imageUrl, String restaurantId,int ratings,LocalDate date) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
        this.restaurantId = restaurantId;
        this.rating=ratings;
        this.date=date;

    }

    public Food() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
}
