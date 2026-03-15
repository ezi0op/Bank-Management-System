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

//@WebFilter("/domainAdditionFilter")
public class DomainAdditionFilter extends HttpFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String email = request.getParameter("email");
		String[] allowedDomain = { "@gmail.com", "@yahoo.com", "@bank.com" };

		boolean validDomain = false;

		if (email != null) {
			for (String domain : allowedDomain) {
				if (email.endsWith(domain)) {
					validDomain = true;
					break;
				}
			}
		}

		if (!validDomain) {
			request.setAttribute("error", "Invalid domain name");
			RequestDispatcher rd = request.getRequestDispatcher("SignIn.jsp");
			rd.forward(request, response);
			return;
		}

		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
