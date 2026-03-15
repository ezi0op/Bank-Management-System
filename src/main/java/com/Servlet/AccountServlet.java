package com.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.Aspect.DaoProvider;
import com.Aspect.ObjectProvider;
import com.Beans.AccountPojo;
import com.Beans.TransactionPojo;
import com.DAO.AccDAOInterface;
import com.DAO.TransDAOInterface;
import com.Service.AccountInterface;
import com.Service.TransactionInteface;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AccountServlet extends HttpServlet {

	AccountInterface businessLogic;
	AccDAOInterface daoImplLogic;
	TransactionInteface transService;
	TransDAOInterface transDao;

	Connection con;

	public void init() {

		ServletContext context = getServletContext();

		// 1️⃣ get dao class name from web.xml
		String daoClassName = getServletConfig().getInitParameter("daoClass");

		// 2️⃣ get dao object from provider
		daoImplLogic = (AccDAOInterface) DaoProvider.getDAOObject(daoClassName);

		// 3️⃣ get connection from context
		con = (Connection) context.getAttribute("connection");

		// 4️⃣ set connection into DAO
		daoImplLogic.setDBConnection(con);

		// 5️⃣ get service object
		String className = getServletConfig().getInitParameter("accService");
		businessLogic = (AccountInterface) ObjectProvider.getObject(className);

		// 6️⃣ inject DAO into Service
		businessLogic.setDao(daoImplLogic);

		String transDaoClass = getServletConfig().getInitParameter("transDao");
		transDao = (TransDAOInterface) DaoProvider.getDAOObject(transDaoClass);
		transDao.setDBConnection(con);
		String transServiceClass = getServletConfig().getInitParameter("transService");
		transService = (TransactionInteface) ObjectProvider.getObject(transServiceClass);
		transService.setDao(transDao);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("accNo") == null) {
			response.sendRedirect("signin.jsp");
			return;
		}

		int accNo = (int) session.getAttribute("accNo");

		AccountPojo acc = businessLogic.getAccountDetails(accNo);

		List<TransactionPojo> transactions = transService.getTransactions(accNo);

		request.setAttribute("accNo", acc.getAccNo());
		request.setAttribute("name", acc.getUserName());
		request.setAttribute("balance", acc.getBalance());
		request.setAttribute("categoryAcc", acc.getCategoryAcc());

		request.setAttribute("transactions", transactions);

		request.getRequestDispatcher("Bank.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		
		if ("create".equals(action)) {

			int accNo = Integer.parseInt(request.getParameter("accNo"));
			String userName = request.getParameter("userName");
			double balance = Double.parseDouble(request.getParameter("balance"));
			String category = request.getParameter("categoryAcc");

			boolean result = businessLogic.createAccount(accNo, userName, balance, category);

			if (result) {
				request.setAttribute("accNo", accNo);
				request.setAttribute("userName", userName);
				request.setAttribute("balance", balance);
				request.setAttribute("category", category);

				request.getRequestDispatcher("SignIn.jsp").forward(request, response);
			} else {
				request.setAttribute("msg", "❌ Failed to Create Account");
				request.getRequestDispatcher("openaccount.jsp").forward(request, response);
			}
		}

		
		else if ("deposit".equals(action)) {

			int accNo = Integer.parseInt(request.getParameter("accNo"));
			double amount = Double.parseDouble(request.getParameter("amount"));

			boolean result = businessLogic.depositBal(accNo, amount);

			if (result) {
				request.setAttribute("msg", "✅ Deposit Successful");
			} else {
				request.setAttribute("msg", "❌ Deposit Failed");
			}

			response.sendRedirect("AccountServlet");
		}


		else if ("withdraw".equals(action)) {

			int accNo = Integer.parseInt(request.getParameter("accNo"));
			double amount = Double.parseDouble(request.getParameter("amount"));

			boolean result = businessLogic.withdrawBal(accNo, amount);

			if (result) {
				request.setAttribute("msg", "✅ Withdraw Successful");
			} else {
				request.setAttribute("msg", "❌ Insufficient Balance");
			}

			response.sendRedirect("AccountServlet");
		}

		
		else if ("balance".equals(action)) {

			int accNo = Integer.parseInt(request.getParameter("accNo"));

			double bal = businessLogic.showCurrentBalance(accNo);

			request.setAttribute("balance", bal);
			request.getRequestDispatcher("balance.jsp").forward(request, response);
		}
	}
}