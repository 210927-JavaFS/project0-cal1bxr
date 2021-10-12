package com.revature.models;

public class Account {
	private String accountNumber;
	private String accountUsername;
	public double accountBalance;
	
	public Account(String accountNumber, String accountUsername, double accountBalance) {
		super();
		this.accountNumber = accountNumber;
		this.accountUsername = accountUsername;
		this.accountBalance = accountBalance;
	}
	
	public Account() {
		super();
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getAccountUsername() {
		return accountUsername;
	}
	
	public void setAccountUsername(String accountUsername) {
		this.accountUsername = accountUsername;
	}
	
	public double getAccountBalance() {
		return accountBalance;
	}
	
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(accountBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((accountUsername == null) ? 0 : accountUsername.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (Double.doubleToLongBits(accountBalance) != Double.doubleToLongBits(other.accountBalance))
			return false;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (accountUsername == null) {
			if (other.accountUsername != null)
				return false;
		} else if (!accountUsername.equals(other.accountUsername))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountUsername=" + accountUsername + ", accountBalance="
				+ accountBalance + "]";
	}
	
	
	
	

	

	



	
}
