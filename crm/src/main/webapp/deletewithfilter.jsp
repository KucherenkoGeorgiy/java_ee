<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deleting orders</title>
</head>
<body>
	<jsp:include page="head.jsp"/>
	<p>
		You are going to delete orders filtered by product and quantity<br />
		choose the product and quantity of product<br />
		and push Submit to continue
	</p>
	<p>
		<form action="http://localhost:8080/crm/deleteorders" method="post">
				<select name="chooseProduct" required="required" size="1">
					<c:forEach items="${productList}" var="item">
						<option value = "${item.getId()}">${item.getName()}</option>
					</c:forEach>
				</select>
			<input type="text" name="chooseQuantity" >  input quantity product here<br>
			<input name="submitChoosing" type="submit" value="Submit" />
		</form>
	</p>
</body>
</html>