<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试</title>
</head>
<body>
<form action="user/showAll" method="post">
	<table cellpadding="10" cellspacing="0" align="center">
		<tr>
			<th>编号</th>
			<th>用户名</th>
			<th>密码</th>
			<th>编辑</th>
			<th>删除</th>
		</tr>
		
		<c:forEach items="${list}" var="u">
		<tr>
			<td>${u.id }</td>
			<td>${u.username }</td>
			<td>${u.password }</td>
			<td><a href="">Edit</a></td>
			<td><a href="">Delete</a></td>
		</tr>
		</c:forEach>
	</table>
</form>
</body>
</html>