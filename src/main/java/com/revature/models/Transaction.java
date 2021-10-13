package com.revature.models;

public class Transaction {
	private String accNum;
	private String accNum2;
	private double withdrawAmount;
	private double depositAmount;
	private double transferAmount;
	
	public Transaction(String accNum, String accNum2, double withdrawAmount, double depositAmount,
			double transferAmount) {
		super();
		this.accNum = accNum;
		this.accNum2 = accNum2;
		this.withdrawAmount = withdrawAmount;
		this.depositAmount = depositAmount;
		this.transferAmount = transferAmount;
	}

	public Transaction(String accNum, double withdrawAmount, double depositAmount, double transferAmount) {
		super();
		this.accNum = accNum;
		this.withdrawAmount = withdrawAmount;
		this.depositAmount = depositAmount;
		this.transferAmount = transferAmount;
	}

	public Transaction() {
		super();
	}

	public String getAccNum() {
		return accNum;
	}

	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}

	public String getAccNum2() {
		return accNum2;
	}

	public void setAccNum2(String accNum2) {
		this.accNum2 = accNum2;
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
		result = prime * result + ((accNum == null) ? 0 : accNum.hashCode());
		result = prime * result + ((accNum2 == null) ? 0 : accNum2.hashCode());
		long temp;
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
		Transaction other = (Transaction) obj;
		if (accNum == null) {
			if (other.accNum != null)
				return false;
		} else if (!accNum.equals(other.accNum))
			return false;
		if (accNum2 == null) {
			if (other.accNum2 != null)
				return false;
		} else if (!accNum2.equals(other.accNum2))
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
		return "Transaction [accNum=" + accNum + ", accNum2=" + accNum2 + ", withdrawAmount=" + withdrawAmount
				+ ", depositAmount=" + depositAmount + ", transferAmount=" + transferAmount + "]";
	}
	
	
	
	
}
