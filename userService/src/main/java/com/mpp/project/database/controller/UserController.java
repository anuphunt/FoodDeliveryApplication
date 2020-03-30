package com.mpp.project.database.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mpp.project.database.model.User;
import com.mpp.project.database.service.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository urepo;

	@GetMapping({ "/","/login"})
	public String loginForm() {
		
		return "login";
	}
	
	@GetMapping("/signup")
	public String signupForm() {
		
		
		return "signup";
	}
	
	@PostMapping("/signup")
	public String saveUser(@ModelAttribute User user) {
		
		urepo.save(user);
		
		return "login";
	}
	
	@PostMapping(value="/login")
	public String userLogin(@ModelAttribute User user, HttpSession session) {
		
		User u = urepo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		
		if(u!=null) {
			
			session.setAttribute("user", u);
			
			return "home";
		}
		
		return "login";
	}
}
