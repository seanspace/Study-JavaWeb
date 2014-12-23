<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	<a href="${pageContext.servletContext.contextPath }/filter/test.jsp">过滤器</a>
	<a href="${pageContext.servletContext.contextPath }/filter/dispatcher.jsp">通过转发到test.jsp</a>
	
</body>
</html>