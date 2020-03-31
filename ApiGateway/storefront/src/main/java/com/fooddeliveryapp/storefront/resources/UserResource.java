package com.fooddeliveryapp.storefront.resources;


import com.fooddeliveryapp.storefront.Constants.ServicesUrl;
import com.fooddeliveryapp.storefront.exceptions.UserNotFoundException;
import com.fooddeliveryapp.storefront.models.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Api(value = "All data regarding users")
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private RestTemplate restTemplate;

    @ApiOperation("Get all users.")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public Iterable<User> getAllUsers() {
        return restTemplate.getForObject(ServicesUrl.userServiceUrl + "/all", Iterable.class);
    }

    @ApiOperation("Get user by id")
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable int id) {
        User user = restTemplate.getForObject(ServicesUrl.userServiceUrl + "/" + id, User.class);
        if (user != null) return user;
        else throw new UserNotFoundException(id);
    }

    @ApiOperation("Get user by username")
    @RequestMapping(value = "/username/{username}", method = RequestMethod.GET)
    public User getUserByUsername(@PathVariable String username) {
        User user = restTemplate.getForObject(ServicesUrl.userServiceUrl + "/singleUser/" + username, User.class);
        if (user != null) return user;
        else throw new UserNotFoundException(username);
    }

    @ApiOperation("Get all restaurants")
    @RequestMapping(value = "/restaurants", method = RequestMethod.GET)
    public Iterable<User> getAllRestaurants() {
//        List<User> dummyUsers = new ArrayList<User>();
//
//        dummyUsers.add(new User(111, "srana", "srana", "Samsher", "Rana", "srana@miu.edu", "253-234-234", "234 random street", UserRole.CUSTOMER));
//        dummyUsers.add(new User(112, "npoudel", "npoudel", "Navin", "Poudel", "srana@miu.edu", "253-234-234", "234 random street", UserRole.ADMIN));
//        dummyUsers.add(new User(113, "bmishra", "bmishra", "Biswas"," Mishra", "srana@miu.edu", "253-234-234", "234 random street", UserRole.RESTAURANT));
//        dummyUsers.add(new User(114, "pacharya", "pacharya","Pradip", "Acharya", "srana@miu.edu", "253-234-234", "234 random street", UserRole.RESTAURANT));
//        dummyUsers.add(new User(115, "adhakal", "adhakal","Anup", "Dhakal", "srana@miu.edu", "253-234-234", "234 random street", UserRole.CUSTOMER));
//
//
//        List<User> result = new ArrayList<User>();
//        for(User user: dummyUsers){
//            if(user.getRole() == UserRole.RESTAURANT){
//                result.add(user);
//            }
//        }
//        return new UsersInfo(result);
        return restTemplate.getForObject(ServicesUrl.userServiceUrl + "/restaurants", Iterable.class);
    }

    @ApiOperation("Get all drivers")
    @RequestMapping(value = "/drivers", method = RequestMethod.GET)
    public Iterable<User> getAllDrivers() {
        return restTemplate.getForObject(ServicesUrl.userServiceUrl + "/drivers", Iterable.class);
    }

    @ApiOperation("Get all customers")
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public Iterable<User> getAllCustomers() {
        return restTemplate.getForObject(ServicesUrl.userServiceUrl + "/customers", Iterable.class);
    }
}
