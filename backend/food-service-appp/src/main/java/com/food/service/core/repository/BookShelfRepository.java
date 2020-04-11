package com.food.service.core.repository;

import com.food.service.core.entity.BookShelfEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface BookShelfRepository  extends JpaRepository<BookShelfEntity, Long> {
}
