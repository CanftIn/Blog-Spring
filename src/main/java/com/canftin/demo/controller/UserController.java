package com.canftin.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canftin.demo.domain.User;

@RestController
@RequestMapping("/users")
public class UserController {

	@RequestMapping("/{id}")
	public User getUser(@PathVariable("id") Long id) {
		return new User(id, "CanftIn", "wwc7033@gmail.com");
	}
}
