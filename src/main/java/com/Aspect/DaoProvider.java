package com.Aspect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




import jakarta.servlet.ServletContext;

public class DaoProvider {

	public static Object getDAOObject(String className) {
		Object daoObj = null;

		try {

			daoObj = Class.forName(className).newInstance();

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return daoObj;

	}

}
