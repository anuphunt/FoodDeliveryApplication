package com.food.service.core.params;

import com.food.service.core.enums.Status;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BookParam {
    private long id;

    private String name;
    private String isbn;
    private String overview;
    private Date dateOfPublish;
    private Date dateOfReprint;
    private String acknowledgement;
    private String copyright;
    private String fact;
    private String printedBy;
    private String coverDesigner;
    private String coverPhotoUrl;
    private double price;
    private List<FoodParam> foods;
    private List<PublisherParam> publishers;
    private List<TagParam> tags;

    private String createdBy;
    private String updatedBy;
    private Status status;
}
