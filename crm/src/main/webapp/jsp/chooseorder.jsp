<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<title>Choose the order</title>
</head>
<body>
	<c:import url="/jspf/head.jspf" />
	<p>Choose order from below list:</p>
	<p>
		<form action="/crm/chooseorder" method="post">
			<select name="chooseOrder" required="required" size="1">
				<c:forEach items="${testList}" var="item">
					<option value = "${item.getId()}">${item.getId()} dated ${item.getDate()}</option>
				</c:forEach>
			</select>
			<input name="submitChoosing" type="submit" value="Submit" />
		</form>
	</p>
</body>
</html>