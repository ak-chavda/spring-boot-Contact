package com.contacts.reqfilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter({ "/*" })
public class CheckSessionFilter implements Filter {

	public void destroy() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	private final String[] urls = {
			// "/show_signin",
			"/process_login", "/show_signup", "/process_signup" };

	private boolean excludeUrlPatterns(String url) {
		for (String u : urls) {
			if (u.equals(url))
				return true;
		}
		return false;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("**********************************filter*******************************************");

		final HttpServletRequest httpRequest = (HttpServletRequest) request;
		final HttpSession session = httpRequest.getSession(false);

		// check whether user already login ?
		boolean isLoggedIn = (session != null && session.getAttribute("uid") != null);

		// check for request is type login
		boolean isLoginRequest = httpRequest.getRequestURI().equals(httpRequest.getContextPath() + "/show_signin");

		if (excludeUrlPatterns(httpRequest.getRequestURI())) {
			chain.doFilter(httpRequest, response);

		} else if (isLoggedIn && isLoginRequest) {
			// the user is already logged in and he's trying to login again
			// then forward to the view contact page
			httpRequest.getRequestDispatcher("/user").forward(request, response);
			System.out.println("user logged in");

		} else if (!isLoggedIn) {
			// the user is not logged in, and the requested page requires
			// authentication, then forward to the login page
			httpRequest.getRequestDispatcher("/show_signin").forward(request, response);
			System.out.println("not logged in");

		} else {
			// for other requested pages that do not require authentication
			// or the user is already logged in, continue to the destination
			chain.doFilter(request, response);
		}
	}
}