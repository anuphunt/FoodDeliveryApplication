package project.mpp.foodservice.rest;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import project.mpp.foodservice.domain.Food;

import project.mpp.foodservice.persistence.FoodRepository;
import project.mpp.foodservice.service.FoodService;

@RestController
public class GetFood {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private FoodService service;

    @GetMapping("/getfoodbyid")
    public Food greeting(@RequestParam(value = "id", defaultValue = "5") Long id) {
        Food foodById = service.findById((long)id);
        return new Food(foodById.getId(), foodById.getName(), foodById.getPrice());
    }
}
