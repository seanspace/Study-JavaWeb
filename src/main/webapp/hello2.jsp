<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.*"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Date date = new Date() ;
		out.print(date) ;// 一种方式
	%>
	<br>
	<%=date %><!-- 表达式的方式输出 -->
	<%
		String ageStr = request.getParameter("age") ;
		Integer age = 0;
		if (ageStr != null){
			age = Integer.parseInt(ageStr) ;
		}
		
		if(age != null && age >= 18){
	%>
		成人..
	<%
		}
		else {
			out.print("未成人..") ;
			myMethodOutOfService() ;// 此处对声明的方法调用;
		}
	%>
	<%! // 这是声明语法;
		void myMethodOutOfService(){
			System.out.print("this is my Method out of service() method!") ;
		}
	%>
	<%-- jsp注释 --%>
	<!-- html注释 -->
	<%-- <%
		System.out.print("打印信息");// 被jsp注释阻止执行;
	%> --%>
</body>
</html>