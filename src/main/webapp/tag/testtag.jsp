<%@page import="java.util.List"%>
<%@page import="com.bin.javabean.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 在页面上对request中的customers属性遍历,打印ID,name,age -->
<%-- <%
	List<Customer> customers = (List<Customer>)request.getAttribute("customers") ;
	if (customers != null){
		for(Customer customer:customers) {
%>
		<%=customer.getId() %>,<%=customer.getName() %>,<%=customer.getAge() %><br>
<%
		}
		
	}
%> --%>

<!-- 使用JSTL循环 -->
<c:forEach items="${requestScope.customers }" var="customer">
	--${customer.id },${customer.name },${customer.age }<br>
</c:forEach>


</body>
</html>