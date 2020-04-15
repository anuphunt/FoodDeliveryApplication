package com.fooddeliveryapp.storefront.functionalProgramming;

import com.fooddeliveryapp.storefront.models.*;

import java.time.LocalDate;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class BishwasFunctions {

    public static Function<List<Food>, List<String>> getAllFoodsForPriceRange =
            (foodList) ->
                    foodList
                            .stream()
                            .filter(fixture -> fixture.getPrice() > 1 || fixture.getPrice() < 10)
                            .map(Food::getId)
                            .collect(Collectors.toList());

    public static BiFunction<List<Food>, String, String> getFoodByRestaurantId = (foodList, restId) -> foodList
            .stream()
            .filter(r -> r.getRestaurantId().equals(restId)).map(Food::getId).collect(Collectors.toList()).toString();

    public static BiFunction<List<Food>, List<Order>, List<String>> topFoodsForRestaurant = (foodList, orders) -> orders
            .stream()
            .collect(Collectors.groupingBy(Order::getRestaurantId, LinkedHashMap::new, counting()))
            .keySet().stream()
            .map(aLong -> getFoodByRestaurantId.apply(foodList, aLong))
            .collect(Collectors.toList());

    public static BiFunction<List<Order>, List<Food>, List<String>> topRestaurantsInTown =
            (orderList, foodList) -> foodList
                    .stream()
                        .collect(
                                Collectors.groupingBy(Food::getRestaurantId, Collectors.averagingInt(Food::getRating)))
                        .entrySet()
                        .stream()
                        .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                        .map(Map.Entry::getKey)
                        .limit(10)
                        // returns stream of restaurant ID
                        .filter(
                                // Step 2: From Order -> Group restaurant ID + order by group count.
                                orderList
                                        .stream()
                                        .filter(order -> order.getOrderState() == OrderState.DELIVERED)
                                        .collect(Collectors.groupingBy(Order::getRestaurantId, LinkedHashMap::new, counting()))
                                        .entrySet()
                                        .stream()
                                        .limit(2)
                                        .map(Map.Entry::getKey)
                                        .collect(Collectors.toList())
                                        // returns list of restaurant ID
                                        ::contains
                        )
                        .collect(Collectors.toList());

//    DEV TEST
//    public static void main(String[] args) {
//        System.out.println(
//                getAllFoodsForPriceRange.apply(foodList)
//        );
//    }
}