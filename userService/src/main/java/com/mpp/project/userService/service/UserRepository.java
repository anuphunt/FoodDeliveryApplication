package com.mpp.project.userService.service;

import com.mpp.project.userService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUsernameAndPassword(String un, String psw);
	

}
