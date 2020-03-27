package com.fooddeliveryapp.storefront.resources;


import com.fooddeliveryapp.storefront.models.User;
import com.fooddeliveryapp.storefront.models.UsersInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(value = "All data regarding users")
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private RestTemplate restTemplate;

    @ApiOperation("Get all users.")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public UsersInfo getAllUsers(){

        List<User> users = new ArrayList<>();
        users.add(new User(111L, "Samsher Rana", "srana@miu.edu", "253-234-234", "234 random street"));
        users.add(new User(112L, "Navin Poudel", "srana@miu.edu", "253-234-234", "234 random street"));
        users.add(new User(113L, "Biswas Mishra", "srana@miu.edu", "253-234-234", "234 random street"));
        users.add(new User(114L, "Pradip Acharya", "srana@miu.edu", "253-234-234", "234 random street"));
        users.add(new User(115L, "Anup Dhakal", "srana@miu.edu", "253-234-234", "234 random street"));

        return new UsersInfo(users);
    }


}
