<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test JSP</title>
</head>
<body>
<jsp:include page="head.jsp"/>
<p><br />
Выбери номер заказа из списка:</p>

<p>
    <select name="chooseOrder" required="required" size="1">
        <c:forEach items="${testList}" var="item">
            <option value=${item}>${item}</option>
        </c:forEach>
    </select>
	<input name="submitChoosing" type="button" value="OK" />
&nbsp; &nbsp; &nbsp;
</p>

<p>&nbsp;</p>
</body>
</html>