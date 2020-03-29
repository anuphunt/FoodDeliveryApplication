package com.fooddeliveryapp.storefront.resources;


import com.fooddeliveryapp.storefront.models.User;
import com.fooddeliveryapp.storefront.models.UsersInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api(value = "All data regarding users")
@RequestMapping("/users")
public class UserResource {

    List<User> users = new ArrayList<>();

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

    @ApiOperation("Register new user")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public User registerUser(@RequestBody User user){
        users.add(user);
        return user;
    }

    @ApiOperation("Get user by id")
    @RequestMapping(value = "{id}", method= RequestMethod.GET)
    public User getUser(@PathVariable Long id){
        User user = null;

        for(User u: users){
            if(u.getUserId() == id){
                user = u;
            }
        }
        return user;
    }

    @ApiOperation("Log in")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public LoginResponse login(@RequestBody LoginRequest request){
        return new LoginResponse(true, "alsfsdlfjsdfljsdfl", "Login Success");
    }
}
