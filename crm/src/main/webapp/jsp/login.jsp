<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <%@ include file="/jspf/head.jspf" %>
<p>
	Type your name and password<br />
</p>
<p>
	<form action="/crm/login" method="post">
		<input type="text" name="name" >  input your name here<br>
		<input type="text" name="password" >  input your password here<br>
		<input name="submitChoosing" type="submit" value="Login"/>
	</form>
	<c:if test="${not empty errorMessage}">
	    ${errorMessage}
	</c:if>
</p>
</body>
</html>