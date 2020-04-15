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
    @BeforeEach
    public void setUp() {
        Food food1 = new Food("food1", "Pizza", 15.5, "Italian Food", "https://images.app.goo.gl/vebgTeEk7Y4Dj2Lg7", "restaurant1", 5, LocalDate.now());
        Food food2 = new Food("food2", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant1", 5, LocalDate.now());
        Food food3 = new Food("food3", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant1", 2, LocalDate.now());
        Food food4 = new Food("food4", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant1", 2, LocalDate.now());
        Food food5 = new Food("food5", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant1", 1, LocalDate.now());
        Food food6 = new Food("food6", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant2", 2, LocalDate.now());
        Food food7 = new Food("food7", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant2", 1, LocalDate.now());
        Food food8 = new Food("food8", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant2", 4, LocalDate.now());
        Food food9 = new Food("food9", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant3", 3, LocalDate.now());
        Food food10 = new Food("food10", "MoMo", 5.5, "Nepali Food", "https://images.app.goo.gl/vxwvS2qsvcKwXueU8", "restaurant3", 5, LocalDate.now());
        foods = Arrays.asList(food1, food2, food3,food4,food5,food6,food7,food8,food9,food10);
    }
    @Test
    public void highlyRatedFoods1(){
        List<Food> result = PradipFunctions.highlyRatedFoods.apply(foods, LocalDate.now());
        assertEquals(2, result.size());

    }
    public void highlyRatedFoods2(){
        List<Food> result = PradipFunctions.highlyRatedFoods.apply(foods, LocalDate.now());
        assertEquals(2, result.size());

    }



    }