package com.food.service.util;

import com.food.service.api.model.*;
import com.food.service.core.params.*;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RequestAndParamBuilder {

    public FoodParam requestToParam(FoodResource foodResource){

        FoodParam param = new FoodParam();
        param.setId(foodResource.getId());
        param.setName(foodResource.getName());
        param.setNickname(foodResource.getNickname());
        param.setAddress(foodResource.getAddress());
        param.setBiography(foodResource.getBiography());
        param.setBackground(foodResource.getBackground());
        param.setEmail(foodResource.getEmail());
        param.setMobile(foodResource.getMobile());
        param.setBirthDate(foodResource.getBirthDate());
        param.setCountry(foodResource.getCountry());
        param.setCreatedBy(foodResource.getCreatedBy());
        param.setUpdatedBy(foodResource.getUpdatedBy());
        return param;

    }

    public FoodResource paramToRequest(FoodParam param){

        FoodResource resource = new FoodResource();
        resource.setId(param.getId());
        resource.setName(param.getName());
        resource.setNickname(param.getNickname());
        resource.setAddress(param.getAddress());
        resource.setBiography(param.getBiography());
        resource.setBackground(param.getBackground());
        resource.setEmail(param.getEmail());
        resource.setMobile(param.getMobile());
        resource.setBirthDate(param.getBirthDate());
        resource.setCountry(param.getCountry());
        resource.setCreatedBy(param.getCreatedBy());
        resource.setUpdatedBy(param.getUpdatedBy());
        return resource;
    }

    public PublisherResource publisherParamToResource(PublisherParam param){
        PublisherResource publisherResource = new PublisherResource();

        publisherResource.setId(param.getId());
        publisherResource.setName(param.getName());
        publisherResource.setMobile(param.getMobile());
        publisherResource.setAbout(param.getAbout());
        publisherResource.setAddress(param.getAddress());
        publisherResource.setContactPersonName(param.getContactPersonName());
        publisherResource.setContactPersonMobile(param.getContactPersonMobile());
        publisherResource.setEmail(param.getEmail());
        publisherResource.setFacebookPage(param.getFacebookPage());
        publisherResource.setWebsite(param.getWebsite());
        publisherResource.setCreatedBy(param.getCreatedBy());
        publisherResource.setUpdatedBy(param.getUpdatedBy());

        return publisherResource;
    }

    public PublisherParam publisherResourceToParam(PublisherResource publisherResource){
        PublisherParam param = new PublisherParam();

        param.setId(publisherResource.getId());
        param.setName(publisherResource.getName());
        param.setMobile(publisherResource.getMobile());
        param.setAbout(publisherResource.getAbout());
        param.setAddress(publisherResource.getAddress());
        param.setContactPersonName(publisherResource.getContactPersonName());
        param.setContactPersonMobile(publisherResource.getContactPersonMobile());
        param.setEmail(publisherResource.getEmail());
        param.setFacebookPage(publisherResource.getFacebookPage());
        param.setWebsite(publisherResource.getWebsite());
        param.setCreatedBy(publisherResource.getCreatedBy());
        param.setUpdatedBy(publisherResource.getUpdatedBy());

        return param;
    }


    public TagResource tagParamToResource(TagParam param){
        TagResource resource = new TagResource();

        resource.setId(param.getId());
        resource.setName(param.getName());
        resource.setCategory(param.getCategory());
        resource.setCreatedBy(param.getCreatedBy());
        resource.setUpdatedBy(param.getUpdatedBy());

        return resource;
    }

    public TagParam tagResourceToParam(TagResource tagResource){
        TagParam param = new TagParam();

        param.setId(tagResource.getId());
        param.setName(tagResource.getName());
        param.setCategory(tagResource.getCategory());
        param.setCreatedBy(tagResource.getCreatedBy());
        param.setUpdatedBy(tagResource.getUpdatedBy());

        return param;
    }


    public BookShelfResource bookShelfParamToResource(BookShelfParam param){
        BookShelfResource resource = new BookShelfResource();

        resource.setId(param.getId());
        resource.setName(param.getName());
        resource.setCategory(param.getCategory());
        resource.setCapability(param.getCapability());
        resource.setCreatedBy(param.getCreatedBy());
        resource.setUpdatedBy(param.getUpdatedBy());

        return resource;
    }

    public BookShelfParam bookShelfResourceToParam(BookShelfResource bookShelfResource){
        BookShelfParam param = new BookShelfParam();

        param.setId(bookShelfResource.getId());
        param.setName(bookShelfResource.getName());
        param.setCategory(bookShelfResource.getCategory());
        param.setCapability(bookShelfResource.getCapability());
        param.setCreatedBy(bookShelfResource.getCreatedBy());
        param.setUpdatedBy(bookShelfResource.getUpdatedBy());

        return param;
    }


    public BookResource bookParamToResource(BookParam param){
        BookResource resource = new BookResource();

        resource.setId(param.getId());
        resource.setName(param.getName());

        resource.setAcknowledgement(param.getAcknowledgement());
        resource.setCopyright(param.getCopyright());
        resource.setCoverDesigner(param.getCoverDesigner());
        resource.setCoverPhotoUrl(param.getCoverPhotoUrl());
        resource.setDateOfPublish(param.getDateOfPublish());
        resource.setDateOfReprint(param.getDateOfReprint());
        resource.setFact(param.getFact());
        resource.setIsbn(param.getIsbn());
        resource.setOverview(param.getOverview());
        resource.setPrice(param.getPrice());
        resource.setPrintedBy(param.getPrintedBy());
        resource.setFoods(param.getFoods().stream()
                .map(x -> paramToRequest(x))
                .collect(Collectors.toList()));
        resource.setPublishers(param.getPublishers().stream()
                .map(x -> publisherParamToResource(x))
                .collect(Collectors.toList()));
        resource.setTags(param.getTags().stream()
                .map(x -> tagParamToResource(x))
                .collect(Collectors.toList()));

        resource.setCreatedBy(param.getCreatedBy());
        resource.setUpdatedBy(param.getUpdatedBy());

        return resource;
    }

    public BookParam bookResourceToParam(BookResource resource){
        BookParam param = new BookParam();

        param.setId(resource.getId());
        param.setName(resource.getName());

        param.setAcknowledgement(resource.getAcknowledgement());
        param.setCopyright(resource.getCopyright());
        param.setCoverDesigner(resource.getCoverDesigner());
        param.setCoverPhotoUrl(resource.getCoverPhotoUrl());
        param.setDateOfPublish(resource.getDateOfPublish());
        param.setDateOfReprint(resource.getDateOfReprint());
        param.setFact(resource.getFact());
        param.setIsbn(resource.getIsbn());
        param.setOverview(resource.getOverview());
        param.setPrice(resource.getPrice());
        param.setPrintedBy(resource.getPrintedBy());
        param.setFoods(resource.getFoods().stream()
                .map(x -> requestToParam(x))
                .collect(Collectors.toList()));
        param.setPublishers(resource.getPublishers().stream()
                .map(x -> publisherResourceToParam(x))
                .collect(Collectors.toList()));
        param.setTags(resource.getTags().stream()
                .map(x -> tagResourceToParam(x))
                .collect(Collectors.toList()));

        param.setCreatedBy(resource.getCreatedBy());
        param.setUpdatedBy(resource.getUpdatedBy());

        return param;
    }
}
