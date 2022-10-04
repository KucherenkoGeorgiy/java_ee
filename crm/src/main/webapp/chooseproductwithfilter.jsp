<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find specific orders</title>
</head>
<body>
<jsp:include page="head.jsp"/>
<p>
	Choose the product<br />
	(we will filter orders made today that include this product):
</p>
<p>
	<form action="http://localhost:8080/crm/chooseproductwithfilter" method="post">

		<select name="chooseProduct" required="required" size="1">
			<c:forEach items="${productList}" var="item">
				<option value = "${item.getId()}">${item.getName()}</option>
			</c:forEach>
		</select>
		<input name="submitChoosing" type="submit" value="Submit" />
	</form>
</p>
</body>
</html>