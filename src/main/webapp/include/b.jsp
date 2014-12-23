<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>BBB PAGE</h3>
我是使用的a.jsp页面定义的变量额:
<%-- <%=forBPage %><!-- 这样使用的话,直接访问a.jsp是没有错误的. --> --%>
<%
	// 这里解决的是post请求的中文乱码问题.
	request.setCharacterEncoding("UTF-8") ;
	// get请求用上面的方法解决不了,用下面的方式.
	String val = request.getParameter("username") ;
	String username = new String(val.getBytes("iso-8859-1"),"UTF-8") ;
	out.print("<br>解码方式,解决get请求乱码问题:") ;
	out.print(username) ;
%>
<br>直接获取username:
<%= request.getParameter("username") %>

</body>
</html>