<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
<title>Create new order</title>
</head>
<body>
	<c:import url="/jspf/head.jspf" />
	<p>
		You are going to create new order <br />
		(it will include all goods that were ordered today)
	</p>
	<p>
		push Submit to continue<br />
			<form action="/crm/createneworder" method="post">
				<input name="submitChoosing" type="submit" value="Submit" />
			</form>
	</p>
</body>
</html>