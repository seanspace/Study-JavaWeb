package com.bin.filter.privilege;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

public class AuthorityServlet extends HttpServlet {
	
	private static final long serialVersionUID = -5060478101760859973L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
		String methodName = req.getParameter("method") ;
		
		try {
			Method method = getClass().getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class) ;
			method.invoke(this, req,resp) ;
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	protected void getAuthorities(HttpServletRequest request,HttpServletResponse response) {
		
	}
}
