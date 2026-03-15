package com.Service;

import com.DAO.UserDAOInterface;

public interface LoginValidationInterface {

	public int getAccountNo(String username);

	public void setDao(UserDAOInterface dao);

	public void signUp(String user, String pass, String secQues, String ans);

	public boolean signIn(String user, String pass);

	public String forgetPass(String user, String secQues, String ans);

	public void updatePass(String user, String pass, String newPass);

	int getUserId(String username);

}
