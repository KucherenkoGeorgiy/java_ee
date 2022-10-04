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
	<br>
	<p>${additionalInfo.toString()}</p>
	
	<p>Order # ${detailedOrder.getId()} dated ${detailedOrder.getDate()}</p>
	
	<table border="1" cellpadding="3" cellspacing="0" bordercolor="grey">
		<thead>
			<tr bgcolor="#ecf0f1">
				<th scope="col"><span style="background-color:#ecf0f1">&nbsp;&nbsp;&nbsp;Short name&nbsp;&nbsp;&nbsp;</span></th>
				<th scope="col"><span style="background-color:#ecf0f1">&nbsp;&nbsp;&nbsp;Fool name&nbsp;&nbsp;&nbsp;</span></th>
				<th scope="col"><span style="background-color:#ecf0f1">&nbsp;&nbsp;&nbsp;Price&nbsp;&nbsp;&nbsp;</span></th>
				<th scope="col"><span style="background-color:#ecf0f1">&nbsp;&nbsp;&nbsp;Quantity&nbsp;&nbsp;&nbsp;</span></th>
				<th scope="col"><span style="background-color:#ecf0f1">&nbsp;&nbsp;&nbsp;Total&nbsp;&nbsp;&nbsp;</span></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${detailedOrder.getRecordsOfOrder()}" var="item">
				<tr>
					<td style="text-align:center">${item.getProduct().getName()}</td>
					<td style="text-align:center" scope="col">${item.getProduct().getDescribing()}</td>
					<td style="text-align:center">${item.getProduct().getPrice()}</td>
					<td style="text-align:center">${item.getQuantityOfProduct()}</td>
					<td style="text-align:center">${item.getQuantityOfProduct() * item.getProduct().getPrice()}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
