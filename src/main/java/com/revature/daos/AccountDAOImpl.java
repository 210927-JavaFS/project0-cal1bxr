package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Account;
import com.revature.models.User;
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
		try(Connection conn = ConnectionUtil.getConnection()){
		
		String sql = "SELECT * FROM accounts WHERE account_number = ?;";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, number);
		ResultSet result = statement.executeQuery();
		Account account = new Account();
		
		if(result.next()) {
			account.setAccountUsername(result.getString("user_name"));
			account.setAccountNumber(result.getString("account_number"));
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
			statement.setString(++count, account.getAccountNumber());
			
			statement.execute();
			return true;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	@Override
	public Account getBalance(String accountNumber) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT account_balance FROM account_balances WHERE account_number = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, accountNumber);
			ResultSet result = statement.executeQuery();
			Account account = new Account();
			
			//statement3.execute();
			while(result.next()) {
			account.setAccountBalance(result.getDouble("account_balance"));
			}
			return account;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	/*			ResultSet result = statement.executeQuery();
			User user = new User();
			
			if(result.next()) {
				user.setFirstName(result.getString("first_name"));
				user.setLastName(result.getString("last_name"));
				user.setUsername(result.getString("user_name"));
				user.setPassword(result.getString("user_password"));
				user.setRole(result.getString("roles"));
				user.setAccountActive(result.getBoolean("account_active"));
			}
			
			return user;
			*/
}

