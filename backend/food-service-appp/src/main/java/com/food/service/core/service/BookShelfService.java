package com.food.service.core.service;

import com.food.service.core.params.BookShelfParam;
import com.food.service.errorhandler.ResourceNotFoundException;

import java.util.List;

public interface BookShelfService {
    void add(BookShelfParam param);
    void update(BookShelfParam param);
    BookShelfParam getOne(long id) throws ResourceNotFoundException;
    List<BookShelfParam> getAll() throws ResourceNotFoundException;
    void delete(long id) throws ResourceNotFoundException;
}
