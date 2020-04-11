package com.food.service.api.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BookResource {
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
    private List<FoodResource> foods;
    private List<PublisherResource> publishers;
    private List<TagResource> tags;

    private String createdBy;
    private String updatedBy;
}
