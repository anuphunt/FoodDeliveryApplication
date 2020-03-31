package com.food.service.core.repository;

import com.food.service.core.entity.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface FoodRepository extends JpaRepository<FoodEntity, Long> {
}
