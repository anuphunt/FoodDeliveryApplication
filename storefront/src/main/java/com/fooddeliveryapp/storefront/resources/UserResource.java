package com.fooddeliveryapp.storefront.resources;


import com.fooddeliveryapp.storefront.models.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api(value = "All data regarding users")
@RequestMapping("/users")
public class UserResource {

    public static List<User> users = new ArrayList<>();

    @Autowired
    private RestTemplate restTemplate;

    @ApiOperation("Get all users.")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public UsersInfo getAllUsers(){

        List<User> users = new ArrayList<>();
        users.add(new User(111L, "srana", "srana", "Samsher", "Rana", "srana@miu.edu", "253-234-234", "234 random street", UserRole.CUSTOMER));
        users.add(new User(112L, "npoudel", "npoudel", "Navin", "Poudel", "srana@miu.edu", "253-234-234", "234 random street", UserRole.ADMIN));
        users.add(new User(113L, "bmishra", "bmishra", "Biswas"," Mishra", "srana@miu.edu", "253-234-234", "234 random street", UserRole.RESTAURANT));
        users.add(new User(114L, "pacharya", "pacharya","Pradip", "Acharya", "srana@miu.edu", "253-234-234", "234 random street", UserRole.RESTAURANT));
        users.add(new User(115L, "adhakal", "adhakal","Anup", "Dhakal", "srana@miu.edu", "253-234-234", "234 random street", UserRole.CUSTOMER));

        return new UsersInfo(users);
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

    @ApiOperation("Get all restaurants")
    @RequestMapping(value ="/restaurants", method = RequestMethod.POST)
    public UsersInfo getAllRestaurants(){
        List<User> dummyUsers = new ArrayList<User>();

        dummyUsers.add(new User(111L, "srana", "srana", "Samsher", "Rana", "srana@miu.edu", "253-234-234", "234 random street", UserRole.CUSTOMER));
        dummyUsers.add(new User(112L, "npoudel", "npoudel", "Navin", "Poudel", "srana@miu.edu", "253-234-234", "234 random street", UserRole.ADMIN));
        dummyUsers.add(new User(113L, "bmishra", "bmishra", "Biswas"," Mishra", "srana@miu.edu", "253-234-234", "234 random street", UserRole.RESTAURANT));
        dummyUsers.add(new User(114L, "pacharya", "pacharya","Pradip", "Acharya", "srana@miu.edu", "253-234-234", "234 random street", UserRole.RESTAURANT));
        dummyUsers.add(new User(115L, "adhakal", "adhakal","Anup", "Dhakal", "srana@miu.edu", "253-234-234", "234 random street", UserRole.CUSTOMER));


        List<User> result = new ArrayList<User>();
        for(User user: dummyUsers){
            if(user.getRole() == UserRole.RESTAURANT){
                result.add(user);
            }
        }
        return new UsersInfo(result);
    }

}
