<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Choose the order</title>
</head>
<body>
	<c:import url="/jspf/head.jspf"/>
	<p>Type max Total and Quantity of goods:</p>
	<p>
		<form action="/crm/finderbysumandquantity" method="post">
			<input type="text" name="chooseSum">input total amount here<br>
			<input type="text" name="chooseQuantity" >input quantity of different goods here<br>
			<input name="submitChoosing" type="submit" value="Submit"/>
		</form>
	</p>
</body>
</html>