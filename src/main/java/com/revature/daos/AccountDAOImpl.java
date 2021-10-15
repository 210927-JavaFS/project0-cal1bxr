package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;
import com.revature.utils.ConnectionUtil;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public List<Account> findAll() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM accounts;";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			List<Account> list = new ArrayList<>();

			while (result.next()) {
				Account account = new Account();
				account.setAccountUsername(result.getString("user_name"));
				account.setAccountNumber(result.getString("account_number"));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account findByNumber(String number) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM accounts WHERE account_number = ?;";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, number);
			ResultSet result = statement.executeQuery();
			Account account = new Account();

			if (result.next()) {
				account.setAccountUsername(result.getString("user_name"));
				account.setAccountNumber(result.getString("account_number"));
			}

			return account;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean addAccount(Account account) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO accounts (user_name, account_number) VALUES (?,?);"+
						"INSERT INTO account_balances (user_name, account_number, account_balances) VALUES (?,?,?)";
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, account.getAccountUsername());
			statement.setString(2, account.getAccountNumber());
			statement.setString(3, account.getAccountUsername());
			statement.setString(4, account.getAccountNumber());
			statement.setDouble(5, account.getAccountBalance());

			statement.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Account getBalance(String accountNumber) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT account_balance FROM account_balances WHERE account_number = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, accountNumber);
			ResultSet result = statement.executeQuery();
			Account account = new Account();

			// statement3.execute();
			while (result.next()) {
				account.setAccountBalance(result.getDouble("account_balance"));
			}

			return account;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Account withdraw(String accountNumber, double withdrawAmount) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT account_balance FROM account_balances WHERE account_number = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, accountNumber);
			ResultSet result = statement.executeQuery();
			Account account = new Account();
			if (result.next()) {
				account.setAccountBalance(result.getDouble("account_balance"));
			}

			if (withdrawAmount < 0) {
				System.out.println("Can not witdraw a negative amount of money");
			} else if (account.accountBalance <= 0) {
				System.out.println("Account balance is 0. Can not withdraw money");
			} else {
				double newBalance = account.accountBalance - withdrawAmount;
				String sql2 = "UPDATE account_balances SET account_balance = ? WHERE account_number = ?";
				PreparedStatement statement2 = conn.prepareStatement(sql2);
				statement2.setDouble(1, newBalance);
				statement2.setString(2, accountNumber);
				statement2.execute();
			}

			return account;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Account deposit(String accountNumber, double depositAmount) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT account_balance FROM account_balances WHERE account_number = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, accountNumber);
			ResultSet result = statement.executeQuery();
			Account account = new Account();
			if (result.next()) {
				account.setAccountBalance(result.getDouble("account_balance"));
			}

			if (depositAmount < 0) {
				System.out.println("Can not deposit a negative amount of money");
			} else {
				double newBalance = account.accountBalance + depositAmount;
				String sql2 = "UPDATE account_balances SET account_balance = ? WHERE account_number = ?";
				PreparedStatement statement2 = conn.prepareStatement(sql2);
				statement2.setDouble(1, newBalance);
				statement2.setString(2, accountNumber);
				statement2.execute();
			}

			return account;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account transfer(String accountNumber1, String accountNumber2, double transferAmount) {
		withdraw(accountNumber1, transferAmount);
		deposit(accountNumber2, transferAmount);

		return null;
	}
}
