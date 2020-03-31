package com.mpp.project.userService.controller;

import com.mpp.project.userService.model.User;
import com.mpp.project.userService.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepo;

//	@GetMapping({ "/","/login"})
//	public String loginForm() {
//
//		return "login";
//	}

	//GetAllUser
	//GetUserById(Long Id)
	//GetUserByUsername(String Username)
	//GetAllRestaurants
	//GetAllCustomers
	//GetAllDrivers
	//AddNewUser(User user)
	//DeleteUser(Long Id)
	//DeleteUser(String Username)
	//UpdateUserInfo(User user)

	
//	@GetMapping("/signup")
//	public String signupForm() {
//
//
//		return "signup";
//	}
//
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
	public Optional<User> getUserById(@PathVariable int id){
		return userRepo.findById(id);
	}

	@GetMapping(path = "/singleUser/{username}")
	public User getUserByUsername(@PathVariable String username){
		Iterable<User> users =  userRepo.findAll();
		for(User u: users){
			if(u.getUsername().equals(username)){
				return u;
			}
		}
		return null;
	}


//
//	@PostMapping(value="/login")
//	public String userLogin(@ModelAttribute User user, HttpSession session) {
//
//		User u = urepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//
//		if(u!=null) {
//
//			session.setAttribute("user", u);
//
//			return "home";
//		}
//
//		return "login";
//	}
}
