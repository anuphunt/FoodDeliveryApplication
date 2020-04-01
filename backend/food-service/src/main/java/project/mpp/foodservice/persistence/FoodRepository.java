package project.mpp.foodservice.persistence;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.mpp.foodservice.domain.Food;

@Repository
public interface FoodRepository extends CrudRepository<Food, Long> {

}
