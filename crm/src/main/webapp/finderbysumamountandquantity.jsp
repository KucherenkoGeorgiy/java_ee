<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test JSP</title>
</head>
<body>
<jsp:include page="head.jsp"/>
<p><br />
Выбери номер заказа из списка:</p>

<p>
<form action="http://localhost:8080/crm/finderbysumandquantity" method="post">

    <input type="text" name="chooseSum">  input total amount here<br>
    <input type="text" name="chooseQuantity" >  input quantity of different goods here<br>

	<input name="submitChoosing" type="submit" value="Submit" />
</form>

&nbsp; &nbsp; &nbsp;
</p>

<p>&nbsp;</p>
</body>
</html>