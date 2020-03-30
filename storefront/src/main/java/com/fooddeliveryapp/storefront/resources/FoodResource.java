package com.fooddeliveryapp.storefront.resources;

import com.fooddeliveryapp.storefront.exceptions.FoodNotFoundException;
import com.fooddeliveryapp.storefront.models.Food;
import com.fooddeliveryapp.storefront.models.FoodsInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sun.awt.FontDescriptor;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(value = "All data regarding foods")
@RequestMapping("/foods")
public class FoodResource {
    public List<Food> foods = new ArrayList<>();

    @Autowired
    private RestTemplate restTemplate;

    @ApiOperation("Get all foods.")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public FoodsInfo getAllFoods(){
        List<Food> foods = new ArrayList<>();
        foods.add(new Food(1L, "Hamburger", "Delicious grilled hamburger", "image.url", 12L));
        foods.add(new Food(2L, "Sandwich", "Delicious grilled sandwich", "image.url", 12L));
        foods.add(new Food(3L, "Chicken Curry", "Delicious chick curry", "image.url", 12L));
        foods.add(new Food(4L, "Beef Steak", "Delicious beef steak", "image.url", 12L));
        foods.add(new Food(5L, "Thai food", "Delicious Thai Food", "image.url", 12L));

        return new FoodsInfo(foods);
    }

    @ApiOperation("Get food by id.")
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Food getFoodById(@PathVariable Long id) {

        List<Food> dummyFoods = new ArrayList<>();
        dummyFoods.add(new Food(1L, "Hamburger", "Delicious grilled hamburger", "image.url", 12L));
        dummyFoods.add(new Food(2L, "Sandwich", "Delicious grilled sandwich", "image.url", 12L));
        dummyFoods.add(new Food(3L, "Chicken Curry", "Delicious chick curry", "image.url", 12L));
        dummyFoods.add(new Food(4L, "Beef Steak", "Delicious beef steak", "image.url", 12L));
        dummyFoods.add(new Food(5L, "Thai food", "Delicious Thai Food", "image.url", 12L));


        for (Food food : dummyFoods) {
            if (food.getFoodId() == id) {
                return food;
            }
        }
        throw new FoodNotFoundException(id);
    }

    @ApiOperation("Get all foods of one restaurant with restaurant ID")
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public FoodsInfo getAllFoodsOfRestaurant(@PathVariable Long id){
        List<Food> dummyFoods = new ArrayList<>();

        dummyFoods.add(new Food(1L, "Hamburger", "Delicious grilled hamburger", "image.url", 12L));
        dummyFoods.add(new Food(2L, "Sandwich", "Delicious grilled sandwich", "image.url", 12L));
        dummyFoods.add(new Food(3L, "Chicken Curry", "Delicious chick curry", "image.url", 12L));
        dummyFoods.add(new Food(4L, "Beef Steak", "Delicious beef steak", "image.url", 12L));
        dummyFoods.add(new Food(5L, "Thai food", "Delicious Thai Food", "image.url", 12L));

        List<Food> result = new ArrayList<>();
        for(Food food: dummyFoods){
            if(food.getRestaurantId()== id){
                result.add(food);
            }
        }
        return new FoodsInfo(result);

    }
}
