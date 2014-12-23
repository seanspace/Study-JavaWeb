<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- EL中的隐含对象. -->
<form action="el.jsp" method="post">
	<%request.setCharacterEncoding("UTF-8"); %>
	username:<input type="text" name="username"
	value="<%=request.getParameter("username")==null?"":request.getParameter("username")%>"/>
	<input type="submit" value="submit"/>
	username:<input type="text" name="username"
	value="${param.username}"/>
	<input type="submit" value="submit"/>
	<br>
	username:<%=request.getParameter("username") %>
	<%
		session.setAttribute("time", new Date()) ;
	%>
</form>
<!-- EL的类型转换. -->
	<br>
	${param.score + 11}<!-- el可以进行自动类型转换. -->
	<br>
	score:<%=request.getParameter("score") + 11 %>
	
<!-- 隐含对象之--与范围有关的.pageScope,requestScope,sessionScope,Application -->

	<br>
	<br>
</body>
</html>