package com.revature.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.SQLException;
import java.sql.Statement;


public class ValidationTesting {
	public static Connection connection;
	public static ConnectionUtil conn;
	public static double withdrawAmount;
	public static double depositAmount;
	public static double transferAmount;
	public static String accNum1;
	public static String accNum2;
	public static double result;
	public static Logger log = LoggerFactory.getLogger(ValidationTesting.class);
	
	
	@BeforeEach
	public void setDoubles() {
		withdrawAmount = 5.00;
		depositAmount = 5.00;
		transferAmount = 5.00;
		
		accNum1 = "123456789";
		accNum2 = "987654321";
	}
	
	@Test
	public void checkWithdraw() throws SQLException {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE account_balances SET account_balance = account_balance - ? WHERE account_number = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDouble(1, withdrawAmount);
			statement.setString(2, accNum1);
			statement.execute();


		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.info("Withraw Test");
	}
	
	@Test
	public void checkDeposit() throws SQLException {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE account_balances SET account_balance = account_balance - ? WHERE account_number = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDouble(1, depositAmount);
			statement.setString(2, accNum1);
			statement.execute();


		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.info("Deposit Test");

	}
	
	@Test
	public void checkTransfer() throws SQLException {
		try (Connection conn = ConnectionUtil.getConnection()) {
			String sql = "UPDATE account_balances SET account_balance = account_balance - ? WHERE account_number = ?;" 
					+ "UPDATE account_balances SET account_balance = account_balance + ? where account_number = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDouble(1, transferAmount);
			statement.setString(2, accNum1);
			statement.setDouble(3, transferAmount);
			statement.setString(4, accNum1);
			statement.execute();


		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.info("Transfer Test");

	}
	

}
