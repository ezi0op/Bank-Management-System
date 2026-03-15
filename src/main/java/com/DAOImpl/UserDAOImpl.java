package com.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Beans.UserPojo;
import com.DAO.UserDAOInterface;

public class UserDAOImpl implements UserDAOInterface {

	Connection con;
	ResultSet rst = null;
	PreparedStatement psmt = null;
	int row;

	public void setDBConnection(Connection con) {
		// TODO Auto-generated method stub
		this.con = con;
	}

	public int getUserIdByUsername(String username) {
		int id = 0;
		try {
			String query = "SELECT id FROM users WHERE user=?";
			psmt = con.prepareStatement(query);
			psmt.setString(1, username);

			rst = psmt.executeQuery();

			if (rst.next()) {
				id = rst.getInt("id");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	public int getAccountNoByUsername(String username) {
		int accNo = 0;

		try {
			String query = "SELECT acc_no FROM account WHERE user_name=?";
			psmt = con.prepareStatement(query);
			psmt.setString(1, username);

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
	public int InsertData(UserPojo p) {
		// TODO Auto-generated method stub

		try {

			String query = "INSERT INTO users(user, pass, secQuestion, ans) VALUES(?,?,?,?)";
			psmt = con.prepareStatement(query);
			psmt.setString(1, p.getUser());
			psmt.setString(2, p.getPass());
			psmt.setString(3, p.getSecQuestion());
			psmt.setString(4, p.getAns());

			row = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return row;
	}

	@Override
	public boolean retriveData(String un) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {

			String query = "SELECT * FROM users WHERE user = ?";
			psmt = con.prepareStatement(query);
			psmt.setString(1, un);

			rst = psmt.executeQuery();

			if (rst.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public String updatePassword(String user, String newPass) {
		// TODO Auto-generated method stub
		String password = null;

		try {

			String query = "UPDATE users SET pass=? WHERE user=?";
			psmt = con.prepareStatement(query);

			psmt.setString(1, newPass);
			psmt.setString(2, user);

			row = psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return password;

	}

	@Override
	public String getPasswordBySecurity(UserPojo p) {
		// TODO Auto-generated method stub

		String password = null;

		try {

			String query = "SELECT pass FROM users WHERE user=? AND secQuestion=? AND ans=?";
			psmt = con.prepareStatement(query);
			psmt.setString(1, p.getUser());
			psmt.setString(2, p.getSecQuestion());
			psmt.setString(3, p.getAns());

			rst = psmt.executeQuery();

			if (rst.next()) {
				password = rst.getString("pass");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return password;
	}

}
