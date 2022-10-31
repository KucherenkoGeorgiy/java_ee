<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Deleting orders</title>
</head>
<body>
    <%@ include file="/jspf/head.jspf" %>
	<p>
		<fmt:message key="deletewithfilter.top1"/><br />
		<fmt:message key="deletewithfilter.top2"/><br />
		<fmt:message key="deletewithfilter.top3"/>
	</p>
	<p>
		<form action="/crm/deleteorders" method="post">
				<select name="chooseProduct" required="required" size="1">
					<c:forEach items="${productList}" var="item">
						<option value = "${item.getId()}">${item.getName()}</option>
					</c:forEach>
				</select>
			<input type="text" name="chooseQuantity" >&nbsp;&nbsp;<fmt:message key="deletewithfilter.inputquantity"/><br>
			<input name="submitChoosing" type="submit" value=<fmt:message key="deletewithfilter.button"/>/>
		</form>
	</p>
</body>
</html>