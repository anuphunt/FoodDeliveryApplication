package com.fooddeliveryapp.storefront.functionalProgramming;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fooddeliveryapp.storefront.models.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class PradipFunctionsTest {
    public List<Food> foods;

    public List<User> restaurants;
    @BeforeEach
    public void setUp() {
        Food food1 = new Food("food1", "Pizza", 15.5, "Italian Food", "https://images.app.goo.gl/vebgTeEk7Y4Dj2Lg7", "restaurant2", 5, LocalDate.now());
        Food food2 = new Food("food2", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant2", 5, LocalDate.now());
        Food food3 = new Food("food3", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant1", 2, LocalDate.now());
        Food food4 = new Food("food4", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant1", 2, LocalDate.now());
        Food food5 = new Food("food5", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant1", 1, LocalDate.now());
        Food food6 = new Food("food6", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant1", 2, LocalDate.now());
        Food food7 = new Food("food7", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant1", 1, LocalDate.now());
        Food food8 = new Food("food8", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant2", 2, LocalDate.now());
        Food food9 = new Food("food9", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant3", 3, LocalDate.now());
        Food food10 = new Food("food10", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant3", 5, LocalDate.now());
        foods = Arrays.asList(food1, food2, food3,food4,food5,food6,food7,food8,food9,food10);

        User restaurant1 = new User("restaurant1", "sham.sher", "user1", "Shamsher", "Rana", "example@example.com", "9999999999", "Fairfield", UserRole.RESTAURANT, 1);
        User restaurant2 = new User("restaurant1", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.RESTAURANT, 1);
        User restaurant3 = new User("restaurant1", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.RESTAURANT, 1);
        User restaurant4 = new User("restaurant1", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.RESTAURANT, 1);
        User restaurant5 = new User("restaurant1", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.RESTAURANT, 1);
        User restaurant6 = new User("restaurant6", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.RESTAURANT, 4);
        User restaurant7 = new User("restaurant7", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.RESTAURANT, 2);
        User restaurant8 = new User("restaurant8", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.RESTAURANT, 1);
        User restaurant9 = new User("restaurant9", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.RESTAURANT, 4);
        User restaurant10 = new User("restaurant10", "navin.paudel", "user2", "Navin", "Paudel", "example@example.com", "9999999999", "Des Moines", UserRole.RESTAURANT, 3);
        restaurants = Arrays.asList(restaurant1, restaurant2, restaurant3,restaurant4,restaurant5,restaurant6,restaurant7,restaurant8,restaurant9,restaurant10 );
    }
    @Test
    public void highlyRatedFoods1(){
        List<Food> result = PradipFunctions.highlyRatedFoods.apply(foods, LocalDate.now());
        assertEquals(2, result.size());

    }
    @Test
    public void lowRatedRestaurants1(){
        List<User> result = PradipFunctions.lowRatedRestaurants.apply(restaurants,foods,5,5);
        assertEquals(1, result.size());

    }



    }