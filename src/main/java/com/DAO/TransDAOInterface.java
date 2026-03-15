package com.DAO;

import java.sql.Connection;
import java.util.List;

import com.Beans.TransactionPojo;

public interface TransDAOInterface {

	List<TransactionPojo> getTransactionsByAccNo(int accNo);

	void setDBConnection(Connection con);

}
