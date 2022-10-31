<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
	<title>Choose order</title>
</head>
<body>
    <%@ include file="/jspf/head.jspf" %>
	<p><fmt:message key="chooseorder.top"/></p>
	<p>
		<form action="/crm/chooseorder" method="post">
			<select name="chooseOrder" required="required" size="1">
				<c:forEach items="${testList}" var="item">
					<option value = "${item.getId()}">${item.getId()}&nbsp;<fmt:message key="chooseorder.list"/>&nbsp;${item.getDate()}</option>
				</c:forEach>
			</select>
			<input name="submitChoosing" type="submit" value=<fmt:message key="chooseorder.submit"/>/>
		</form>
	</p>
</body>
</html>