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

    public Food(Long id, @NotNull String name, @NotNull Double price){
        this.id = id;
        this.name=name;
        this.price=price;
    }



}
