package project.mpp.foodservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import project.mpp.foodservice.domain.Food;
import project.mpp.foodservice.persistence.FoodRepository;
import project.mpp.foodservice.service.FoodService;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
public class FoodServiceApplication {

    @Autowired
    private FoodService service;

    @Autowired
    private FoodRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(FoodServiceApplication.class, args);
    }

    @PostConstruct
    public void checkIfWorks(){
        repository.deleteAll();

        service.create(new Food(1L, "Biryani", 5.00));

        service.create(new Food(2L, "Mo:Mo", 3.50));

        List<Food> findAll = service.findAll();
        for(Food food: findAll)
        {
            System.out.println(food.getId()+":"+food.getName());
        }
    }
}
