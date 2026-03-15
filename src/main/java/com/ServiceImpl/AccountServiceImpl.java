package com.ServiceImpl;

import java.util.List;

import com.Beans.AccountPojo;

import com.DAO.AccDAOInterface;
import com.DAOImpl.AccDAOImpl;
import com.Service.AccountInterface;

public class AccountServiceImpl implements AccountInterface {
	AccDAOInterface dao = new AccDAOImpl();

	public void setDao(AccDAOInterface dao) {
		// TODO Auto-generated method stub
		this.dao = dao;

	}

	@Override
	public boolean createAccount(int accNo, String userName, double balance, String categoryAcc) {
		// TODO Auto-generated method stub
		AccountPojo acc = new AccountPojo(accNo, userName, balance, categoryAcc);

		return dao.insertAccount(acc);
	}

	@Override
	public boolean deleteAccount(int accNo) {
		// TODO Auto-generated method stub
		return dao.removeAccount(accNo);
	}

	@Override
	public double showCurrentBalance(int accNo) {
		// TODO Auto-generated method stub
		return dao.getBalance(accNo);
	}

	public boolean depositBal(int accNo, double amount) {
		return dao.depositAmount(accNo, amount);
	}

	public boolean withdrawBal(int accNo, double amount) {
		return dao.withdrawAmount(accNo, amount);
	}

	@Override
	public int getAccountNoByUserId(int userId) {
		// TODO Auto-generated method stub
		return dao.getAccountNoByUserId(userId);
	}

	public AccountPojo getAccountDetails(int accNo) {
		return dao.getAccountDetails(accNo);
	}
}
