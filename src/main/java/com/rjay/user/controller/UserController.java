package com.rjay.user.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rjay.user.entity.User;
import com.rjay.user.service.UserService;
import com.rjay.user.valueObject.ResponseTemplateVO;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@GetMapping("/")
	public List<User> getUser() {
		return userService.getUser();
	}

	@PutMapping("/{id}")
	public User updateUser(@PathVariable("id") Long userId, @RequestBody User user) {
		return userService.updateService(userId, user);
		
	}
	
	@GetMapping("/{id}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) throws URISyntaxException {
		return userService.getUserWithDepartment(userId);
	}

}
