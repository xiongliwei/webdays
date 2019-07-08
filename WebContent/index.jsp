<%@ page import="java.io.PrintWriter" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body bgcolor="pink">
		<% String errorInfo=(String)request.getAttribute("errorInfo"); %>

		<form action="/WebDay3/login" method="post">
			用户姓名： <input name="username" >
			<span><%=errorInfo==null ? "" : errorInfo %></span>
			<br>
			用户密码： <input name="password" type="password" ><br>
			<input value="提交" type="submit" >
		</form>
		
</body>
</html>