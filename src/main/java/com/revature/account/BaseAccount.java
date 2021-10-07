package com.revature.account;

public class BaseAccount implements Account {
    private int accountNumber;
    private int currentBalance;
    

    @Override
    public void addBalance(int amount) {
	// TODO Auto-generated method stub
	currentBalance += amount;

    }

    @Override
    public void setBalance(int balance) {
	// TODO Auto-generated method stub
	currentBalance = balance;
    }

    @Override
    public int getBalance() {
	// TODO Auto-generated method stub
	return this.currentBalance;
    }

    @Override
    public void setAccountNumber(int accountNum) {
	// TODO Auto-generated method stub
	accountNumber = accountNum;
    }

    @Override
    public int getAccountNumber() {
	// TODO Auto-generated method stub
	return accountNumber;
    }

}
