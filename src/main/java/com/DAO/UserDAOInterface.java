package com.DAO;

import java.sql.Connection;

import com.Beans.UserPojo;

public interface UserDAOInterface {

	public int getAccountNoByUsername(String username);

	public int InsertData(UserPojo p);

	public boolean retriveData(String un);

	public String updatePassword(String user, String newPass);

	public String getPasswordBySecurity(UserPojo p);

	public void setDBConnection(Connection con);

	public int getUserIdByUsername(String username);

}
