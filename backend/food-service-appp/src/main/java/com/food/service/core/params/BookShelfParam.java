package com.food.service.core.params;

import com.food.service.core.enums.Status;
import lombok.Data;

@Data
public class BookShelfParam {
    private long id;
    private String name;
    private String category;
    private long capability;
    private Status status;
    private String createdBy;
    private String updatedBy;
}
