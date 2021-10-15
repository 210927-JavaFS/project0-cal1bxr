package com.revature.controllers;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.revature.models.Account;
import com.revature.models.User;
import com.revature.services.AccountService;
import com.revature.services.UserService;
import com.revature.utils.PassEncTech1;

public class UserController {
	Scanner scan = new Scanner(System.in);
	private UserService userService = new UserService();
	private AccountService accountService = new AccountService();

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

	public void addAccount() {
		double accountBalance = 0.00;
		System.out.println("Enter information for new account");
		System.out.print("Enter your username: ");
		String username1 = scan.nextLine();
		String accountType = getRoles(username1);
		if (accountType.equals("admin") || (accountType.equals("employee") || accountType.equals("admin"))) {
			System.out.print("Enter your username for account to add: ");
			String username2 = scan.nextLine();
			int randomNumber = 100000000 + new Random().nextInt(90000000);
			String accountNumber = String.valueOf(randomNumber);
			Account account = new Account(accountNumber, username2, accountBalance);

			if (accountService.newAccount(account)) {
				System.out.println("New user successfully created");
			} else {
				System.out.println("Something went wrong. We could not register user. Please contact an admin or employee.");
			}
		}

	}

	public void accActive(boolean activeRole1, String username1) {
		userService.accActive(activeRole1, username1);

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

	public void addUser() {
		System.out.println("Please enter info for the user you would like to add.");
		System.out.print("Please enter your first name?");
		String firstname = scan.nextLine();
		System.out.print("What is your last name?");
		String lastname = scan.nextLine();
		System.out.print("What username would you like?");
		String username = scan.nextLine();
		System.out.print("What is your password?");
		String password = scan.nextLine();
		String encPassword = PassEncTech1.passwordEncryption(password);
		System.out.print("What role is the user?");
		String role = scan.nextLine();
		System.out.print("Is the account active");
		boolean accountActive = scan.nextBoolean();
		scan.nextLine();

		User user = new User(firstname, lastname, username, encPassword, role, accountActive);

		if (userService.addUser(user)) {
			System.out.println("New user successfully created");
		} else {
			System.out.println("Something went wrong. We could not registeryour user. Please try again.");
		}
	}
//	accountPassword.equals(encPassword)

	public void userLogin() {
		System.out.print("Enter your username: ");
		String user = scan.nextLine();
		System.out.print("Enter your password: ");
		String password = scan.nextLine();
		String encPassword = PassEncTech1.passwordEncryption(password);
		String accountType = getRoles(user);
		String accountPassword = getPass(user);
		if (accountType.equals("customer") && accountPassword.equals(encPassword)) {
			customerMenu();
		} else if (accountType.equals("employee") && accountPassword.equals(encPassword)) {
			employeeMenu();
		} else if (accountType.equals("admin") && accountPassword.equals(encPassword)) {
			adminMenu();
		} else {
			System.out.println("Not a valid user");
		}

	};

	public void adminMenu() {
		System.out.println("what would you like to do? \n" + "1) Account Menus \n" + "2) Transaction Menus \n"
				+ "3) See user role \n" + "0) Logout");

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

			case "3":
				System.out.println("Enter username you would like to see role for");
				String userName1 = scan.nextLine();
				System.out.println(getRoles(userName1));
				System.out.println("\n");
				adminMenu();
				break;
			case "4":
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
				+ "3) Add a user to the system \n" + "4) Tranaction Menus \n" + "5) Approve/Deny Account \n"
				+ "6) Return to previous menu" + "0) Logout");

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
				addUser();
				System.out.println("\n");
				employeeMenu();
				break;
			case "4":
				customerMenu();
				System.out.println("\n");
				employeeMenu();
			case "5":
				System.out.println("Enter username for new account");
				String username1 = scan.nextLine();
				System.out.println("What is the account status? true for active, false for inactive");
				boolean activeRole1 = scan.hasNext();
				accActive(activeRole1, username1);
				System.out.println("\n");
				employeeMenu();
			case "6":
				adminMenu();
				System.out.println("\n");
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
		System.out.println("What would you like to do? \n" + "1) Display Account Balance \n"
				+ "2) Withdraw Money From Account \n" + "3) Deposit Money Into Account \n"
				+ "4) Transfer Money to an Account \n" + "5) Open an Account \n" + "0) Logout");
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
			if (withdrawAmount < 0) {
				System.out.println("Amount for withdraw must be greater than 0");
			} else {
				accountService.getWithdraw(accountNum, withdrawAmount);
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
			if (depositAmount < 0) {
				System.out.println("Deposit amount must be greater than 0");
			} else {
				accountService.getDeposit(accountNum3, depositAmount);
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
			accountService.getTransfer(accountNum1, accountNum2, transferAmount);
			displayAccountBalance(accountNum1);
			displayAccountBalance(accountNum2);
			System.out.println("\n");
			customerMenu();
			break;
		case "5":
			addAccount();
			System.out.println("\n");
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
