package com.fooddeliveryapp.storefront.functionalProgramming;

import com.fooddeliveryapp.storefront.models.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class BishwasFunctions {

    public static List<String> topRestaurantsInTown(List<Order> allOrders, List<Food> foodList) {
    /*

        [1 of 3] Get X restaurants whose food items is rated top 10 and make top 10 sales.

        Step 1: From Order -> Group restaurant ID + order by group count.
        Step 2: From Food -> Get restaurant ID with average rating (i.e.: all food rating / total number of food)
        Step 3: CONCAT as:

                From Step 1 -> get top 10 results

                From Step 2 -> sort with average rating + get top 10 results

    */
    
        return // Step 1: From Food -> Get restaurant ID with average rating (i.e.: all food rating / total number of food)
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
                // returns stream
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
                        // returns list
                        ::contains
                )
                        .collect(Collectors.toList());
    }


//    DEV TEST
//    public static void main(String[] args) {
//        topRestaurantsInTown();
//    }
}