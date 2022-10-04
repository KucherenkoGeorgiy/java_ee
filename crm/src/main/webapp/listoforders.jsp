<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of Orders</title>
</head>
<body>
	<jsp:include page="head.jsp"/>
	<p>${filtersOfSearch.toString()}</p><br>
	<table border="1" cellpadding="1" cellspacing="1">
		<thead>
			<tr bgcolor="#ecf0f1">
				<th scope="col">Order ID</span></th>
				<th scope="col">Date of order</span></th>
				<th scope="col">Order details</span></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listOfOrders}" var="item">
				<tr>
					<td>${item.getId()}</td>
					<td scope="col">${item.getDate()}</td>
					<td style="text-align:leftchooseorder.jsp">${item.toString()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
