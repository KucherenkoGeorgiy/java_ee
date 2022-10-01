<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test JSP</title>
</head>
<body>
<jsp:include page="head.html"/>

	<c:forEach items="${testList}" var="item">
		<h1>${item}</h1>
	</c:forEach>

</body>
</html>