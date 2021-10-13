package com.revature.daos;

import com.revature.models.Transaction;

public interface TransactionDAO {
	public Transaction withdraw(String accNum, double withdrawAmount);
	public Transaction deposit(String accNum, double depositAmount);
	public Transaction transfer(String accNum1, String accNum2, double transferAmount);
}
