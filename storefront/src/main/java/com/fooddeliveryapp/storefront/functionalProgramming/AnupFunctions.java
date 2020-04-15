package com.fooddeliveryapp.storefront.functionalProgramming;

import com.fooddeliveryapp.storefront.models.Food;
import com.fooddeliveryapp.storefront.models.Order;
import com.fooddeliveryapp.storefront.models.User;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class AnupFunctions {

    public static BiFunction<List<User>, String, Optional<User>> getRestaurantById = (restaurants, id) -> restaurants.stream()
            .filter(r -> r.getId().equals(id)).findFirst();


    //QUERY 1
    //get all restaurant who have more than specific number of foods, and sort them by their ratings from highest to lowest
    public static TriFunction<List<User>, List<Food>, Integer, List<User>> getRestaurantsWithFoodCountAndSortByRating =
            (restaurants, foods, foodCount) -> foods.stream()
                    .collect(groupingBy(Food::getRestaurantId))
                    .entrySet()
                    .stream()
                    .filter(group -> group.getValue()
                            .stream().count() > foodCount)
                    .map(id -> getRestaurantById.apply(restaurants, id.getKey()).get())
                    .sorted(Comparator.comparingInt(User::getRating)
                            .reversed())
                    .collect(Collectors.toList());

    //Query 2
    // Get all restaurant that a user have bought from and sort them according to restaurants that user has spent most to the restaurants that have spent least on.
    public static TriFunction<List<User>, List<Order>, String, List<User>> getSortedRestaurantByBuyingHistory =
            (restaurants, orders, customerId) -> orders.stream()
            .filter(order -> order.getCustomerId() == customerId)
                    .collect(groupingBy(Order::getRestaurantId))
                    .entrySet()
                    .stream()
                    .sorted((res1, res2) -> {
                        Double res1Price = res1.getValue().stream().mapToDouble(order -> order.getTotalPrice()).sum();
                        Double res2Price = res2.getValue().stream().mapToDouble(order -> order.getTotalPrice()).sum();
                        return (int) (res2Price - res1Price);
                    })
                    .map(group -> getRestaurantById.apply(restaurants, group.getKey()).get())
            .collect(Collectors.toList());
}
