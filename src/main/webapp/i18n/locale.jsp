<%@page import="java.util.Date"%>
<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%=request.getLocale() %>
	Date:<%=new Date() %>,Salary:12345.67
	<br>
	<%
		Date date = new Date();
		request.setAttribute("date", date) ;
		request.setAttribute("salary", 12345.67) ;
		
		String code = request.getParameter("code") ;
		if (code != null) {
			if ("en".equals(code)){
				session.setAttribute("locale", Locale.US) ;
			} else if("zh".equals(code)) {
				session.setAttribute("locale", Locale.CHINA) ;
			}
		}
	%>
	<%--第一种方式.
 	<fmt:bundle basename="i18n">
		<fmt:message key="date"></fmt:message>:
		<fmt:formatDate value="${date }"/>
		<fmt:message key="salary"></fmt:message>
		<fmt:formatNumber value="${salary }"></fmt:formatNumber>
	</fmt:bundle> 
	--%>
	<c:if test="${sessionScope.locale != null }">
		<fmt:setLocale value="${sessionScope.locale }"/><!-- 这句必须先于fmt:setBundle -->
	</c:if>
	<fmt:setBundle basename="i18n"/>
		
	<fmt:formatDate value="${date }" dateStyle="Fulll"></fmt:formatDate>
	<fmt:message key="salary"></fmt:message>
	<fmt:formatNumber value="${salary }" type="currency"></fmt:formatNumber>
	<br><br>
	
	
	<a href="index.jsp?code=en">English</a>
	<a href="index.jsp?code=zh">中文</a>
	
	<!-- fmt标签 -->
</body>
</html>