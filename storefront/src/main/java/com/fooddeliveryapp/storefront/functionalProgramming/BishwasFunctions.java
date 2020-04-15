package com.fooddeliveryapp.storefront.functionalProgramming;

import com.fooddeliveryapp.storefront.models.*;
import com.sun.tools.javac.util.Pair;

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

//      Step 1: From Order -> Group restaurant ID + order by group count.
        Map<String, Long> groupByTopOrderForRestaurant = allOrders
                .stream()
                .filter(order -> order.getOrderState() == OrderState.DELIVERED)
                .collect(
                        Collectors.groupingBy(
                                Order::getRestaurantId, LinkedHashMap::new, counting()
                        )
                );

//      Step 2: From Food -> Get restaurant ID with average rating (i.e.: all food rating / total number of food)
        Map<String, Double> groupByMostMostRatedFoodForRestaurant =
                foodList
                        .stream()
                        .collect(
                                Collectors.groupingBy(
                                        Food::getRestaurantId, Collectors.averagingInt(Food::getRating)
                                )
                        );

//      Step 3: CONCAT
        return Stream.concat(
                groupByMostMostRatedFoodForRestaurant
                        .entrySet()
                        .stream()
                        .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                        .map(Map.Entry::getKey)
                        .limit(10)
                ,
                groupByTopOrderForRestaurant
                        .entrySet()
                        .stream()
                        .limit(10)
                        .map(Map.Entry::getKey)
        )
                .collect(Collectors.toList());
    }
}

//    DEV TEST
//    public static void main(String[] args){
//        topRestaurantsInTown();
//    }
