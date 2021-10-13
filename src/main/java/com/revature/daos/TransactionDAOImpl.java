package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.models.Account;
import com.revature.models.Transaction;
import com.revature.utils.ConnectionUtil;

public class TransactionDAOImpl implements TransactionDAO {

	@Override
	public Transaction withdraw(String accNum, double withdrawAmount) {
			try (Connection conn = ConnectionUtil.getConnection()) {
				String sql = "UPDATE account_balances SET account_balance = account_balance - ? WHERE account_number = ?";
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setDouble(1, withdrawAmount);
				statement.setString(2, accNum);
				statement.execute();


			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
	}

	@Override
	public Transaction deposit(String accNum, double depositAmount) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE account_balances SET account_balance = account_balance + ? WHERE account_number = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDouble(1, depositAmount);
			statement.setString(2, accNum);
			statement.execute();


			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Transaction transfer(String accNum1, String accNum2, double transferAmount) {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE account_balances SET account_balance = account_balance - ? WHERE account_number = ?;" 
						+ "UPDATE account_balances SET account_balance = account_balance + ? where account_number = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDouble(1, transferAmount);
			statement.setString(2, accNum1);
			statement.setDouble(3, transferAmount);
			statement.setString(4, accNum2);
			statement.execute();


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
