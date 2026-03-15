package com.Service;

import java.util.List;

import com.Beans.AccountPojo;

import com.DAO.AccDAOInterface;
import com.DAO.UserDAOInterface;

public interface AccountInterface {

	public void setDao(AccDAOInterface dao);

	public boolean createAccount(int accNo, String userName, double balance, String categoryAcc);

	public boolean deleteAccount(int accNo);

	

	public double showCurrentBalance(int accNo);

	public boolean depositBal(int accNo, double amount);

	public boolean withdrawBal(int accNo, double amount);

	int getAccountNoByUserId(int userId);

	public AccountPojo getAccountDetails(int accNo);
}
