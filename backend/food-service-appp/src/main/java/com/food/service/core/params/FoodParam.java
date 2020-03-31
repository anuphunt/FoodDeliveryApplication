package com.food.service.core.params;

import com.food.service.core.enums.Status;
import lombok.Data;

import java.util.Date;

@Data
public class FoodParam {
    private long id;
    private String name;
    private String email;
    private String mobile;
    private String address;
    private Date birthDate;
    private String country;
    private String biography;
    private String background;
    private String nickname;
    private String createdBy;
    private String updatedBy;
    private Status status;
}
