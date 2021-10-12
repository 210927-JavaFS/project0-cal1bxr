package com.revature.controllers;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.services.AccountService;
import com.revature.services.UserService;

public class AccountController {
	private AccountService accountService = new AccountService();
	private UserService userService = new UserService();
	private Scanner scan = new Scanner(System.in);
	
	public void displayAllAccounts() {
		System.out.println("Here is a list of your accounts");
		List<Account> list = accountService.findAllAccounts();
		for (Account account:list) {
			System.out.println(account);
		}
	}
	
	public void displayOneAccount(String accountNumber) {
		System.out.println("Here is account " + accountNumber + ":");
		Account account = accountService.findByNumber(accountNumber);
		System.out.println(account);
	}
	
//	public void openAccount() {
//		System.out.println("Thank you for adding a new account");
//		System.out.println("What is your first name?");
//		String firstName = scan.nextLine();
//		System.out.println("What is your last name?");
//		String lastName = scan.nextLine();
//		System.out.println("Please enter a user name: ");
//		String userName = scan.nextLine();
//		System.out.println("Please enter a password: ");
//		String userPassword = scan.nextLine();
//		System.out.println("Please enter a intial deposit: ");
//		int intialDeposit = scan.nextInt();
//		int accountNumber = (int)(Math.random()*1000000000);
//		System.out.println("Your account number is " + accountNumber);
//		String accNum = String.valueOf(accountNumber);
//		float accountBalance = 0.0f;
//		
//		
//		Account account = new Account(accNum, userName, accountBalance);
//		User user = new User(firstName, lastName, userName, userPassword);
//		
//		if(accountService.newAccount(account) && userService.newUser(user)) {
//			System.out.println("Your account is open contigant on admin approval.");
//		} else {
//			System.out.println("An error occured. Please try again later. Thanks");
//		}
//	}
//	
	public void displayAccountBalance(String accountNumber) {
		Account account = accountService.getBalance(accountNumber);
		System.out.println(account.accountBalance);
	}

}
