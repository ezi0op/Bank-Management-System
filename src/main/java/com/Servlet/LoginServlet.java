package com.Servlet;

import java.io.IOException;
import java.sql.Connection;

import com.Aspect.DaoProvider;
import com.Aspect.ObjectProvider;
import com.DAO.UserDAOInterface;
import com.Service.LoginValidationInterface;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	LoginValidationInterface businessLogic;
	UserDAOInterface daoImplLogic;
	Connection con;

	// ================= INIT =================
	public void init() {

		ServletContext context = getServletContext();

		// 1️⃣ get DAO class name
		String daoClassName = getServletConfig().getInitParameter("daoClass");

		// 2️⃣ create DAO object
		daoImplLogic = (UserDAOInterface) DaoProvider.getDAOObject(daoClassName);

		// 3️⃣ get DB connection from context
		con = (Connection) context.getAttribute("connection");

		// 4️⃣ set connection into DAO
		daoImplLogic.setDBConnection(con);

		// 5️⃣ get Service object
		String className = getServletConfig().getInitParameter("loginService");
		businessLogic = (LoginValidationInterface) ObjectProvider.getObject(className);

		// 6️⃣ inject DAO into Service
		businessLogic.setDao(daoImplLogic);
	}

	// ================= LOGIN =================
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user = request.getParameter("user");
		String pass = request.getParameter("pass");

		boolean valid = businessLogic.signIn(user, pass);

		if (valid) {

			// 🔹 Create session
			HttpSession session = request.getSession(true);
			session.setAttribute("username", user);

			// 🔹 IMPORTANT: also store account number if available
			int userId = businessLogic.getAccountNo(user);
			int accNo = businessLogic.getAccountNo(user); // create this method in service
			session.setAttribute("userId", userId);
			session.setAttribute("accNo", accNo);

			// 🔹 Redirect to dashboard servlet
			response.sendRedirect("AccountServlet");

		} else {
			request.setAttribute("msg", "❌ Invalid Username or Password");
			request.getRequestDispatcher("SignIn.jsp").forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}
}