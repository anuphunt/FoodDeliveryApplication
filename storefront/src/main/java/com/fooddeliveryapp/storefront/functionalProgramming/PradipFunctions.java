package com.fooddeliveryapp.storefront.functionalProgramming;
import com.fooddeliveryapp.storefront.models.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PradipFunctions {



//    [Pradeep] Get top ten food items ordered in last week and have rating more than 4.
//Get all restaurants that have rating < 2 rated by users.

    public static void main(String[] args) {
        Food food1=new Food("1","B",5.0,"Yummy","sasa","12","5");
        Food food2=new Food("1","B",5.0,"Yummy","sasa","12","5");
        Food food3=new Food("1","B",5.0,"Yummy","sasa","12","5");
        Food food4=new Food("2","A",5.0,"Yummy","sasa","12","4");
        Food food5=new Food("2","A",5.0,"Yummy","sasa","12","4");


        List<Food> foods = Arrays.asList( food1,food2,food3,food4,food5);

        OrderEntity orderentity1= new OrderEntity("1", 2);
        OrderEntity orderentity2 = new OrderEntity("1", 2);

        List<OrderEntity> orderentity=Arrays.asList(orderentity1,orderentity2);
        Order order1=new Order("1","11","21", orderentity,"31",OrderState.ACCEPTED,"1");

        Order order2=new Order("1","11","21",orderentity,"31",OrderState.ACCEPTED,"1");
        Order order3=new Order("1","11","21",orderentity,"31",OrderState.ACCEPTED,"1");

        List<Order> orders = Arrays.asList( order1,order2,order3);
        foods.stream()
                .filter(f->f.getRatings()>=4)
                .limit(10)
                .collect

    }




}
