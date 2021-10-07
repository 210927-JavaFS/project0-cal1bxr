package com.revature;

import java.util.Scanner;

public class Driver {

    static Scanner scanner = new Scanner(System.in);
    static int userChoice;
    static int accountNumber = 1234;
    static double balance;
    static double newBalance;
    static String userName = "mjordan";
    static String password = "password";

    public static void createAccount() {
	System.out.println("Enter a username: ");
	String newUser = scanner.next();
	userName = newUser;
	System.out.println("Enter a starting balance: ");
	balance = scanner.nextDouble();
    }

    public static void depositMoney(double deposit) {
	if (deposit > 0) {
	    newBalance = balance + deposit;
	} else {
	    System.out.println("Dposit must be greater than 0");
	}
    }

    public static void withdrawMoney(double withdraw) {
	if (withdraw > 0) {
	    newBalance = balance - withdraw;
	} else {
	    System.out.println("Withdraw must be greater than 0");
	}
    }
    
    public static void getBalance(double balance) {
	System.out.println("The balance is : " + balance);
    }
    
    public static void transferMoney(int account1, int account2) {
	System.out.println("Withdraw money from account1 and add to account 2");
    }
    
    public static void accountApproval(int accountBalance) {
	if(accountBalance > 0) {
	    System.out.println("Account approved");
	} else {
	    System.out.println("Account denied");
	}
    }
    
    public static void cancelAccount(int accountNumber) {
	accountNumber = 0;
	System.out.println("Account canceled");
    }

    public static void main(String[] args) {

	System.out.println("Enter Username: ");
	String username = scanner.next();
	if (username.equals("mjordan")) {
	    System.out.println("Enter password: ");
	    String password = scanner.next();
	    if (password.equals("password")) {
		System.out.println("Account exists");
	    } else {
		System.out.println("Invalid password. Application will close");
		System.exit(0);
	    }
	} else {
	    System.out.println(
		    "Account does not exist. Would you like to create account?");
	    createAccount();
	}

	do {
	    // display menu to user
	    // ask user for his choice and validate it (make sure it is between
	    // 1 and 6)
	    System.out.println();
	    System.out.println("1) Open a new bank account");
	    System.out.println("2) Deposit to a bank account");
	    System.out.println("3) Withdraw to bank account");
	    System.out.println("4) Print account balance");
	    System.out.println("5) Quit");
	    System.out.println();
	    System.out.print("Enter choice [1-5]: ");
	    userChoice = scanner.nextInt();
	    switch (userChoice) {
	    case 1:
		createAccount();
		break;
	    case 2:
		System.out.println("Enter a account number");
		int accountdepositNum = scanner.nextInt();
		System.out.println("How much would you like to deposit");
		double deposit = scanner.nextDouble();
		if (accountdepositNum == accountNumber) {
		    depositMoney(deposit);
		} else {
		    System.out.println("No such account number");
		}
		System.out.println("Current balance: " + newBalance);
		break;
	    case 3:
		System.out.println("Enter a account number");
		int accountWithdrawNum = scanner.nextInt();
		System.out.println("Enter a withdraw amount");
		double withdraw = scanner.nextDouble();
		if(accountWithdrawNum == accountNumber) {
		    withdrawMoney(withdraw);
		} else {
		    System.out.println("No such account number");
		}
		System.out.printf("New balance: " + newBalance);
		break;
	    case 4:
		System.out.println("Enter a account number");
		int accountBalanceNum = scanner.nextInt();
		if (accountBalanceNum == accountNumber) {
		    getBalance(balance);
		}
		System.out.printf("New balance: " + balance);
		break;
	    case 5:
		scanner.close();
		System.out.println("Thank you for using this application");
		System.exit(0);
	    }
	} while (userChoice != '5');
    }

}
