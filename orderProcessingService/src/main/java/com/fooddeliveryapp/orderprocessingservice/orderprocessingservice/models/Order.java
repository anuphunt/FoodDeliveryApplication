package com.fooddeliveryapp.orderprocessingservice.orderprocessingservice.models;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class Order {
       @Id
       private String id;
       private List<OrderEntity> foods = new ArrayList<OrderEntity>();

       public Order(String id, List<OrderEntity> foods) {
              this.id = id;
              this.foods = foods;
       }

       public List<OrderEntity> getFoods() {
              return foods;
       }

       public void setFoods(List<OrderEntity> foods) {
              this.foods = foods;
       }

       public String getId() {
              return id;
       }

       public void setId(String id) {
              this.id = id;
       }

}
