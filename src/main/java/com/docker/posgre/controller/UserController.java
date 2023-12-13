package com.docker.posgre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.docker.posgre.model.User;
import com.docker.posgre.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	UserRepository UserR;

	// getAllUsers
	public List<User> getAllUsers() {
		return UserR.findAll();
	}

//Felipe: When error appear "convert to Option", call .get() method before findByID. 
//ok... .get() will deprecate soon. So replace with orElseThrow()	
	@GetMapping("/{id}")
	public User getUsersByID(@PathVariable Long id) {
		return UserR.findById(id).orElseThrow();
	}

	// createUser
	@PostMapping
	public User createUser(@RequestBody User user){
		return UserR.save(user);
	}
}
