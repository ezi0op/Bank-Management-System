package com.DAO;

import java.sql.Connection;
import java.util.List;

import com.Beans.AccountPojo;

public interface AccDAOInterface {
	public int getAccountNoByUserId(int userId);

	public void setDBConnection(Connection con);

	public boolean insertAccount(AccountPojo acc);

	public boolean removeAccount(int accNo);

	public AccountPojo getAccountDetails(int accNo);

	public double getBalance(int accNo);

	public boolean depositAmount(int accNo, double amount);

	public boolean withdrawAmount(int accNo, double amount);

}
