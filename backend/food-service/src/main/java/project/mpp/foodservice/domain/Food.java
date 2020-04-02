package project.mpp.foodservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Food {
    public Long getId() {
        return this.id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Double price;

    private String description;
    private String imageUrl;
    private Integer restaurantId;


    public Food(){
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public Food(Long id, @NotNull String name, @NotNull Double price, String description, String imageurl, Integer restaurantId){
        this.id = id;
        this.name=name;
        this.price=price;
        this.description=description;
        this.imageUrl = imageurl;
        this.restaurantId = restaurantId;
    }



}
