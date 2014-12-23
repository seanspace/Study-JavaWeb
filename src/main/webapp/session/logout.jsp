<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	out.print("SessionId:" + session.getId()) ;
	out.print("<br><br>") ;
	
	out.print("IsNew:" + session.isNew()) ;
	out.print("<br><br>") ;
	
	out.print("MaxInactiveInternal:" + session.getMaxInactiveInterval()) ;
	out.print("<br><br>") ;
	
	out.print("createTime:" + session.getCreationTime()) ;
	out.print("<br><br>") ;
	
	out.print("lastAccessTime:" + session.getLastAccessedTime()) ;
	out.print("<br><br>") ;
	
	out.print("Bye:" + session.getAttribute("username")) ;
	out.print("<br><br>") ;
	
	session.invalidate() ;
	
%>
<a href="login.jsp" >重新登陆</a>

</body>
</html>