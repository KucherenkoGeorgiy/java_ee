<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
<title>Create new order</title>
</head>
<body>
    <%@ include file="/jspf/head.jspf" %>
	<p>
		<fmt:message key="createneworder.top1"/><br />
		<fmt:message key="createneworder.top2"/>
	</p>
	<p>
		<fmt:message key="createneworder.top3"/><br />
		<form action="/crm/createneworder" method="post">
			<input name="submitChoosing" type="submit" value=<fmt:message key="createneworder.button"/>/>
		</form>
	</p>
</body>
</html>