<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Find by total and quantity of different goods</title>
</head>
<body>
    <%@ include file="/jspf/head.jspf" %>
	<p><fmt:message key="finderbysumamountandquantity.top"/></p>
	<p>
		<form action="/crm/finderbysumandquantity" method="post">
			<input type="text" name="chooseSum">&nbsp;<fmt:message key="finderbysumamountandquantity.input1"/><br>
			<input type="text" name="chooseQuantity" >&nbsp;<fmt:message key="finderbysumamountandquantity.input2"/><br>
			<input name="submitChoosing" type="submit" value=<fmt:message key="finderbysumamountandquantity.submit"/>/>
		</form>
	</p>
</body>
</html>