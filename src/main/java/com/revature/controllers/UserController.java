package com.revature.controllers;

import java.util.List;
import java.util.Scanner;

import com.revature.models.User;
import com.revature.services.UserService;

public class UserController {
	Scanner scan = new Scanner(System.in);
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
	
	public String getRoles(String username) {
		User user = userService.userRole(username);
		return user.getRole();
	}
	
	public String getPass(String password) {
		User user = userService.userPassword(password);
		return user.getPassword();
	}
	
	public void userMenu() {
		System.out.println("what would you like to do with users? \n" + "1) See all users \n" + "2) See one user \n"
				+ "3) Add a user to the system \n" + "4) Approve/Cancel a User account \n"
				+ "5) Return to previous menu \n" + "0) Exit the application");

		String response = scan.nextLine();

		while (!response.equals("9")) {
			switch (response) {
			case "1":				
				showAllUsers();
				userMenu();
				break;
			case "2":
				System.out.println("What user would you like to see?");
				String userName = scan.nextLine();
				showUser(userName);
				userMenu();
				break;
			case "3":
				System.out.println("Will add a user");
				userMenu();
				break;
			case "4":
				System.out.println("Enter username you would like to see role for");
				String userName1 = scan.nextLine();
				getRoles(userName1);
				userMenu();
				break;
//			case "5":
//				welcomeMenu();
//				break;
			case "0":
				System.exit(0);
			default:
				System.out.println("You have enter and invalid selection!");
				userMenu();
				break;
			}
		}

	}
}
