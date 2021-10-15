package com.revature.controllers;

public class MenuController {
	private static UserController userController = new UserController();
//	private static TransactionService transactionService = new TransactionService();

	public void welcomeMenu() {
		System.out.println("Welcome to the Banking System");
		userController.userLogin();

	}

}
