package com.revature.services;

import java.util.List;

import com.revature.daos.AccountDAO;
import com.revature.daos.AccountDAOImpl;
import com.revature.models.Account;

public class AccountService {

	private AccountDAO accountDao = new AccountDAOImpl();
	
	public List<Account> findAllAccounts(){
		return accountDao.findAll();
	}
	
	public Account findByNumber(String accountNumber) {
		return accountDao.findByNumber(accountNumber);
	}
	
	public boolean newAccount(Account account) {
		return accountDao.addAccount(account);
	}
	
	public Account getBalance(double accountBalance) {
		return accountDao.getBalance(accountBalance);
	}
}
