package com.fooddeliveryapp.storefront.functionalProgramming;

import com.fooddeliveryapp.storefront.models.Food;
import com.fooddeliveryapp.storefront.models.User;

import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
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
    

}
