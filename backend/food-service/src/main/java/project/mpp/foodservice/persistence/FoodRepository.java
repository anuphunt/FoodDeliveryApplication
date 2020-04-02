package project.mpp.foodservice.persistence;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.mpp.foodservice.domain.Food;

import java.util.List;

@Repository
public interface FoodRepository extends CrudRepository<Food, Long> {

    Iterable<Food> findAllFoodByRestaurantId(Integer restaurantId);

}