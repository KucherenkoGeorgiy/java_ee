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
	<fmt:message key="login.top"/><br />
</p>
<p>
	<form action="/crm/login" method="post">
		<input type="text" name="name" >  &nbsp;&nbsp;<fmt:message key="login.inputname"/><br>
		<input type="text" name="password" >  &nbsp;&nbsp;<fmt:message key="login.inputpassword"/><br>
		<input name="submitChoosing" type="submit" value=<fmt:message key="login.button"/>/>
	</form>
	<c:if test="${not empty errorMessage}">
	    ${errorMessage}
	</c:if>
</p>
</body>
</html>