<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of Orders</title>
</head>
<body>
	<c:import url="/jspf/head.jspf" />
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
						<table border="0" cellpadding="3" cellspacing="0">
                            <tbody>
                                <c:forEach items="${item.getRecordsOfOrder()}" var="recordOfOrder">
                                     <tr>
                                          <td style="text-align:left">id=${recordOfOrder.getProduct().getId()};</td>
                                          <td style="text-align:left">name=${recordOfOrder.getProduct().getName()};</td>
                                          <td style="text-align:left">describing=${recordOfOrder.getProduct().getDescribing()};</td>
                                          <td style="text-align:left">price=${recordOfOrder.getProduct().getPrice()};</td>
                                          <td style="text-align:left">quantity=${recordOfOrder.getQuantityOfProduct()}</td>
                                     </tr>
                                </c:forEach>
                            </tbody>
                        </table>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
