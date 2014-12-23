package com.bin.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter extends HttpFilter{

	private String sessionKey ;
	private String redirectUrl ;
	private String cncheckUrls ;
	

	@Override
	protected void init() {
		ServletContext servletContext = getFilterConfig().getServletContext() ;
		
		sessionKey = servletContext.getInitParameter("userSessionKey") ;
		redirectUrl = servletContext.getInitParameter("redirectPage") ;
		cncheckUrls = servletContext.getInitParameter("uncheckedUrls") ;
	}
	
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
//		String requestUrl = request.getRequestURL().toString() ;//http://localhost:8080/JavaWeb_atguitu/login/list.jsp
//		String requestUri = request.getRequestURI() ;// :/JavaWeb_atguitu/login/list.jsp
//		String servletPath = request.getServletPath() ;// /login/list.jsp
//		
//		List<String> urlS = Arrays.asList(cncheckUrls.split(",")) ;
//		if (urlS.contains(servletPath)) {
//			chain.doFilter(request, response);
//			return ;
//		}
//		
//		Object user = request.getSession().getAttribute(sessionKey) ;
//		if(user == null) {
//			response.sendRedirect(request.getContextPath() + redirectUrl);
//		} else {
//			chain.doFilter(request, response);
//		}
		chain.doFilter(request, response);
	}

}
