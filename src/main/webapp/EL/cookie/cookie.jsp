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
	// 在javaWEB规范中使用Cookie类代表cookie
	// 1.创建一个Cookie对象.
	//Cookie cookie = new Cookie("name","atguigu");
	// 2.调用一response的一个方法把Cookie传给客户端;
	//response.addCookie(cookie) ;
	/* 
	Set-Cookie:JSESSIONID=AD59B97108DD996B104763E1A655F867; Path=/JavaWeb_atguitu/; HttpOnly
	Set-Cookie:name=atguigu 
	*/
	// 1.获取Cookie
	Cookie[] cookies = request.getCookies() ;
	if (cookies != null && cookies.length > 0){
		for(Cookie cookie1:cookies){
			out.print(cookie1.getName() + ":" + cookie1.getValue()) ;
			out.print("<br>") ;
		}
	} else {
		out.print("没有一个Cookie,正在创建并返回") ;
		// 1.创建一个Cookie对象.
		Cookie cookie = new Cookie("name","atguigu");
		cookie.setMaxAge(30) ;//设置30秒,在本地保存了,30秒内是有效的.
		// 2.调用一response的一个方法把Cookie传给客户端;
		response.addCookie(cookie) ;
	}
%>
</body>
</html>