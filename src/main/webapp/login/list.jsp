<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/login/a.jsp">AAA</a>
	<a href="${pageContext.servletContext.contextPath }/login/a.jsp">AAA</a>
	<br>
	<a href="b.jsp">BB</a>
	<br>
	<a href="c.jsp">CC</a>
	<br>
	<a href="d.jsp">DD</a>
	<br>
	<a href="e.jsp">EEE</a>
	<br>
</body>
</html>