package com.fooddeliveryapp.storefront.functionalProgramming;


import com.fooddeliveryapp.storefront.models.*;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class SamsherFunctions {

    //get all users who has already rejected 10 order after order placed
    static TriFunction<List<Order>,List<User>,Integer,  List<User>> mostCanceledUsers = (orders,users, rejectedCount) -> orders
            .stream()
            .collect(Collectors.groupingBy(Order::getCustomerId))
            .entrySet()
            .stream()
            .filter((group)->group.getValue()
                    .stream()
                    .collect(Collectors.collectingAndThen(Collectors.toList(),(list)->{//reversing the list
                        Collections.reverse(list);
                        return list.stream();
                    }))
                    .limit(rejectedCount)
                    .filter((order)->order.getOrderState() == OrderState.REJECTED)
                    .count()>=rejectedCount)
            .map((group)->users
                    .stream()
                    .filter((user)->user.getId() == group.getKey())
                    .findFirst().get())
            .collect(Collectors.toList());

    //get Top n drivers with deliver/cancel ratio
    static BiFunction<List<Order>,List<User>, List<User>> topDrivers = (orders,drivers) -> orders
            .stream()
            .filter(order -> order.getDriverId()!= null)//initially driver is not set just order has been placed
            .collect(Collectors.groupingBy(Order::getDriverId))
            .entrySet()
            .stream()
            .sorted(Comparator.comparing((entrySet)->{//basis of delivered to rejected ratio
                int rejected = (int) entrySet.getValue().stream().filter(order -> order.getOrderState() == OrderState.REJECTED).count();
                int delivered = (int) entrySet.getValue().stream().filter(order -> order.getOrderState() == OrderState.DELIVERED).count();
                return (rejected == 0 && delivered == 0)?0:(delivered/(delivered+rejected));
            }))
            .map((group)->drivers
                    .stream()
                    .filter((user)->user.getId() == group.getKey())
                    .findFirst().get())
            .collect(Collectors.toList());


    static TetraFunction<Double,Double,Double,Double,Double> distanceFormula = (lat1,lon1,lat2,lon2)->{
        Double dLat = Math.toRadians(lat2-lat1);  // deg2rad below
        Double dLon = Math.toRadians(lon2-lon1);
        Double a = Math.sin(dLat/2) * Math.sin(dLat/2) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon/2) * Math.sin(dLon/2);
        return 6371d * 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); // Distance in km
    };

    //get near by reataurents with given radius
    static TetraFunction<List<User>,Double,Double,Double, List<User>> rearestRestaurents = (restaurents,lat,lng,radius) -> restaurents
            .stream()
            .filter((user)->user.getRole() == UserRole.RESTAURANT)
            .filter((res)->{
                return  distanceFormula.apply(lat,lng,res.getLat(),res.getLng())<=radius;
            })
            .collect(Collectors.toList());






}
