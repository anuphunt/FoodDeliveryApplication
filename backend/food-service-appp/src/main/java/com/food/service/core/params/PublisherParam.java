package com.food.service.core.params;

import com.food.service.core.enums.Status;
import lombok.Data;

@Data
public class PublisherParam {

    private long id;
    private String name;
    private String address;
    private String mobile;
    private String contactPersonName;
    private String contactPersonMobile;
    private String website;
    private String email;
    private String facebookPage;
    private String about;
    private String background;
    private String createdBy;
    private String updatedBy;
    private Status status;
}
