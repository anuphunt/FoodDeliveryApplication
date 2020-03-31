package com.food.service.api.model;

import com.food.service.core.enums.Status;
import lombok.Data;

@Data
public class TagResource {
    private long id;
    private String name;
    private String category;
    private Status status;
    private String createdBy;
    private String updatedBy;
}
