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
	out.print(session.getId()) ;
	// 测试一下session是否在request.getCookies()方法中.测试结果是:下面的循环中包含了JSESSIONID;;
	Cookie[] cookies = request.getCookies();
	for (Cookie cooki:cookies){
		out.print("<br>for::cookie:" + cooki.getName()) ;
	}
	// 使用cookie对session进行持久化;
	Cookie cookie = new Cookie("JSESSIONID",session.getId()) ;
	cookie.setMaxAge(20) ;
	response.addCookie(cookie) ;
	
	// 不会创建session对象;
	request.getSession(false) ;// 若没有和当前关联的httpSession对象则返回null;
	request.getSession() ;// 得到一个session对象;没有就创建一个;
	request.getSession(true) ;// 一定返回一个httpSession对象;若没有关联的,创建一个;
	// 最长有效时间
	session.getMaxInactiveInterval() ;
	session.setMaxInactiveInterval(5) ;
%>
</body>
</html>