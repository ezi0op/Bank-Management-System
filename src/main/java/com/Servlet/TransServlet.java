package com.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.Aspect.DaoProvider;
import com.Aspect.ObjectProvider;
import com.Beans.TransactionPojo;
import com.DAO.TransDAOInterface;
import com.Service.TransactionInteface;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class TransServlet extends HttpServlet {

	private TransactionInteface transService;
	private TransDAOInterface dao;
	private Connection con;

	@Override
	public void init() throws ServletException {

		ServletContext context = getServletContext();

		// get connection
		con = (Connection) context.getAttribute("connection");

		// DAO
		String daoClass = getServletConfig().getInitParameter("transDao");
		dao = (TransDAOInterface) DaoProvider.getDAOObject(daoClass);
		dao.setDBConnection(con);

		// Service
		String serviceClass = getServletConfig().getInitParameter("transService");
		transService = (TransactionInteface) ObjectProvider.getObject(serviceClass);
		transService.setDao(dao);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("accNo") == null) {
			response.sendRedirect("signin.jsp");
			return;
		}

		int accNo = (int) session.getAttribute("accNo");

		
		List<TransactionPojo> list = transService.getTransactions(accNo);

		request.setAttribute("transactions", list);

		request.getRequestDispatcher("Bank.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
