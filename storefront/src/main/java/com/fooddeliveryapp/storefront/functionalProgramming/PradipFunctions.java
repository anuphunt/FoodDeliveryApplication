package com.fooddeliveryapp.storefront.functionalProgramming;

import com.fooddeliveryapp.storefront.models.*;

import java.time.LocalDate;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class PradipFunctions {
//    Get top ten food items ordered in last week and have rating more than 4

    public static BiFunction<List<Food>, LocalDate,List<Food>> highlyRatedFoods=(food, date)->food.stream()
    .filter(f->f.getRating()>=4&& date.getYear()==LocalDate.now().getYear() && date.getMonth()==LocalDate.now().getMonth())
            .limit(2)
            .collect(Collectors.toList());
//    Get all restaurants that have rating < 2 rated by users.


}
