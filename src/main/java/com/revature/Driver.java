package com.revature;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
	System.out.println("Do you have an account? Press Y or N");
	Scanner scanner = new Scanner(System.in);
	char accountQuestion = scanner.next().charAt(0);
	if (accountQuestion == 'Y' || accountQuestion == 'y') {
	    System.out.println(
		    "Would you like to make a Deposit, Withdrawal, or Transfer? Press 1 for DEPOSIT, Press 2 for WITHDRAWAL, Press 3 for TRANSFER");
	    byte accountManipulation = scanner.nextByte();
	    if (accountManipulation == 1) {
		System.out.println("Entered Deposit block");
	    } else if (accountManipulation == 2) {
		System.out.println("Entered Withdrawal block");
	    } else {
		System.out.println("Entered Transfer block");
	    }
	} else {
	    System.out.println(
		    "Would you like to open and account? Press Y or N");
	    char accountCreation = scanner.next().charAt(0);
	    if (accountCreation == 'Y' || accountCreation == 'y') {
		System.out.println("Enter account creation block");
	    } else {
		System.out.println("Thank you for using the system");
	    }
	}

	scanner.close();

    }

}
