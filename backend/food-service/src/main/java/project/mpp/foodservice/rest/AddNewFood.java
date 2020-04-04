package project.mpp.foodservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.mpp.foodservice.domain.Food;
import project.mpp.foodservice.persistence.FoodRepository;
import project.mpp.foodservice.service.FoodService;

@RestController
public class AddNewFood {

    @Autowired
    private FoodRepository foodRepository;

    @PostMapping(path="/new")
    Food addNew(@RequestBody Food food) {
        return foodRepository.save(food);
    }
}
