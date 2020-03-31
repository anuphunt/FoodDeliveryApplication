package com.food.service.core.service;

import com.food.service.core.params.BookParam;
import com.food.service.errorhandler.ResourceNotFoundException;

import java.util.List;

public interface BookService {

    void add(BookParam param);
    void update(BookParam param);
    BookParam getOne(long id) throws ResourceNotFoundException;
    List<BookParam> getAll() throws ResourceNotFoundException;
    void delete(long id) throws ResourceNotFoundException;
}
