package com.fooddeliveryapp.storefront.functionalProgramming;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fooddeliveryapp.storefront.models.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class PradipFunctionsTest {
    public List<Food> foods;

    public List<User> restaurants,drivers;
    public List<Order> orders;
    public OrderEntity orderEntity1;
    @BeforeEach
    public void setUp() {
        Food food1 = new Food("food1", "Pizza", 15.5, "Italian Food", "https://images.app.goo.gl/vebgTeEk7Y4Dj2Lg7", "restaurant2", 5, LocalDate.now());
        Food food2 = new Food("food2", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant2", 5, LocalDate.now());
        Food food3 = new Food("food3", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant1", 2, LocalDate.now());
        Food food4 = new Food("food4", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant1", 2, LocalDate.now());
        Food food5 = new Food("food5", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant1", 1, LocalDate.now());
        Food food6 = new Food("food6", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant1", 2, LocalDate.now());
        Food food7 = new Food("food7", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant1", 1, LocalDate.now());
        Food food8 = new Food("food8", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant2", 2, LocalDate.now());
        Food food9 = new Food("food9", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant3", 3, LocalDate.now());
        Food food10 = new Food("food10", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant3", 5, LocalDate.now());
        foods = Arrays.asList(food1, food2, food3,food4,food5,food6,food7,food8,food9,food10);

        User restaurant1 = new User("restaurant1", "sham.sher", "user1", "Shamsher", "Rana", "example@example.com", "9999999999", "Fairfield", UserRole.RESTAURANT, 1);
        User restaurant2 = new User("restaurant1", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.RESTAURANT, 1);
        User restaurant3 = new User("restaurant1", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.RESTAURANT, 1);
        User restaurant4 = new User("restaurant1", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.RESTAURANT, 1);
        User restaurant5 = new User("restaurant1", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.RESTAURANT, 1);
        User restaurant6 = new User("restaurant6", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.RESTAURANT, 4);
        User restaurant7 = new User("restaurant7", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.RESTAURANT, 2);
        User restaurant8 = new User("restaurant8", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.RESTAURANT, 1);
        User restaurant9 = new User("restaurant9", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.RESTAURANT, 4);
        User restaurant10 = new User("restaurant10", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.RESTAURANT, 3);
        restaurants = Arrays.asList(restaurant1, restaurant2, restaurant3,restaurant4,restaurant5,restaurant6,restaurant7,restaurant8,restaurant9,restaurant10 );

        Order order1 = new Order("order1", "customer1", "restaurant1", Arrays.asList(orderEntity1), "driver1", OrderState.DELIVERED, "driver1", 20.0);
        Order order2 = new Order("order2", "customer1", "restaurant1", Arrays.asList(orderEntity1), "driver1", OrderState.DELIVERED, "driver1", 40.0);
        Order order3 = new Order("order3", "customer1", "restaurant1", Arrays.asList(orderEntity1), "driver1", OrderState.DELIVERED, "driver1", 40.0);
        Order order4 = new Order("order4", "customer1", "restaurant2", Arrays.asList(orderEntity1), "driver1", OrderState.DELIVERED, "driver1", 40.0);
        Order order5 = new Order("order5", "customer1", "restaurant2", Arrays.asList(orderEntity1), "driver1", OrderState.DELIVERED, "driver1", 40.0);
        Order order6 = new Order("order6", "customer1", "restaurant3", Arrays.asList(orderEntity1), "driver1", OrderState.DELIVERED, "driver1", 40.0);
        Order order7 = new Order("order7", "customer2", "restaurant3", Arrays.asList(orderEntity1), "driver1", OrderState.DELIVERED, "driver1", 10.0);
        Order order8 = new Order("order8", "customer3", "restaurant3", Arrays.asList(orderEntity1), "driver1", OrderState.DELIVERED, "driver1", 40.0);
        Order order9 = new Order("order9", "customer3", "restaurant4", Arrays.asList(orderEntity1), "driver1", OrderState.DELIVERED, "driver1", 40.0);
        Order order10 = new Order("order10", "customer3", "restaurant4", Arrays.asList(orderEntity1), "driver1", OrderState.DELIVERED, "driver1", 40.0);
        orders = Arrays.asList(order1, order2, order3, order4, order5, order6, order7, order8, order9, order10);


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
    }
    @Test
    public void highlyRatedFoods1(){
        List<Food> result = PradipFunctions.getHighlyRatedFoods.apply(foods, LocalDate.now());
        assertEquals(2, result.size());

    }
    @Test
    public void lowRatedRestaurants1(){
        List<User> result = PradipFunctions.getLowRatedRestaurants.apply(restaurants,foods,5,5);
        assertEquals(1, result.size());

    }
       @Test
     public void noOfDriverTest(){
         List<User> result = PradipFunctions.getAllDriversWithXDeliveriesFromARestaurant.apply(drivers,orders,"restaurant1",3);
         assertEquals(1, result.size());

     }                                                                                           }