package com.revature.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.daos.AccountDAOImpl;


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
	public static AccountDAOImpl accountDao;
	
	
	@BeforeEach
	public void setDoubles() {
		withdrawAmount = 5.00;
		depositAmount = 5.00;
		transferAmount = 5.00;
		
		accNum1 = "138297266";
		accNum2 = "179582108";
	}
	
	@Test
	public void checkWithdraw() {
		accountDao.withdraw(accNum1, withdrawAmount);
	}
	
	@Test
	public void checkDeposit() throws SQLException {
		accountDao.deposit(accNum2, depositAmount);
	}
	
	@Test
	public void checkTransfer() throws SQLException {
		accountDao.transfer(accNum1, accNum2, transferAmount);
	}
	

}
