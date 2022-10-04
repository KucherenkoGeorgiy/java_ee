<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Choose the order</title>
</head>
<body>
	<jsp:include page="head.jsp"/>
	<p>Выбери номер заказа из списка:</p>
	<p>
		<form action="http://localhost:8080/crm/test" method="post">
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