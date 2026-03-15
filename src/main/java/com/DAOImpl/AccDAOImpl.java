package com.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Beans.AccountPojo;

import com.DAO.AccDAOInterface;

public class AccDAOImpl implements AccDAOInterface {

	Connection con;
	PreparedStatement psmt = null;
	ResultSet rst = null;
	int row;

	public void setDBConnection(Connection con) {
		this.con = con;
	}

	public AccountPojo getAccountDetails(int accNo) {

		AccountPojo acc = null;

		try {
			String query = "SELECT * FROM account WHERE acc_no=?";
			psmt = con.prepareStatement(query);
			psmt.setInt(1, accNo);

			rst = psmt.executeQuery();

			if (rst.next()) {
				acc = new AccountPojo();

				acc.setAccNo(rst.getInt("acc_no"));
				acc.setUserName(rst.getString("user_name"));
				acc.setBalance(rst.getDouble("balance"));

				acc.setCategoryAcc(rst.getString("category_acc"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return acc;
	}

	public int getAccountNoByUserId(int userId) {
		int accNo = 0;
		try {
			String sql = "SELECT acc_no FROM account WHERE user_id=?";
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, userId);

			rst = psmt.executeQuery();

			if (rst.next()) {
				accNo = rst.getInt("acc_no");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accNo;
	}

	@Override
	public boolean insertAccount(AccountPojo acc) {
		boolean flag = false;
		try {
			String query = "INSERT INTO account(acc_no, user_name, balance, category_acc) VALUES(?,?,?,?)";

			psmt = con.prepareStatement(query);
			psmt.setInt(1, acc.getAccNo());
			psmt.setString(2, acc.getUserName());
			psmt.setDouble(3, acc.getBalance());
			psmt.setString(4, acc.getCategoryAcc());

			row = psmt.executeUpdate();

			if (row > 0)
				flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean removeAccount(int accNo) {
		boolean flag = false;
		try {
			String query = "DELETE FROM account WHERE acc_no=?";
			psmt = con.prepareStatement(query);
			psmt.setInt(1, accNo);

			row = psmt.executeUpdate();

			if (row > 0)
				flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public double getBalance(int accNo) {
		double balance = 0;
		try {
			String query = "SELECT balance FROM account WHERE acc_no=?";
			psmt = con.prepareStatement(query);
			psmt.setInt(1, accNo);

			rst = psmt.executeQuery();

			if (rst.next()) {
				balance = rst.getDouble("balance");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return balance;
	}

	@Override
	public boolean depositAmount(int accNo, double amount) {
		boolean flag = false;
		try {
			String query = "UPDATE account SET balance = balance + ? WHERE acc_no=?";
			psmt = con.prepareStatement(query);
			psmt.setDouble(1, amount);
			psmt.setInt(2, accNo);

			row = psmt.executeUpdate();

			if (row > 0)

			{
				String insert = "INSERT INTO transaction_history(acc_no, trans_type, amount) VALUES(?,?,?)";
				PreparedStatement ps2 = con.prepareStatement(insert);
				ps2.setInt(1, accNo);
				ps2.setString(2, "DEPOSIT");
				ps2.setDouble(3, amount);
				ps2.executeUpdate();
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean withdrawAmount(int accNo, double amount) {
		boolean flag = false;
		try {
			double currentBalance = getBalance(accNo);

			if (currentBalance >= amount) {
				String query = "UPDATE account SET balance = balance - ? WHERE acc_no=?";
				psmt = con.prepareStatement(query);
				psmt.setDouble(1, amount);
				psmt.setInt(2, accNo);

				row = psmt.executeUpdate();

				if (row > 0) {
					String insert = "INSERT INTO transaction_history(acc_no, trans_type, amount) VALUES(?,?,?)";
					PreparedStatement ps2 = con.prepareStatement(insert);
					ps2.setInt(1, accNo);
					ps2.setString(2, "WITHDRAW");
					ps2.setDouble(3, amount);
					ps2.executeUpdate();

					flag = true;
				}

			} else {
				flag = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}