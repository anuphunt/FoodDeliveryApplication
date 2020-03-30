package com.fooddeliveryapp.storefront.models;

import java.util.List;

public class FoodsInfo {
    private List<Food> listOfFoods;

    public FoodsInfo(List<Food> listOfFoods) {
        this.listOfFoods = listOfFoods;
    }

    public List<Food> getListOfFoods() {
        return listOfFoods;
    }

    public void setListOfFoods(List<Food> listOfFoods) {
        this.listOfFoods = listOfFoods;
    }
}
