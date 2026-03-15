package com.Service;

import java.util.List;

import com.Beans.TransactionPojo;
import com.DAO.TransDAOInterface;

public interface TransactionInteface {
	List<TransactionPojo> getTransactions(int accNo);

	void setDao(TransDAOInterface dao);
}
