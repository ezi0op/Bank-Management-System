package com.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;

//@WebFilter("/loginServlet");
//linking filter to jsp
public class SignInFilter extends HttpFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String secQ = request.getParameter("securityQuestion");
		String ans = request.getParameter("answer");

		if (user == null || user.isEmpty() || pass == null || pass.isEmpty() || secQ == null || secQ.isEmpty()
				|| ans == null || ans.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/SignIn.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/Register.jsp");
			rd.include(request, response);
			chain.doFilter(request, response);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
