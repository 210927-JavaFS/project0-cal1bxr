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
				account.setAccountNumber(result.getInt("account_number"));
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Account findByNumber(int number) {
		try(Connection conn = ConnectionUtil.getConnection()){
		
		String sql = "SELECT * FROM accounts WHERE account_number = ?;";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, number);
		ResultSet result = statement.executeQuery();
		Account account = new Account();
		
		if(result.next()) {
			account.setAccountUsername(result.getString("user_name"));
			account.setAccountNumber(result.getInt("account_number"));
		}
		
		return account;
		
	} catch(SQLException e) {
		e.printStackTrace();
	}
	
	return null;
	}

	@Override
	public boolean updateAccount(Account account) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAccount(Account account) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO accounts (user_name, account_number) "
					+ "VALUES (?,?);";
			int count = 0;
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(++count, account.getAccountUsername());
			statement.setInt(++count, account.getAccountNumber());
			
			statement.execute();
			return true;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}

