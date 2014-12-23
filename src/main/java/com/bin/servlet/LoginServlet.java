package com.bin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/loginServlet")
public class LoginServlet implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("请求来了...");
		System.out.println(req);
//		获取请求参数
		String user = req.getParameter("user") ;
		String password = req.getParameter("password") ;
		
		System.out.println(user + ":" + password);
//		获取多选的参数;
		//http://localhost:8080/JavaWeb_atguitu/loginServlet?user=liu&password=123&interesting=reading&interesting=Game&%E6%8F%90%E4%BA%A4=%E6%8F%90%E4%BA%A4
		String[] interesting = req.getParameterValues("interesting") ;		
		for (int i = 0; i < interesting.length; i++) {
			System.out.println("-->" + interesting[i]);
		}
//		返回参数名对应的Enumeration对象;
		Enumeration<String> names = req.getParameterNames() ;
		while (names.hasMoreElements()) {
			String name = names.nextElement() ;
			String val = req.getParameter(name) ;
			System.out.println("^^" + name + ":" + val);
			
		}
//		返回请求参数的键值对:key:参数名,value:参数值.String[]类型;
		Map<String, String[]> map = req.getParameterMap() ;
		for (Map.Entry<String, String[]> entry:map.entrySet()){
			System.out.println("**" + entry.getKey() + ":" + Arrays.asList(entry.getValue()));
		}
//		获取请求的URI
		String requestURI = ((HttpServletRequest)req).getRequestURI() ;
		System.out.println("URI :" + requestURI);
//		URL
		StringBuffer requestURL = ((HttpServletRequest)req).getRequestURL() ;
		System.out.println("URL :" + requestURL);
//		请求方式
		String method = ((HttpServletRequest)req).getMethod() ;
		System.out.println("Method:" + method);
//		查询串;如果是post请求,将不存在queryString;
		String queryString = ((HttpServletRequest)req).getQueryString() ;
		System.out.println("queryString :" + queryString);
//		servletPath 映射路径 带/的路径.
		String servletPath = ((HttpServletRequest)req).getServletPath() ;
		System.out.println("ServeltPath :" + servletPath);
		
//		Response的使用
		// 设置响应的内容类型;
		// tomcat的web.xml文件中有contentType的字串映射;
		res.setContentType("application/msword");
		
		PrintWriter printWriter = res.getWriter() ;
		printWriter.write("helloworld...");
		
		
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {
		
	}

}
