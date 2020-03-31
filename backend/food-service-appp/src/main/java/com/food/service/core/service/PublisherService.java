package com.food.service.core.service;

import com.food.service.core.params.PublisherParam;
import com.food.service.errorhandler.ResourceNotFoundException;

import java.util.List;

public interface PublisherService {
    void addPublisher(PublisherParam param);

    List<PublisherParam> getAll() throws ResourceNotFoundException;

    void updatePublisher(PublisherParam requestToParam);

    PublisherParam getOne(long id) throws ResourceNotFoundException;

    void delete(long id) throws ResourceNotFoundException;
}
