package com.ServiceImpl;

import java.util.List;

import com.Beans.TransactionPojo;
import com.DAO.TransDAOInterface;
import com.Service.TransactionInteface;

public class TransactionsServiceImpl implements TransactionInteface {

	private TransDAOInterface dao;

	public void setDao(TransDAOInterface dao) {
		this.dao = dao;
	}

	@Override
	public List<TransactionPojo> getTransactions(int accNo) {
		// TODO Auto-generated method stub
		return dao.getTransactionsByAccNo(accNo);
	}

}
