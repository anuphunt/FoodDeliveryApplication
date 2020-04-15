package com.fooddeliveryapp.storefront.functionalProgramming;

import com.fooddeliveryapp.storefront.models.*;

import java.time.LocalDate;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PradipFunctions {

    //    Get top ten food items ordered in last week and have rating more than 4

    public static BiFunction<List<Food>, LocalDate, List<Food>> highlyRatedFoods = (food, date) -> food.stream()
            .filter(f -> f.getRating() >= 4 && date.getYear() == LocalDate.now().getYear() && date.getMonth() == LocalDate.now().getMonth())
            .limit(2)
            .collect(Collectors.toList());

    // Get all restaurants that have rate less than 2 but foods more than x
    public static TetraFunction<List<User>,List<Food>,Integer,Integer, List<User>> lowRatedRestaurants = (restaurants,foods,min_rate,no_foods)->foods
        .stream()
        .collect(Collectors.groupingBy(Food::getRestaurantId))
        .entrySet()
        .stream()
        .filter((restaurantFoods)->restaurantFoods.getValue().size()>=no_foods)
        .map((restaurantFoods)->restaurants.stream().filter(restaurant->restaurant.getId() == restaurantFoods.getKey()).findFirst().get())
            .filter((res)->res.getRating()<=min_rate)
            .collect(Collectors.toList());
}