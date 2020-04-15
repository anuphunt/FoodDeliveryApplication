package com.fooddeliveryapp.storefront.functionalProgramming;

import com.fooddeliveryapp.storefront.models.*;

import java.time.LocalDate;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class BishwasFunctions {
    // Food
    static Food food1 = new Food("food1", "Pizza", 15.5, "Italian Food", "https://images.app.goo.gl/vebgTeEk7Y4Dj2Lg7", "rest2", 4, LocalDate.now());
    static Food food2 = new Food("food2", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "rest2", 3, LocalDate.now());
    static Food food3 = new Food("food3", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "rest1", 4, LocalDate.now());

    static List<Food> foodList = Arrays.asList(food1, food2, food3);

    // Order Entity
    static OrderEntity orderEntity1 = new OrderEntity("4355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", 5);
    static OrderEntity orderEntity2 = new OrderEntity("4355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", 10);

    // Order
    static Order order1 = new Order("order1", "", "rest2", Arrays.asList(orderEntity1),"driver1", OrderState.DELIVERED, "", 10D);
    static Order order2 = new Order("order2", "", "rest1", Arrays.asList(orderEntity1),"driver1", OrderState.DELIVERED, "", 20D);
    static Order order3 = new Order("order3", "", "rest2", Arrays.asList(orderEntity2),"driver1", OrderState.DELIVERED, "", 30D);

    static List<Order> allOrders = Arrays.asList(order1, order2, order3);

    public static BiFunction<List<Food>, String, String> getFoodByRestaurantId =
            (foodList, restId) -> foodList.
                    stream()
                    .filter(r -> r.getRestaurantId().equals(restId))
                    .map(food -> food.getId())
                    .collect(Collectors.toList())
                    .toString()
                    ;

    public static BiFunction<List<Food>, List<Order>, List<String>> topFoodForRestaurant =
            (foodList, orders) -> orders
                    .stream()
                    .collect(
                            Collectors.groupingBy(
                                    Order::getRestaurantId, LinkedHashMap::new, counting()
                            )
                    )
                    .entrySet()
                    .stream()
                    .map(id -> getFoodByRestaurantId.apply(foodList, id.getKey()))
                    .collect(Collectors.toList())
                    ;
    /*

        [1 of 3] Get X restaurants whose food items is rated top 10 and make top 10 sales.

        Step 1: From Order -> Group restaurant ID + order by group count.
        Step 2: From Food -> Get restaurant ID with average rating (i.e.: all food rating / total number of food)
        Step 3: CONCAT as:

                From Step 1 -> get top 10 results

                From Step 2 -> sort with average rating + get top 10 results

    */
    public static BiFunction<List<Order>, List<Food>, List<String>> topRestaurantsInTown =
            (orderList, foodList) ->
            // Step 1: From Food -> Get restaurant ID with high to low average rating (i.e.: sum all food rating / total number of food)
                foodList
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Food::getRestaurantId, Collectors.averagingInt(Food::getRating)
                        )
                )
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .limit(10)
                // returns stream of restaurant ID
                .filter(
                        // Step 2: From Order -> Group restaurant ID + order by group count.
                        allOrders
                                .stream()
                                .filter(order -> order.getOrderState() == OrderState.DELIVERED)
                                .collect(
                                        Collectors.groupingBy(
                                                Order::getRestaurantId, LinkedHashMap::new, counting()
                                        )
                                )
                        .entrySet()
                        .stream()
                        .limit(10)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList())
                        // returns list of restaurant ID
                        ::contains
                )
                        .collect(Collectors.toList());

//    DEV TEST
//    public static void main(String[] args) {
//        System.out.println(
//                topOrdersForRestaurant.apply(foodList, allOrders)
//        );
//    }
}