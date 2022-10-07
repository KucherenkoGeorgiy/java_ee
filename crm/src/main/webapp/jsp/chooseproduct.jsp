<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Choose the product</title>
</head>
<body>
	<c:import url="/jspf/head.jspf"/>
	<p>
	    Choose the product<br>
	    (we will find all orders that contain this product)
	</p>
	<p>
		<form action="/crm/chooseproduct" method="post">
			<select name="chooseProduct" required="required" size="1">
				<c:forEach items="${productList}" var="item">
					<option value = "${item.getId()}">${item.getName()}</option>
				</c:forEach>
			</select>
			<input name="submitChoosing" type="submit" value="Submit"/>
		</form>
	</p>
</body>
</html>