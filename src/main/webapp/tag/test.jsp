<%@page import="java.util.ArrayList"%>
<%@page import="com.bin.javabean.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.atguigu.com/mytag/core" prefix="atguigu" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- http://localhost:8080/JavaWeb_atguitu/tag/test.jsp?atguigu=women&count=10 -->
<atguigu:hello value="${param.atguigu }" count="10"/>
<atguigu:max num2="10" num1="9"/>
<atguigu:readerFile src="/WEB-INF/classes/com/bin/tag/tag标签.txt"/>
<atguigu:testJspFragment>HelloWorld__</atguigu:testJspFragment>

<atguigu:printUpper time="3">abcdefg</atguigu:printUpper>

<%
	List<Customer> customer = new ArrayList<Customer>() ;
	customer.add(new Customer(1,"AAA",34)) ;
	customer.add(new Customer(2,"BBB",34)) ;
	customer.add(new Customer(3,"CCC"
			,34)) ;
	customer.add(new Customer(4,"DDD",34)) ;
	customer.add(new Customer(5,"EEE",34)) ;
	customer.add(new Customer(6,"FFF",34)) ;
	
	request.setAttribute("customers", customer) ;
%>

<atguigu:forEach items="${requestScope.customers}" var="cust">
	<br>${pageScope.cust.id } -- ${cust.name }
</atguigu:forEach>

 <br>
 <atguigu:parentTag>
 	<!-- 子标签以父标签的标签体存在;子标签把父标签的name属性答应到jsp页面; -->
 	<atguigu:sonTag/>
 </atguigu:parentTag>
 <br>
 <c:choose>
 	<c:when test="${param.age > 24} " >大学毕业</c:when>
 	<c:when test="${param.age > 20} ">高中毕业</c:when>
 	<c:otherwise>高中以下..</c:otherwise>
 </c:choose>
 <br>
 <atguigu:choose>
 	<atguigu:when test="${param.age > 24 }" >大学毕业1</atguigu:when>
 	<atguigu:when test="${param.age > 20 }">高中毕业1</atguigu:when>
 	<atguigu:otherwise>高中以下1..</atguigu:otherwise>
 </atguigu:choose>
 <br>
 <!-- 使用一个EL自定义函数 -->
 name参数的长度:${fn:length(param.name)}
 <br>
 <!-- 测试自定义EL函数 -->
 <%-- ${atguigu:concat(param.name1,param.name2) } --%>
 <br>
 
 
<!-- 
	执行顺序:
	setJspContext
	doTag
	
	// 下面两种情况都是不行的.对于count属性;
	 count="<%-- <%=request.getParameter("count") %> --%>"
	 count="${param.count}"
 -->
</body>
</html>