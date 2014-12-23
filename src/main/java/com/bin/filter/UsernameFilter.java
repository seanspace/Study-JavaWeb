package com.bin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UsernameFilter implements Filter {

    public UsernameFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String initUserString = filterConfig.getInitParameter("username") ;
		String username = request.getParameter("username") ;
//		if (!initUserString.equals(username)) {
//			request.setAttribute("message", "用户名错误");
//			request.getRequestDispatcher("/filter/login.jsp").forward(request, response); ;
//			return ;
//		}
		chain.doFilter(request, response);
	}
	private FilterConfig filterConfig ;
	public void init(FilterConfig fConfig) throws ServletException {
		this.filterConfig = fConfig ;
	}

}
