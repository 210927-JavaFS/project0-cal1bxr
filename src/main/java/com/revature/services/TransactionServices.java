package com.revature.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Account;
import com.revature.utils.ConnectionUtil;

public class TransactionServices {
	public Account withdraw(String accNum, double withdrawAmount) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE account_balances SET account_balance = account_balance - ? WHERE account_number = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDouble(1, withdrawAmount);
			statement.setString(2, accNum);
			statement.execute();
			Account account = new Account();


		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Account deposit(String accNum, double depositAmount) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE account_balances SET account_balance = account_balance + ? WHERE account_number = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDouble(1, depositAmount);
			statement.setString(2, accNum);
			statement.execute();
			Account account = new Account();

			return account;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public Account transfer(String accNum1, String accNum2, double transferAmount) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE account_balances SET account_balance = account_balance - ? WHERE account_number = ?;" 
						+ "UPDATE account_balances SET account_balance = account_balance + ? where account_number = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDouble(1, transferAmount);
			statement.setString(2, accNum1);
			statement.setDouble(3, transferAmount);
			statement.setString(4, accNum2);
			statement.execute();
			Account account = new Account();

			return account;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}

