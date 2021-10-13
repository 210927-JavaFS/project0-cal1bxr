package com.revature.controllers;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Account;
import com.revature.models.Transaction;
import com.revature.services.AccountService;
import com.revature.services.TransactionService;

public class AccountController {
	private AccountService accountService = new AccountService();
	private TransactionService transactionService = new TransactionService();
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
	
	public void accountMenu() {
		System.out.println("What would you like to do with accounts? \n" + "1) Show all accounts \n"
				+ "2) Show one account \n" + "3) Display Balance \n" + "4) Withdraw Money \n" + "5) Transfer Money \n"
				+ "6) Deposit Money \n" + "0) Exit the system");
		String response = scan.nextLine().toString();

		switch (response) {
		case "1":
			displayAllAccounts();
			System.out.println("\n");
			accountMenu();
			break;
		case "2":
			System.out.println("Please enter your account number");
			String accountNumber = scan.nextLine();
			displayOneAccount(accountNumber);
			System.out.println("\n");
			accountMenu();
			break;
		case "3":
			System.out.println("Please enter your account number");
			String accountNumber2 = scan.nextLine();
			displayAccountBalance(accountNumber2);
			System.out.println("\n");
			accountMenu();
			break;
		case "4":
			System.out.println("Please enter account number to withdraw from");
			String accountNum = scan.nextLine();
			System.out.println("Please enter account withdraw ammount");
			double withdrawAmount = scan.nextDouble();
			scan.nextLine();
			transactionService.getWithdraw(accountNum, withdrawAmount);
			displayAccountBalance(accountNum);
			System.out.println("\n");
			accountMenu();
			break;
		case "5":
			System.out.println("Please enter account number to transfer from");
			String accountNum1 = scan.nextLine();
			System.out.println("Please enter account number to transfer to");
			String accountNum2 = scan.nextLine();
			System.out.println("Please enter account transfer ammount");
			double transferAmount = scan.nextDouble();
			scan.nextLine();
			transactionService.getTransfer(accountNum1, accountNum2, transferAmount);
			displayAccountBalance(accountNum1);
			displayAccountBalance(accountNum2);
			System.out.println("\n");
			accountMenu();
			break;
		case "6":
			System.out.println("Please enter account number to deposit");
			String accountNum3 = scan.nextLine();
			System.out.println("Please enter account deposit ammount");
			double depositAmount = scan.nextDouble();
			scan.nextLine();
			transactionService.getDeposit(accountNum3, depositAmount);
			displayAccountBalance(accountNum3);
			System.out.println("\n");
			accountMenu();
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
