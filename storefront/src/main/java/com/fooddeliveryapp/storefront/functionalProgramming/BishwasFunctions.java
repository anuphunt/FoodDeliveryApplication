package com.fooddeliveryapp.storefront.functionalProgramming;

import com.fooddeliveryapp.storefront.models.*;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class BishwasFunctions {

    // Order Entity
    static OrderEntity orderEntity1 = new OrderEntity("4355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", 5);
    static OrderEntity orderEntity2 = new OrderEntity("4355a46b19d348dc2f57c046f8ef63d4538ebb936000f3c9ee954a27460dd865", 10);

    // Order
    static Order order1 = new Order("order1", "", "rest2", Arrays.asList(orderEntity1),"driver1", OrderState.DELIVERED, "", 10D);
    static Order order2 = new Order("order2", "", "rest1", Arrays.asList(orderEntity1),"driver1", OrderState.DELIVERED, "", 20D);
    static Order order3 = new Order("order3", "", "rest2", Arrays.asList(orderEntity2),"driver1", OrderState.DELIVERED, "", 30D);

    static List<Order> allOrders = Arrays.asList(order1, order2, order3);

    // todo -> to get restaurant for its ID
    public static BiFunction<List<User>, String, Optional<User>> getRestaurantById = (restaurants, id) -> restaurants.stream()
            .filter(r -> r.getId().equals(id)).findFirst();

    public static Function<List<Order>, List<String>> topOrdersForRestaurant =
            (orders) -> orders
                    .stream()
                    .collect(
                            Collectors.groupingBy(
                                    Order::getRestaurantId, LinkedHashMap::new, counting()
                            )
                    )
                    .entrySet()
                    .stream()
                    .limit(10)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());

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
//        topOrdersForRestaurant(allOrders);
//    }
}