<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Date date = new Date() ;
	System.out.println(date) ;
%>
<%
	System.out.println(date.toString()) ;

	// 9大内置对象:没有申明就可以使用的对象,就叫隐含对象;
	String name = request.getParameter("name");// request就是一个隐含对象;
	// pageContext
	ServletRequest req = pageContext.getRequest() ;
	System.out.println(req instanceof HttpServletRequest) ;
	// session
	System.out.println(session.getId()) ;
	
	// application
	System.out.println(application) ;
	// config
	System.out.println(config.getInitParameter("test")) ;
	// out
	out.print("out对象打印的") ;
	// page
	out.print(page) ;
	// exception:加了这句话才可以使用;<%@ page isErrorPage="true" %>
	<%
		out.print(exception) ;
	%>
%>
</body>
</html>