<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="customer" id="customer" class="com.bin.javabean.Customer" scope="session">
	<jsp:setProperty property="age" value="10" name="customer" />
	<jsp:setProperty property="*" name="customer" /><!-- 用请求参数的值,为所有属性赋值.但是名字必须一样. -->
	<jsp:getProperty property="age" name="customer" />
</jsp:useBean>

<!-- 1.从scope(session)中获取id(customer)属性值,赋给class(com.bin.javabean.Customer) 
		类型的id变量;
		Customer customer = (Customer)session.getAttribute("customer") ;
	 2.若属性为空,利用反射创建一个新的对象,并以id为属性名放入到scope中.
	 	if(customer = null){
	 		customer = Class.forName("com.bin.javabean.Customer").getInstance() ;
	 		session.setAttribute(customer)
	 	}
 -->
 
 <jsp:useBean id="customer2" beanName="com.bin.javabean.Customer"
	type="java.lang.Object" scope="request"></jsp:useBean>
<%--<%
		// 上面相当于.
		Object customer2 = requesnt.getAttribute("customer2") ;
		if (customer2 == null){
			custmer2 = Class.forName("com.bin.javabean.Customer").newInstance() ;
			request.setAttribute("custommer2", customer2) ;
		}
	%> 
--%>
</body>
</html>