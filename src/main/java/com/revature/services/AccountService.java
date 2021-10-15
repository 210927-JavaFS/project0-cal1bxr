package com.revature.services;

import java.util.List;

import com.revature.daos.AccountDAO;
import com.revature.daos.AccountDAOImpl;
import com.revature.models.Account;

public class AccountService {

	private AccountDAO accountDao = new AccountDAOImpl();

	public List<Account> findAllAccounts() {
		return accountDao.findAll();
	}

	public Account findByNumber(String accountNumber) {
		return accountDao.findByNumber(accountNumber);
	}

	public boolean newAccount(Account account) {
		return accountDao.addAccount(account);
	}

	public Account getBalance(String username) {
		return accountDao.getBalance(username);
	}

	public Account getWithdraw(String username, double withdrawAccount) {
		return accountDao.withdraw(username, withdrawAccount);
	}

	public Account getDeposit(String username, double depositAmount) {
		return accountDao.deposit(username, depositAmount);
	}

	public Account getTransfer(String username1, String username2, double transferAmount) {
		return accountDao.transfer(username1, username2, transferAmount);
	}
}
