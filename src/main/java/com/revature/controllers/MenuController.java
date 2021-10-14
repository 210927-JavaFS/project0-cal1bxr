package com.revature.controllers;

import java.util.Scanner;

public class MenuController {
	private static Scanner scan = new Scanner(System.in);
	private static UserController userController = new UserController();
//	private static TransactionService transactionService = new TransactionService();

	public void welcomeMenu() {
		System.out.println("Welcome to the Banking System");
		System.out.println("Enter your username and password");
		String user = scan.nextLine();
		String password = scan.nextLine();
		String accountType = userController.getRoles(user);
		String accountPassword = userController.getPass(user);
		if (accountType.equals("customer") && accountPassword.equals(password)) {
			userController.customerMenu();
		} else if (accountType.equals("employee") && accountPassword.equals(password)) {
			userController.employeeMenu();
		} else if (accountType.equals("admin") && accountPassword.equals(password)) {
			userController.adminMenu();
		} else {
			System.out.println("Not a valid user");
		}
		
	}

}
