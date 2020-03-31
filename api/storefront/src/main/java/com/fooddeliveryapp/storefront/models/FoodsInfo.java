package com.fooddeliveryapp.storefront.models;

import java.util.List;

public class FoodsInfo {
    private List<FoodItem> listOfFoods;

    public FoodsInfo(List<FoodItem> listOfFoods) {
        this.listOfFoods = listOfFoods;
    }

    public List<FoodItem> getListOfFoods() {
        return listOfFoods;
    }

    public void setListOfFoods(List<FoodItem> listOfFoods) {
        this.listOfFoods = listOfFoods;
    }
}
