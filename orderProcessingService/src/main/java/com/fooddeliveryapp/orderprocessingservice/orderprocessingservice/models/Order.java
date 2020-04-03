package com.fooddeliveryapp.orderprocessingservice.orderprocessingservice.models;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Order {
       @Id
       private String id;
       private String firstName;
       private List<Food> foods;

       public Order(String id, String firstName, List<Food> foods) {
              this.id = id;
              this.firstName = firstName;
              this.foods = foods;
       }

       public List<Food> getFoods() {
              return foods;
       }

       public void setFoods(List<Food> foods) {
              this.foods = foods;
       }

       public String getId() {
              return id;
       }

       public void setId(String id) {
              this.id = id;
       }

       public String getFirstName() {
              return firstName;
       }

       public void setFirstName(String firstName) {
              this.firstName = firstName;
       }
}
