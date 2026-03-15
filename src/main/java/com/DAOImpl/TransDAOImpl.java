package com.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Beans.TransactionPojo;
import com.DAO.TransDAOInterface;

public class TransDAOImpl implements TransDAOInterface {

	private Connection con;
	private PreparedStatement psmt;
	private ResultSet rst;

	@Override
	public void setDBConnection(Connection con) {
		this.con = con;
	}

	@Override
	public List<TransactionPojo> getTransactionsByAccNo(int accNo) {

		List<TransactionPojo> list = new ArrayList<>();

		try {
			String sql = "SELECT * FROM transaction_history WHERE acc_no=? ORDER BY trans_date DESC";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, accNo);

			rst = psmt.executeQuery();

			while (rst.next()) {

				TransactionPojo t = new TransactionPojo();

				t.setTransId(rst.getInt("trans_id"));
				t.setAccNo(rst.getInt("acc_no"));
				t.setTransType(rst.getString("trans_type"));
				t.setAmount(rst.getDouble("amount"));
				t.setTransDate(rst.getTimestamp("trans_date"));

				list.add(t);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}