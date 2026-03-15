package com.ServiceImpl;

import java.sql.Connection;

import com.Beans.UserPojo;
import com.DAO.UserDAOInterface;

import com.Service.LoginValidationInterface;

public class LoginValidationServiceImpl implements LoginValidationInterface {

	Connection con;
	private UserDAOInterface dao;

	@Override
	public int getAccountNo(String username) {
		return dao.getAccountNoByUsername(username);
	}

	public void setDao(UserDAOInterface dao) {
		// TODO Auto-generated method stub
		this.dao = dao;

	}

	@Override
	public int getUserId(String username) {
		return dao.getUserIdByUsername(username);
	}

	@Override
	public void signUp(String user, String pass, String secQues, String ans) {
		// TODO Auto-generated method stub

		UserPojo p = new UserPojo(user, pass, secQues, ans);

		int row = dao.InsertData(p);

	}

	@Override
	public boolean signIn(String user, String pass) {
		// TODO Auto-generated method stub

		boolean isExecuted = dao.retriveData(user);

		return isExecuted;
	}

	@Override
	public String forgetPass(String user, String secQues, String ans) {
		// TODO Auto-generated method stub

		UserPojo p = new UserPojo(user, null, secQues, ans);

		String row = dao.getPasswordBySecurity(p);

		return row;

	}

	@Override
	public void updatePass(String user, String pass, String newPass) {
		// TODO Auto-generated method stub

		boolean isValid = dao.retriveData(user);

		if (isValid) {

			dao.updatePassword(user, newPass);
			System.out.println("Password updated successfully");
		} else {
			System.out.println("Invalid old password");
		}

	}

}
