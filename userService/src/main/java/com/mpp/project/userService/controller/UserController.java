package com.mpp.project.userService.controller;

import com.mpp.project.userService.model.User;
import com.mpp.project.userService.model.UserRole;
import com.mpp.project.userService.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepo;

	@PostMapping("/register")
	public User register(@RequestBody User user) {
		userRepo.save(user);
		return user;
	}

	@GetMapping(path = "/all")
	public Iterable<User> getAllUsers(){
		return userRepo.findAll();
	}

	@GetMapping(path = "/{id}")
	public Optional<User> getUserById(@PathVariable int id)
	{
		return userRepo.findById(id);
	}

	@GetMapping(path = "/singleuser/{username}")
	public User getUserByUsername(@PathVariable String username){
		Iterable<User> users =  userRepo.findAll();
		for(User u: users){
			if(u.getUsername().equals(username)){
				u.setPassword(null);
				return u;
			}
		}
		return null;
	}

	@GetMapping(path = "/restaurants")
	public Iterable<User> getAllRestaurants(){
		List<User> restaurants = new ArrayList<>();
		List<User> allUsers = userRepo.findAll();
		for(User u: allUsers){
			String role = u.getRole();
			if(role != null && role.equals(UserRole.RESTAURANT.toString())){
				restaurants.add(u);
			}
		}
		return restaurants;
	}

	@GetMapping(path = "/drivers")
	public Iterable<User> getAllDrivers(){
		List<User> drivers = new ArrayList<>();
		List<User> allUsers = userRepo.findAll();
		for(User u: allUsers){
			String role = u.getRole();
			if(role != null && role.equals(UserRole.DRIVER.toString())){
				drivers.add(u);
			}
		}
		return drivers;
	}

	@GetMapping(path ="/customers")
	public Iterable<User> getAllCustomers(){
		List<User> customers = new ArrayList<>();
		List<User> allUsers = userRepo.findAll();
		for(User u: allUsers){
			String role = u.getRole();
			if(role != null && role.equals(UserRole.CUSTOMER)){
				customers.add(u);
			}
		}
		return customers;
	}

	@GetMapping(path ="/admins")
	public Iterable<User> getAllAdmins(){
		List<User> admins = new ArrayList<>();
		List<User> allUsers = userRepo.findAll();
		for(User u: allUsers){
			String role = u.getRole();
			if(role != null && role.equals(UserRole.ADMIN)){
				admins.add(u);
			}
		}
		return admins;
	}

	@DeleteMapping(value = "delete/{id}")
	public Optional<User> deleteUserById(@PathVariable int id){
		Optional<User> user = getUserById(id);
		userRepo.deleteById(id);
		return user;
	}
}
