package com.Beans;

import java.sql.Timestamp;
import java.util.Objects;

public class TransactionPojo {

	private int transId;
	private int accNo;
	private String transType;
	private double amount;
	private Timestamp transDate;

	public TransactionPojo() {
	}

	public TransactionPojo(int transId, int accNo, String transType, double amount, Timestamp transDate) {
		this.transId = transId;
		this.accNo = accNo;
		this.transType = transType;
		this.amount = amount;
		this.transDate = transDate;
	}

	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Timestamp getTransDate() {
		return transDate;
	}

	public void setTransDate(Timestamp transDate) {
		this.transDate = transDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accNo, amount, transDate, transId, transType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionPojo other = (TransactionPojo) obj;
		return accNo == other.accNo && Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(transDate, other.transDate) && transId == other.transId
				&& Objects.equals(transType, other.transType);
	}

}
