package com.listener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.annotation.WebListener;

public class DAOContextListener implements ServletContextAttributeListener {

	Connection con;
	ServletContext c;

	public void attributeAdded(ServletContextAttributeEvent e) {
		// TODO Auto-generated method stub
		c = e.getServletContext();

		try {
			Class.forName(c.getInitParameter("driver"));
			con = DriverManager.getConnection(c.getInitParameter("url"), c.getInitParameter("username"),
					c.getInitParameter("password"));
			c.setAttribute("connection", con);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void attributeRemoved(ServletContextAttributeEvent scae) {
		// TODO Auto-generated method stub
		try {
			con = (Connection) c.getAttribute("connection");
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void attributeReplaced(ServletContextAttributeEvent scae) {
		// TODO Auto-generated method stub
	}

}
