<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Choose product</title>
</head>
<body>
    <%@ include file="/jspf/head.jspf" %>
	<p>
	    <fmt:message key="chooseproduct.top1"/><br>
	    <fmt:message key="chooseproduct.top2"/>
	</p>
	<p>
		<form action="/crm/chooseproduct" method="post">
			<select name="chooseProduct" required="required" size="1">
				<c:forEach items="${productList}" var="item">
					<option value = "${item.getId()}">${item.getName()}</option>
				</c:forEach>
			</select>
			<input name="submitChoosing" type="submit" value=<fmt:message key="chooseorder.submit"/>/>
		</form>
	</p>
</body>
</html>