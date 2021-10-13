package com.revature.services;

import com.revature.daos.TransactionDAO;
import com.revature.daos.TransactionDAOImpl;
import com.revature.models.Transaction;

public class TransactionService {
	private TransactionDAO transactionDao = new TransactionDAOImpl();
	
	public Transaction getWithdraw(String accNum, double withdrawAccount) {
		return transactionDao.withdraw(accNum, withdrawAccount);
	}
	
	public Transaction getDeposit(String accNum, double depositAmount) {
		return transactionDao.deposit(accNum, depositAmount);
	}
	
	public Transaction getTransfer(String accNum1, String accNum2, double transferAmount) {
		return transactionDao.transfer(accNum1, accNum2, transferAmount);
	}
}

