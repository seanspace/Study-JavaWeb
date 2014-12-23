<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bin.javabean.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- c:out -->
<h4>c:out标签使用</h4>
<%
	request.setAttribute("book", "<<java>>") ;
%>
直接使用el,出不来book:${requestScope.book } ;因为带了特殊字符;
<br>
使用C:out标签包装el表达式,可以输出,book:<c:out value="${requestScope.book }"></c:out>
<br>

<!-- c:set -->
<h4>c:set标签使用:可以为域属性值和javabean设置值;</h4>
<br>
<c:set var="name" value="ATGUIGU" scope="page"></c:set>
<%
	// 上面的set相当于:
	pageContext.setAttribute("name", "atguigu") ;
%>
得到set标签设置的值:${pageScope.name }
<br>
<c:set var="subject" value="${param.subject }" scope="session"></c:set>
subject:${sessionScope.subject }
<br>
<%
	Customer customer = new Customer() ;
	customer.setId(1001) ;
	request.setAttribute("customer", customer) ;
%>
ID:${requestScope.customer.id }
<c:set target="${requestScope.customer}" property="id" value="15"></c:set>
<br>
重新设置后的ID:${requestScope.customer.id }
<br>

<!-- c:remove -->
<h4>c:remome:移除指定域对象的指定属性;</h4>
<c:set value="1997-09-1" var="date" scope="session"></c:set>
session中设置了date:${sessionScope.date }
<br>
<c:remove var="date"/>
session中被remove了之后date:${sessionScope.date }
<br>

<!-- 流程控制 -->
<h4>C:IF,没有else操作,但可以把判断的结果保存到范围域中,以备之后使用.</h4>
<c:set value="20" var="age" scope="request"></c:set>
<c:if test="${requestScope.age > 18 }">成年了</c:if>
<br>
可以把测试的结果保存到属性域中:<c:if test="${param.age > 18 }" var="isAdult" scope="request"></c:if>
<br>
取出保存的测试结果:siAdult:<c:out value="${requestScope.isAdult }"></c:out>
<br>

<h4>c:choose,c:when,c:otherwise可以实现if...else...else if ...else效果,较为麻烦;
	其中:c:choose以c:when,c:otherwise的父标签出现.
	c:when,c:otherwise不能脱离c:choose单独使用.
	c:otherwise必须在c:when之后使用;
</h4>
<c:choose>
	<c:when test="${param.age > 18 }">青年</c:when>
	<c:when test="${param.age > 60 }">老年</c:when>
	<c:when test="${param.age > 40 }">中年</c:when>
	<c:otherwise>未成年</c:otherwise>
	
</c:choose>
<br>

<!-- 迭代操作 -->
<h4>迭代操作:c:forEach,可以对数组,集合,Map进行遍历,对于集合begin从0开始;</h4>
<%
	List<Customer> custs = new ArrayList<Customer>() ;
	custs.add(new Customer(1,"AA",21)) ;// index:0,begin=0
	custs.add(new Customer(1,"AA",32)) ;
	custs.add(new Customer(1,"AA",43)) ;
	custs.add(new Customer(1,"AA",43)) ;
	
	request.setAttribute("custs", custs) ;
%>
没有集合:items::
<c:forEach begin="1" end="10" step="3" var="i">
	${i }--
</c:forEach>
<br>
遍历集合,数组:
<c:forEach items="${requestScope.custs }" var="cust" varStatus="status">
	<br>${cust.id }:${cust.name }:${cust.age } : 索引:${status.index }:当前执行了的数量:${status.count }:是否第一个${status.first }:是否最后一个${status.last }

</c:forEach>
<br>
<!-- 遍历Map -->
<%
	Map<String,Customer> custMap = new HashMap<String,Customer>() ;
	custMap.put("a",new Customer(1,"AA",21)) ;
	custMap.put("b",new Customer(1,"AA",32)) ;
	custMap.put("c",new Customer(1,"AA",43)) ;
	custMap.put("d",new Customer(1,"AA",43)) ;
	
	request.setAttribute("custMap", custMap) ;
%>
遍历Map:<br>
<c:forEach items="${requestScope.custMap }" var="cust">
	${cust.key } - ${cust.value.age } - ${cust.value.name }<br>
</c:forEach>
<br>

遍历属性名:
<%
	session.setAttribute("abc", "abc") ;
%>
<c:forEach items="${pageContext.session.attributeNames }" var="attrName">
	${attrName }--
</c:forEach>
<br>
c:forTokens:处理字符串的,类似于String的split()方法;
<c:set value="a.b,c.d.ef;g;h;j" var="test" scope="request"></c:set>
<c:forTokens items="${requestScope.test }" delims="." var="s">
	${s }<br>

</c:forTokens>
<br>
<h4>c:import可以任何页面到当前页面,包括其他web应用的文件:</h4>
<%-- <c:import url="http://www.baidu.com"></c:import> --%>
<br>
<h4>c:redirect使当前页面重定向到指定的页面.使当前JSP转发到指定页面可以使用<%-- <jsp://forward page=""></jsp:forward> --%>
	/代表当前应用的根目录;而///response.sendRedirect("/")中的/代表web站点的根目录;
</h4>
<%-- <c:redirect1 url="/test.jsp"></c:redirect> --%>
<br>
<h4>c:url产生一个url地址.Cookies可以智能进行URL重写,,对GET请求的参数进行编码,并且可以保存:
rul:/JavaWeb_atguitu/login.jsp;jsessionid=7FBFD9F4391C360F6B8FA3CBF5F5D9BC?name=%e5%b0%9a%e7%a1%85%e8%b0%b7%3b  </h4>
<c:url value="/login.jsp" var="testUrl">
	<c:param name="name" value="尚硅谷;"></c:param>
</c:url>
rul:${pageScope.testUrl }
<br>
</body>
</html>