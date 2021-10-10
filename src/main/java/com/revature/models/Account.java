package com.revature.models;

public class Account {
	private int accountNumber;
	private String accountUsername;
	
	public Account(int accountNumber, String accountUsername) {
		super();
		this.accountNumber = accountNumber;
		this.accountUsername = accountUsername;
	}

	public Account() {
		super();
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountUsername() {
		return accountUsername;
	}

	public void setAccountUsername(String accountUsername) {
		this.accountUsername = accountUsername;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountNumber;
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
		if (accountNumber != other.accountNumber)
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
		return "Account [accountNumber=" + accountNumber + ", accountUsername=" + accountUsername + "]";
	}



	
}
