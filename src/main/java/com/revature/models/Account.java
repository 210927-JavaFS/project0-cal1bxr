package com.revature.models;

public class Account {
	private String accountNumber;
	private String accountUsername;
	private String accountNumber2;
	public double accountBalance;
	private double withdrawAmount;
	private double depositAmount;
	private double transferAmount;
	
	public Account(String accountNumber, String accountUsername, String accountNumber2, double accountBalance,
			double withdrawAmount, double depositAmount, double transferAmount) {
		super();
		this.accountNumber = accountNumber;
		this.accountUsername = accountUsername;
		this.accountNumber2 = accountNumber2;
		this.accountBalance = accountBalance;
		this.withdrawAmount = withdrawAmount;
		this.depositAmount = depositAmount;
		this.transferAmount = transferAmount;
	}

	public Account(String accountNumber, String accountUsername, double accountBalance, double withdrawAmount,
			double depositAmount, double transferAmount) {
		super();
		this.accountNumber = accountNumber;
		this.accountUsername = accountUsername;
		this.accountBalance = accountBalance;
		this.withdrawAmount = withdrawAmount;
		this.depositAmount = depositAmount;
		this.transferAmount = transferAmount;
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

	public String getAccountNumber2() {
		return accountNumber2;
	}

	public void setAccountNumber2(String accountNumber2) {
		this.accountNumber2 = accountNumber2;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public double getWithdrawAmount() {
		return withdrawAmount;
	}

	public void setWithdrawAmount(double withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	}

	public double getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}

	public double getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(double transferAmount) {
		this.transferAmount = transferAmount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(accountBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((accountNumber2 == null) ? 0 : accountNumber2.hashCode());
		result = prime * result + ((accountUsername == null) ? 0 : accountUsername.hashCode());
		temp = Double.doubleToLongBits(depositAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(transferAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(withdrawAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (accountNumber2 == null) {
			if (other.accountNumber2 != null)
				return false;
		} else if (!accountNumber2.equals(other.accountNumber2))
			return false;
		if (accountUsername == null) {
			if (other.accountUsername != null)
				return false;
		} else if (!accountUsername.equals(other.accountUsername))
			return false;
		if (Double.doubleToLongBits(depositAmount) != Double.doubleToLongBits(other.depositAmount))
			return false;
		if (Double.doubleToLongBits(transferAmount) != Double.doubleToLongBits(other.transferAmount))
			return false;
		if (Double.doubleToLongBits(withdrawAmount) != Double.doubleToLongBits(other.withdrawAmount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountUsername=" + accountUsername + ", accountNumber2="
				+ accountNumber2 + ", accountBalance=" + accountBalance + ", withdrawAmount=" + withdrawAmount
				+ ", depositAmount=" + depositAmount + ", transferAmount=" + transferAmount + "]";
	}
	
	
	
	

	
	
	
	

	

	



	
}
