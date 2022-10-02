<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table align="center" border="0" cellpadding="1" cellspacing="1">
	<tbody>
		<tr>
			<td style="text-align:center">Вывести полную информацию о заданном заказе</td>
			<td style="text-align:center">Вывести номера заказов, сумма которых не превосходит заданную, и количество различных товаров равно заданному</td>
			<td style="text-align:center">Вывести номера заказов, содержащих заданный товар</td>
			<td style="text-align:center">Вывести номера заказов, не содержащих заданный товар и поступивших в течение текущего дня</td>
			<td style="text-align:center">Сформировать новый заказ, состоящий из товаров, заказанных в текущий день</td>
			<td style="text-align:center">Удалить все заказы, в которых присутствует заданное количество заданного товара</td>
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
			<td style="text-align:center"><input name="addNewOrderWithCurDate" type="button" value="Run" /></td>
			<td style="text-align:center"><input name="deleteOrdersThatContainTheProductWithQuantity" type="button" value="Run" /></td>
		</tr>
	</tbody>
</table>

<p>&nbsp; &nbsp;</p>
