package com.fooddeliveryapp.storefront.functionalProgramming;

import com.fooddeliveryapp.storefront.models.*;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnupFunctionsTest {

    public List<User> restaurants, customers, drivers;
    public List<Food> foods;

    @BeforeEach
    public void setUp() {
        // Restaurants
        User restaurant1 = new User("restaurant1", "sham.sher", "user1", "Shamsher", "Rana", "example@example.com", "9999999999", "Fairfield", UserRole.RESTAURANT, 5);
        User restaurant2 = new User("restaurant2", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.RESTAURANT, 3);
        User restaurant3 = new User("restaurant3", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.RESTAURANT, 2);
        User restaurant4 = new User("restaurant4", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.RESTAURANT, 1);
        User restaurant5 = new User("restaurant5", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.RESTAURANT, 4);
        User restaurant6 = new User("restaurant6", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.RESTAURANT, 4);
        User restaurant7 = new User("restaurant7", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.RESTAURANT, 2);
        User restaurant8 = new User("restaurant8", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.RESTAURANT, 1);
        User restaurant9 = new User("restaurant9", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.RESTAURANT, 4);
        User restaurant10 = new User("restaurant10", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.RESTAURANT, 3);
        restaurants = Arrays.asList(restaurant1, restaurant2, restaurant3,restaurant4,restaurant5,restaurant6,restaurant7,restaurant8,restaurant9,restaurant10 );

        //Customers
        User customer1 = new User("customer1", "sham.sher", "customer1", "Shamsher", "Rana", "example@example.com", "9999999999", "Fairfield", UserRole.CUSTOMER, 5);
        User customer2 = new User("customer2", "navin.paudel", "customer2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.CUSTOMER, 4);
        User customer3 = new User("customer3", "navin.paudel", "customer3", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.CUSTOMER, 3);
        User customer4 = new User("customer4", "navin.paudel", "customer4", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.CUSTOMER, 1);
        User customer5 = new User("customer5", "navin.paudel", "customer5", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.CUSTOMER, 1);
        User customer6 = new User("customer6", "navin.paudel", "customer6", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.CUSTOMER, 2);
        User customer7 = new User("customer7", "navin.paudel", "customer7", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.CUSTOMER, 3);
        User customer8 = new User("customer8", "navin.paudel", "customer10", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.CUSTOMER, 2);
        User customer9 = new User("customer9", "navin.paudel", "customer8", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.CUSTOMER, 4);
        User customer10 = new User("customer10", "navin.paudel", "custoer9", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.CUSTOMER, 4);
        customers = Arrays.asList(customer1, customer2, customer3,customer4,customer5,customer6,customer7,customer8,customer9,customer10);

        //Drivers
        User driver1 = new User("driver1", "sham.sher", "user1", "Shamsher", "Rana", "example@example.com", "9999999999", "Fairfield", UserRole.DRIVER, 5);
        User driver2 = new User("driver2", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.DRIVER, 3);
        User driver3 = new User("driver3", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.DRIVER, 1);
        User driver4 = new User("driver4", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.DRIVER, 3);
        User driver5 = new User("driver5", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.DRIVER, 4);
        User driver6 = new User("driver6", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.DRIVER, 5);
        User driver7 = new User("driver7", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.DRIVER, 2);
        User driver8 = new User("driver8", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.DRIVER, 1);
        User driver9 = new User("driver9", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.DRIVER, 5);
        User driver10 = new User("driver10", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.RESTAURANT, 3);
        drivers = Arrays.asList(driver1, driver2, driver3, driver4, driver5, driver6, driver7, driver8, driver8, driver9, driver10);

        // Order Entity
        OrderEntity orderEntity1 = new OrderEntity("food1", 5);

        // Order
        Order order1 = new Order("order1", "customer1", "restaurant1", Arrays.asList(orderEntity1), "driver1", OrderState.DELIVERED, "driver1", 10D);
        Order order2 = new Order("order2", "customer2", "restaurant1", Arrays.asList(orderEntity1), "driver1", OrderState.DELIVERED, "driver1", 10D);
        List<Order> allOrders = Arrays.asList(order1, order2);

        // Food
        Food food1 = new Food("food1", "Pizza", 15.5, "Italian Food", "https://images.app.goo.gl/vebgTeEk7Y4Dj2Lg7", "restaurant1", 4, LocalDate.now());
        Food food2 = new Food("food2", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant1", 5, LocalDate.now());
        Food food3 = new Food("food3", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant1", 4, LocalDate.now());
        Food food4 = new Food("food4", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant1", 4, LocalDate.now());
        Food food5 = new Food("food5", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant1", 3, LocalDate.now());
        Food food6 = new Food("food6", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant2", 2, LocalDate.now());
        Food food7 = new Food("food7", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant2", 1, LocalDate.now());
        Food food8 = new Food("food8", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant2", 4, LocalDate.now());
        Food food9 = new Food("food9", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant3", 3, LocalDate.now());
        Food food10 = new Food("food10", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant3", 4, LocalDate.now());
        foods = Arrays.asList(food1, food2, food3,food4,food5,food6,food7,food8,food9,food10);
    }

    @Test
    public void getRestaurantsWithFoodCountAndSortByRatingTest1(){
        List<User> result = AnupFunctions.getRestaurantsWithFoodCountAndSortByRating.apply(restaurants, foods, 1);
        assertEquals(3, result.size());
        assertTrue(result.get(0).getRating() >= result.get(1).getRating());
    }

    @Test
    public void getRestaurantsWithFoodCountAndSortByRatingTest2(){
        List<User> result = AnupFunctions.getRestaurantsWithFoodCountAndSortByRating.apply(restaurants, foods, 4);
        assertEquals(1, result.size());
    }

    @Test
    public void getRestaurantsWithFoodCountAndSortByRatingTest3(){
        List<User> result = AnupFunctions.getRestaurantsWithFoodCountAndSortByRating.apply(restaurants, foods, 10);
        assertEquals(0, result.size());
    }

}