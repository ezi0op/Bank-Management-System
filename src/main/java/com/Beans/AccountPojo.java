package com.Beans;

import java.util.Objects;

public class AccountPojo {

	int accNo;
	String userName;
	double balance;
	String categoryAcc;

	public AccountPojo() {
		super();
	}
                                                                                                         
;	public AccountPojo(int accNo, String userName, double balance, String categoryAcc) {
		super();
		this.accNo = accNo;
		this.userName = userName;
		this.balance = balance;
		this.categoryAcc = categoryAcc;
	}

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getCategoryAcc() {
		return categoryAcc;
	}

	public void setCategoryAcc(String categoryAcc) {
		this.categoryAcc = categoryAcc;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accNo, balance, categoryAcc, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountPojo other = (AccountPojo) obj;
		return accNo == other.accNo && Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& Objects.equals(categoryAcc, other.categoryAcc) && Objects.equals(userName, other.userName);
	}

}
