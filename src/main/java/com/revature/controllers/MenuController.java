package com.revature.controllers;

import java.util.Scanner;

public class MenuController {
	private static Scanner scan = new Scanner(System.in);
	private static UserController userController = new UserController();
	private static AccountController accountController = new AccountController();

	public void welcomeMenu() {
		System.out.println("Welcome to the Banking System");
		System.out.println("What would you like to do? \n"
				+ "1) See Account Options \n"
				+ "2) See User Options \n" 
				+ "0) Exit");
		String response = scan.nextLine();
		
		while(!response.equals("0")){
			switch(response) {
				case "1":
					accountMenu();
					break;
				case "2":
					userMenu();
					break;
				case "0":
					System.exit(0);
				default:
					System.out.println("You have entered an invalid selection");
					welcomeMenu();
				
					
			}
		}
	}

	private void accountMenu() {
		System.out.println("What would you like to do with accounts? \n" + "1) Show all accounts \n"
				+ "2) Show one account \n" + "3) Display Balance"
						+ "\n" + "0) Exit the system");
		String response = scan.nextLine();

		while (!response.equals("0")) {
			switch (response) {
				case "1":
					accountController.displayAllAccounts();
					System.out.println("\n");
					accountMenu();
					break;
				case "2":
					System.out.println("Please enter your account number");
					String accountNumber = scan.nextLine();
					accountController.displayOneAccount(accountNumber);
					System.out.println("\n");
					accountMenu();
					break;
				case "3":
					System.out.println("Please enter your account number");
					String accountNumber2 = scan.nextLine();
					accountController.displayAccountBalance(accountNumber2);
					System.out.println("\n");
					welcomeMenu();
					break;
				case "0":
					System.exit(0);
				default:
					System.out.println("You entered and invalid number!");
					accountMenu();
					break;		
			}
		}
	}
	
	public void userMenu() {
		System.out.println("what would you like to do with users? \n"
				+ "1) See all users \n"
				+ "2) See one user \n"
				+ "3) Add a user to the system \n"
				+ "4) Approve/Cancel a User account \n"
				+ "5) Return to previous menu \n"
				+ "0) Exit the application");
		
		String response = scan.nextLine();
		
		while(!response.equals("0")) {
			switch(response) {
				case "1":
					userController.showAllUsers();
					userMenu();
					break;
				case "2":
					System.out.println("What user would you like to see?");
					String userName = scan.nextLine();
					userController.showUser(userName);
					userMenu();
					break;
				case "3":
					System.out.println("Will add a user");
					userMenu();
					break;
				case "4":
					System.out.println("Will allow admin to approve deny account");
					userMenu();
					break;
				case "5":
					welcomeMenu();
					break;
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
