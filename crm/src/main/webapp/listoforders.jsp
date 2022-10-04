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
	<br>
	<p>${filtersOfSearch.toString()}</p>
	<table border="1" cellpadding="3" cellspacing="0" bordercolor="grey">
		<thead>
			<tr bgcolor="#ecf0f1">
				<th scope="col" nowrap>&nbsp;&nbsp;&nbsp;Order ID&nbsp;&nbsp;&nbsp;</span></th>
				<th scope="col" nowrap>&nbsp;&nbsp;&nbsp;Date of order&nbsp;&nbsp;&nbsp;</span></th>
				<th scope="col" nowrap>&nbsp;&nbsp;&nbsp;Order details&nbsp;&nbsp;&nbsp;</span></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listOfOrders}" var="item">
				<tr>
					<td style="text-align:center">${item.getId()}</td>
					<td style="text-align:center" scope="col" nowrap>${item.getDate()}</td>
					<td style="text-align:leftchooseorder.jsp">
							<c:forEach items="${item.getRecordsOfOrder()}" var="recordOfOrder">
								${recordOfOrder.getProduct().toString()}, quantity=${recordOfOrder.getQuantityOfProduct().toString()}<br>
                            </c:forEach>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
