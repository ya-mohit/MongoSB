package com.mohit.MongoSB.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.MongoSB.entity.UserEntity;
import com.mohit.MongoSB.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping("/")
	public List<UserEntity> getStudentName() {
		return userService.findAllUsers();
	}
	
	@GetMapping("/{id}")
	public List<UserEntity> getStudentNameById(@PathVariable("id") long id) {
		return userService.findUserById(id);
	}
	
	@PostMapping("/addUser")
	public boolean addUser(@RequestBody List<UserEntity> users) {
		return userService.addUser(users);
	}
	
	@PostMapping("/deleteUser")
	public boolean deleteUser(@RequestParam("userId") long userId) {
		return userService.deleteUser(userId);
	}
	
	@PutMapping("/editUser")
	public boolean editUser(@RequestBody List<UserEntity> users) {
		return userService.editUser(users);
	}
}
