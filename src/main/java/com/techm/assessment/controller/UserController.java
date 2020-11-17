package com.techm.assessment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techm.assessment.model.User;
import com.techm.assessment.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService service;
	

	@GetMapping
	private List<User> getUsers() {
		List<User> Userlist=service.getUsers();
		return Userlist;
	}

	// Single item
	@GetMapping("/{id}")
	Optional<User> getUser(@PathVariable Long id) {
		Optional<User> User=	service.getUser(id);
		return User;
	}

	@PostMapping
	private ResponseEntity<User> saveUser(@RequestBody User User) {
		User Userobj=service.saveUser(User);
		return new ResponseEntity<User>(Userobj, HttpStatus.OK);
	}

	@PutMapping("/{id}")
	User updateUser(@RequestBody User newUser, @PathVariable Long id) {
		User Userobj1=service.updatedUser(newUser, id);
		return Userobj1;
	}

	@DeleteMapping("/{id}")
	void deleteUser(@PathVariable Long id) {
		service.deleteUser(id);
	}
}
