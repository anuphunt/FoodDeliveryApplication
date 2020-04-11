package com.food.service.core.service;

import com.food.service.core.params.FoodParam;
import com.food.service.errorhandler.ResourceNotFoundException;

import java.util.List;

public interface FoodService {
    void addFood(FoodParam param);

    List<FoodParam> getAll() throws ResourceNotFoundException;

    void updateFood(FoodParam requestToParam);

    FoodParam getOne(long id) throws ResourceNotFoundException;

    void delete(long id) throws ResourceNotFoundException;
}
