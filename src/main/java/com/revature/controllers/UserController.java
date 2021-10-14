package com.revature.controllers;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.services.AccountService;
import com.revature.services.TransactionService;
import com.revature.services.UserService;

public class UserController {
	Scanner scan = new Scanner(System.in);
	private UserService userService = new UserService();
	private AccountService accountService = new AccountService();
	private TransactionService transactionService = new TransactionService();

	public void displayAllAccounts() {
		System.out.println("Here is a list of your accounts");
		List<Account> list = accountService.findAllAccounts();
		for (Account account : list) {
			System.out.println(account);
		}
	}

	public void displayOneAccount(String accountNumber) {
		System.out.println("Here is account " + accountNumber + ":");
		Account account = accountService.findByNumber(accountNumber);
		System.out.println(account);
	}

	public void displayAccountBalance(String accountNumber) {
		Account account = accountService.getBalance(accountNumber);
		System.out.println(account.accountBalance);
	}

	public void showAllUsers() {
		System.out.println("Here are all the users");
		List<User> list = userService.findAllAccounts();
		for (User user : list) {
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

//	public boolean newUser() {
//		User user = userService.newUser(User);
//	}

	public void adminMenu() {
		System.out.println("what would you like to do? \n" + "1) Account Menus \n" + "2) Transaction Menus \n"
				+ "3) Add a user to the system \n" + "4) See user role \n"
				+ "5) Approve/Deny Account \n" + "0) Logout");

		String response = scan.nextLine();

		while (!response.equals("9")) {
			switch (response) {
			case "1":
				employeeMenu();
				System.out.println("\n");
				adminMenu();
				break;
			case "2":
				customerMenu();
				System.out.println("\n");
				adminMenu();
				break;

			case "4":
				System.out.println("Enter username you would like to see role for");
				String userName1 = scan.nextLine();
				System.out.println(getRoles(userName1));
				System.out.println("\n");
				adminMenu();
				break;
			case "5":
				System.out.println("Aprove/Deny account");
				System.out.println("\n");
				adminMenu();
				break;
			
			case "0":
				System.exit(0);
			default:
				System.out.println("You have enter and invalid selection!");
				adminMenu();
				System.out.println("\n");
				break;
			}
		}

	}
	
	public void employeeMenu() {
		System.out.println("what would you like to do? \n" + "1) See all users \n" + "2) See one user \n"
				+ "3) Add a user to the system \n" + "4) Tranaction Menus \n"
				+ "5) Approve/Deny Account \n" + "0) Logout");

		String response = scan.nextLine();

		while (!response.equals("9")) {
			switch (response) {
			case "1":
				showAllUsers();
				System.out.println("\n");
				employeeMenu();
				break;
			case "2":
				System.out.println("What user would you like to see?");
				String userName = scan.nextLine();
				showUser(userName);
				System.out.println("\n");
				employeeMenu();
				break;
			case "3":
				System.out.println("Will add a user");
				employeeMenu();
				break;
			case "4":
				customerMenu();

			case "0":
				System.exit(0);
			default:
				System.out.println("You have enter and invalid selection!");
				employeeMenu();
				System.out.println("\n");
				break;
			}
		}

	}

	public void customerMenu() {
		System.out.println(
				"What would you like to do? \n" + "1) Display Account Balance \n" + "2) Withdraw Money From Account \n"
						+ "3) Deposit Money Into Account \n" + "4) Transfer Money to an Account \n");
		String response = scan.nextLine().toString();
		switch (response) {
		case "1":
			System.out.println("Please enter your account number");
			String accountNumber2 = scan.nextLine();
			displayAccountBalance(accountNumber2);
			System.out.println("\n");
			customerMenu();
			break;
		case "2":
			System.out.println("Please enter account number to withdraw from");
			String accountNum = scan.nextLine();
			System.out.println("Please enter account withdraw ammount");
			double withdrawAmount = scan.nextDouble();
			scan.nextLine();
			if(withdrawAmount < 0) {
				System.out.println("Amount for withdraw must be greater than 0");
			} else {
			transactionService.getWithdraw(accountNum, withdrawAmount);
			displayAccountBalance(accountNum);
			}
			System.out.println("\n");
			customerMenu();
			break;
		case "3":
			System.out.println("Please enter account number to deposit");
			String accountNum3 = scan.nextLine();
			System.out.println("Please enter account deposit ammount");
			double depositAmount = scan.nextDouble();
			scan.nextLine();
			if(depositAmount < 0) {
				System.out.println("Deposit amount must be greater than 0");
			} else {
			transactionService.getDeposit(accountNum3, depositAmount);
			displayAccountBalance(accountNum3);
			}
			System.out.println("\n");
			customerMenu();
			break;
		case "4":
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
			customerMenu();
			break;
		case "0":
			System.exit(0);
		default:
			System.out.println("You entered and invalid number!");
			customerMenu();
			break;
		}
	}
}
