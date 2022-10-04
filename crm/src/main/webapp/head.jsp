<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table align="center" border="0" cellpadding="1" cellspacing="1">
	<tbody>
		<tr>
			<td style="text-align:center">Полная информацию о заданном заказе</td>
			<td style="text-align:center">Заказы, сумма которых не превосходит заданную, и количество различных товаров равно заданному</td>
			<td style="text-align:center">Заказы, содержащие заданный товар</td>
			<td style="text-align:center">Заказы, не содержащие заданный товар и поступившие в течение текущего дня</td>
			<td style="text-align:center">Новый заказ, состоящий из товаров, заказанных в текущий день</td>
			<td style="text-align:center">Удалить заказы, в которых присутствует заданное количество заданного товара</td>
		</tr>
		<tr>
			<td style="text-align:center"><form action="http://localhost:8080/crm/test" method="get">
			<input name="getDetailedOrderByOrderId" type="submit" value="Run" /></form></td>
			<td style="text-align:center"><form action="http://localhost:8080/crm/finderbysumandquantity" method="get">
			<input name="getByTotMaxAndQuantityOfDifGoods" type="submit" value="Run" /></form></td>
			<td style="text-align:center"><form action="http://localhost:8080/crm/chooseproduct" method="get">
			<input name="getOrdersThatContainTheProduct" type="submit" value="Run" /></form></td>
			<td style="text-align:center"><form action="http://localhost:8080/crm/chooseproductwithfilter" method="get">
			<input name="getOrdersThatDoNotContainTheProductAndContainCurDate" type="submit" value="Run" /></form></td>
			<td style="text-align:center"><form action="http://localhost:8080/crm/createneworder" method="get">
			<input name="addNewOrderWithCurDate" type="submit" value="Run" /></td></form></td>
			<td style="text-align:center"><form action="http://localhost:8080/crm/deleteorders" method="get">
			<input name="deleteOrdersThatContainTheProductWithQuantity" type="submit" value="Run" /></td></form></td>
		</tr>
	</tbody>
</table>