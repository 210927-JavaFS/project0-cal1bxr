package com.revature.daos;

import java.util.List;

import com.revature.models.Account;

public interface AccountDAO {
	public List<Account> findAll();
	public Account findByNumber(String accountNumber);
	public Account getBalance(String accountNumber);
	public boolean addAccount(Account home);
	public Account withdraw(String accountNumber, double withdrawAmount);
	public Account deposit(String accountNumber, double depositAmount);
	public Account transfer(String accountNumber1, String accountNumber2, double transferAmount);
}
