<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="form1" action="loginServlet" method="post">
	user:<input type="text" name="user"/>
	password:<input type="password" name="password"/>
	interesting:
	<input type="checkbox" name="interesting" value="reading" />Reading
	<input type="checkbox" name="interesting" value="Game" />Game
	<input type="checkbox" name="interesting" value="Party" />Party
	<input type="submit" name="提交" />
</form>
</body>
</html>