package com.revature.controllers;

import java.util.Scanner;

import com.revature.services.TransactionService;

public class MenuController {
	private static Scanner scan = new Scanner(System.in);
	private static UserController userController = new UserController();
	private static AccountController accountController = new AccountController();
//	private static TransactionService transactionService = new TransactionService();

	public void welcomeMenu() {
		System.out.println("Welcome to the Banking System");
		System.out.println("Enter your username and password");
		String user = scan.nextLine();
		String password = scan.nextLine();
		String accountType = userController.getRoles(user);
		String accountPassword = userController.getPass(password);
		if(accountType.equals("admin") && accountPassword.equals("Password1")) {
			System.out.println("It worked");
		} else {
			System.out.println("Keep trying");
		}
		System.out.println(
				"What would you like to do? \n" + "1) See Account Options \n" + "2) See User Options \n" + "0) Exit");
		String response = scan.nextLine();
		while (!response.equals("0")) {
			switch (response) {
			case "1":
				accountController.accountMenu();
				break;
			case "2":
				userController.userMenu();
				break;
			case "0":
				System.exit(0);
			default:
				System.out.println("You have entered an invalid selection");
				welcomeMenu();
			}
		}
	}

//	private void accountMenu() {
//		System.out.println("What would you like to do with accounts? \n" + "1) Show all accounts \n"
//				+ "2) Show one account \n" + "3) Display Balance \n" + "4) Withdraw Money \n" + "5) Transfer Money \n"
//				+ "6) Deposit Money \n" + "0) Exit the system");
//		String response = scan.nextLine().toString();
//
//		switch (response) {
//		case "1":
//			accountController.displayAllAccounts();
//			System.out.println("\n");
//			accountMenu();
//			break;
//		case "2":
//			System.out.println("Please enter your account number");
//			String accountNumber = scan.nextLine();
//			accountController.displayOneAccount(accountNumber);
//			System.out.println("\n");
//			accountMenu();
//			break;
//		case "3":
//			System.out.println("Please enter your account number");
//			String accountNumber2 = scan.nextLine();
//			accountController.displayAccountBalance(accountNumber2);
//			System.out.println("\n");
//			accountMenu();
//			break;
//		case "4":
//			System.out.println("Please enter account number to withdraw from");
//			String accountNum = scan.nextLine();
//			System.out.println("Please enter account withdraw ammount");
//			double withdrawAmount = scan.nextDouble();
//			transactionService.getWithdraw(accountNum, withdrawAmount);
//			accountController.displayAccountBalance(accountNum);
//			System.out.println("\n");
//			accountMenu();
//			break;
//		case "5":
//			System.out.println("Please enter account number to transfer from");
//			String accountNum1 = scan.nextLine();
//			System.out.println("Please enter account number to transfer to");
//			String accountNum2 = scan.nextLine();
//			System.out.println("Please enter account transfer ammount");
//			double transferAmount = scan.nextDouble();
//
//			transactionService.getTransfer(accountNum1, accountNum2, transferAmount);
//			accountController.displayAccountBalance(accountNum1);
//			accountController.displayAccountBalance(accountNum2);
//			System.out.println("\n");
//			accountMenu();
//			break;
//		case "6":
//			System.out.println("Please enter account number to deposit");
//			String accountNum3 = scan.nextLine();
//			System.out.println("Please enter account deposit ammount");
//			double depositAmount = scan.nextDouble();
//			transactionService.getDeposit(accountNum3, depositAmount);
//			accountController.displayAccountBalance(accountNum3);
//			System.out.println("\n");
//			accountMenu();
//			break;
//		case "0":
//			System.exit(0);
//		default:
//			System.out.println("You entered and invalid number!");
//			accountMenu();
//			break;

}
