package com.fooddeliveryapp.storefront.functionalProgramming;

import com.fooddeliveryapp.storefront.models.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BishwasFunctionsTest {

    @Test
    public void topRestaurantsInTown(){
        assertEquals(Arrays.asList("rest1", "rest2"), BishwasFunctions.topRestaurantsInTown(allOrders, foodList));
    }

    // ******* Dummy Data ******* //

    // Users
    static User user1 = new User("user1", "sham.sher", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", "Shamsher", "Rana", "example@example.com", "9999999999", "Fairfield", UserRole.RESTAURANT, 4);
    static User user2 = new User("user2", "navin.paudel", "26b173d2c32443febced1006bccaeca4d5a9cee3879ad783344cd8ebee2ae828", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.RESTAURANT, 3);

    static List<User> userList = Arrays.asList(user1, user2);

    // Order Entity
    static OrderEntity orderEntity1 = new OrderEntity("4355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", 5);
    static OrderEntity orderEntity2 = new OrderEntity("4355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", 10);

    // Order
    static Order order1 = new Order("order1", "", "rest2", Arrays.asList(orderEntity1),"driver1", OrderState.DELIVERED, "", 10D);
    static Order order2 = new Order("order2", "", "rest1", Arrays.asList(orderEntity1),"driver1", OrderState.DELIVERED, "", 20D);
    static Order order3 = new Order("order3", "", "rest2", Arrays.asList(orderEntity2),"driver1", OrderState.DELIVERED, "", 30D);

    static List<Order> allOrders = Arrays.asList(order1, order2, order3);

    // Food
    static Food food1 = new Food("food1", "Pizza", 15.5, "Italian Food", "https://images.app.goo.gl/vebgTeEk7Y4Dj2Lg7", "rest2", 4, LocalDate.now());
    static Food food2 = new Food("food2", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "rest2", 3, LocalDate.now());
    static Food food3 = new Food("food3", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "rest1", 4, LocalDate.now());

    static List<Food> foodList = Arrays.asList(food1, food2, food3);

    // ******* Dummy Data ******* //
}