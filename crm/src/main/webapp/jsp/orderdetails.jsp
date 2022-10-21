<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detailed Order</title>
</head>
<body>
    <%@ include file="/jspf/head.jspf" %>
	<br>
	<p>${additionalInfo}</p>
	
	<p>${additionalInfo2}</p>
	<table border="1" cellpadding="3" cellspacing="0" bordercolor="grey">
		<thead>
			<tr bgcolor="#ecf0f1">
				<th scope="col"><span style="background-color:#ecf0f1">&nbsp;&nbsp;&nbsp;<fmt:message key="orderdetails.table1"/>&nbsp;&nbsp;&nbsp;</span></th>
				<th scope="col"><span style="background-color:#ecf0f1">&nbsp;&nbsp;&nbsp;<fmt:message key="orderdetails.table2"/>&nbsp;&nbsp;&nbsp;</span></th>
				<th scope="col"><span style="background-color:#ecf0f1">&nbsp;&nbsp;&nbsp;<fmt:message key="orderdetails.table3"/>&nbsp;&nbsp;&nbsp;</span></th>
				<th scope="col"><span style="background-color:#ecf0f1">&nbsp;&nbsp;&nbsp;<fmt:message key="orderdetails.table4"/>&nbsp;&nbsp;&nbsp;</span></th>
				<th scope="col"><span style="background-color:#ecf0f1">&nbsp;&nbsp;&nbsp;<fmt:message key="orderdetails.table5"/>&nbsp;&nbsp;&nbsp;</span></th>
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
