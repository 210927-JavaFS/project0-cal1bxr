package com.revature.daos;

import java.util.List;

import com.revature.models.Account;

public interface AccountDAO {
	public List<Account> findAll();
	public Account findByNumber(String accountNumber);
	public Account getBalance(double accountBalance);
	public boolean updateAccount(Account home);
	public boolean addAccount(Account home);
}
