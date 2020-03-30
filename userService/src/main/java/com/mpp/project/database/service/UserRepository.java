package com.mpp.project.database.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mpp.project.database.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findByUsernameAndPassword(String un, String psw);
	

}
