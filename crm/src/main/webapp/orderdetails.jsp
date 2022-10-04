<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detailed Order</title>
</head>
<body>
	<jsp:include page="head.jsp"/>
	
	<p>${additionalInfo.toString()}</p>
	
	<p>Order # ${detailedOrder.getId()} dated ${detailedOrder.getDate()}</p>
	
	<table border="1" cellpadding="1" cellspacing="1">
		<thead>
			<tr bgcolor="#ecf0f1">
				<th scope="col"><span style="background-color:#ecf0f1">Short name</span></th>
				<th scope="col"><span style="background-color:#ecf0f1">Fool name</span></th>
				<th scope="col"><span style="background-color:#ecf0f1">Price</span></th>
				<th scope="col"><span style="background-color:#ecf0f1">Quantity</span></th>
				<th scope="col"><span style="background-color:#ecf0f1">Total</span></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${detailedOrder.getRecordsOfOrder()}" var="item">
				<tr>
					<td>${item.getProduct().getName()}</td>
					<td scope="col">${item.getProduct().getDescribing()}</td>
					<td style="text-align:right">${item.getProduct().getPrice()}</td>
					<td style="text-align:right">${item.getQuantityOfProduct()}</td>
					<td style="text-align:right">${item.getQuantityOfProduct() * item.getProduct().getPrice()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
