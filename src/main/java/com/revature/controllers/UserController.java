package com.revature.controllers;

import java.util.List;

import com.revature.models.User;
import com.revature.services.UserService;

public class UserController {
	private UserService userService = new UserService();
	
	public void showAllUsers() {
		System.out.println("Here are all the users");
		List<User> list = userService.findAllAccounts();
		for(User user:list) {
			System.out.println(user);
		}
	}
	
	public void showUser(String userName) {

		User user = userService.findByUsername(userName);
		System.out.println(user);
	}
}
