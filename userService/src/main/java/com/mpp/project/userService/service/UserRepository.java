package com.mpp.project.userService.service;

import com.mpp.project.userService.Exception.UserNotFoundException;
import com.mpp.project.userService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUsernameAndPassword(String un, String psw);
	User findByUsername(String username) throws UserNotFoundException;

}
