package com.food.service.core.service;

import com.food.service.core.params.TagParam;
import com.food.service.errorhandler.ResourceNotFoundException;

import java.util.List;

public interface TagService {
    void add(TagParam param);
    void update(TagParam param);
    TagParam getTag(long id) throws ResourceNotFoundException;
    List<TagParam> getAll() throws ResourceNotFoundException;
    void delete(long id) throws ResourceNotFoundException;
}
