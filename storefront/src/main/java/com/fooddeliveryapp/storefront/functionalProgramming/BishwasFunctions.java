package com.fooddeliveryapp.storefront.functionalProgramming;

import com.fooddeliveryapp.storefront.models.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class BishwasFunctions {

    // ******* Dummy Data ******* //

    // Users
    static User user1 = new User("4355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "sham.sher", "d2a84f4b8b650937ec8f73cd8be2c74add5a911ba64df27458ed8229da804a26", "Shamsher", "Rana", "example@example.com", "9999999999", "Fairfield",  UserRole.RESTAURANT);
    static User user2 = new User("53c234e5e8472b6ac51c1ae1cab3fe06fad053beb8ebfd8977b010655bfdd3c3", "navin.paudel", "26b173d2c32443febced1006bccaeca4d5a9cee3879ad783344cd8ebee2ae828", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.RESTAURANT);

    static List<User> userList = Arrays.asList(user1, user2);

    // Order Entity
    static OrderEntity orderEntity1 = new OrderEntity("4355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", 5);
    static OrderEntity orderEntity2 = new OrderEntity("4355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", 10);

    // Order
    static Order order1 = new Order("4355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "", "4355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", Arrays.asList(orderEntity1), "", OrderState.DELIVERED, "4355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865");
    static Order order2 = new Order("53c234e5e8472b6ac51c1ae1cab3fe06fad053beb8ebfd8977b010655bfdd3c3", "", "53c234e5e8472b6ac51c1ae1cab3fe06fad053beb8ebfd8977b010655bfdd3c3", Arrays.asList(orderEntity1), "", OrderState.DELIVERED, "4355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865");
    static Order order3 = new Order("53c234e5e8472b6ac51c1ae1cab3fe06fad053beb8ebfd8977b010655bfdd3", "", "4355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", Arrays.asList(orderEntity2), "", OrderState.DELIVERED, "4355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865");

    static List<Order> allOrders = Arrays.asList(order1, order2, order3);

    // Food
    static Food food1 = new Food("4355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "Pizza", 15.5, "Italian Food", "https://images.app.goo.gl/vebgTeEk7Y4Dj2Lg7", "4355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865");
    static Food food2 = new Food("4355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "4355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865");

    List<Food> foodList = Arrays.asList(food1, food2);

    // ******* Dummy Data ******* //


    public static List<User> topRestaurantsInTown(){
    /* [1 of 3] Get X restaurants whose food items is rated top 10 and make top 10 sales.

    Step 2: Get all order of a restaurant.
    Step 3: Get all order status as DELIVERED.
    Step 4: Pick only top 10 orders for all restaurants.
    AND
    Step 5: Get all food for that restaurant.
    Step 6: Has any food rating in top 10.

    */

//    collectingAndThen(
//            toList(),
//            l -> l.stream().limit(1).collect(toList()))

        Map<String, Long> groupByRestaurantId = allOrders
                .stream()
                .filter(order -> order.getOrderState()==OrderState.DELIVERED)
                .collect(
                        Collectors.groupingBy(
                                Order::getRestaurantId, LinkedHashMap::new, counting()
                        )
                );

        System.out.println(
                groupByRestaurantId
                        .entrySet()
                        .stream()
                        .limit(2)
                        .collect(Collectors.toMap(
                            e -> e.getKey(),
                            e -> e.getValue()
                        ))
        );
        return userList;
    }

    public static void main(String[] args){
        topRestaurantsInTown();
    }
}
