package com.revature.services;

import java.util.List;

import com.revature.daos.AccountDAO;
import com.revature.daos.AccountDAOImpl;
import com.revature.models.Account;
import com.revature.models.Transaction;

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
	
	public Account getBalance(String accountNumber) {
		return accountDao.getBalance(accountNumber);
	}
	
	public Account getWithdraw(String accNum, double withdrawAccount) {
		return accountDao.withdraw(accNum, withdrawAccount);
	}
	
	public Account getDeposit(String accNum, double depositAmount) {
		return accountDao.deposit(accNum, depositAmount);
	}
	
	public Account getTransfer(String accNum1, String accNum2, double transferAmount) {
		return accountDao.transfer(accNum1, accNum2, transferAmount);
	}
}
