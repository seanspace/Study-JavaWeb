package com.bin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHttpServlet extends MyGenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		if (req instanceof HttpServletRequest) {
			HttpServletRequest request = (HttpServletRequest) req ;
			if (res instanceof HttpServletResponse) {
				HttpServletResponse response = (HttpServletResponse) res ;
				service(request, response);
				
			}
		}
	}
	public void service(HttpServletRequest request,HttpServletResponse response) {
		String method = request.getMethod() ;
		if ("GET".equals(method)) {
			doGet(request,response) ;
		}
		if ("POST".equalsIgnoreCase(method)) {
			doPost(request,response) ;
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
	}

}
