<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
			<td style="text-align:center"><input name="getDetailedOrderByOrderId" type="button" value="Run" /></td>
			<td style="text-align:center"><input name="getByTotMaxAndQuantityOfDifGoods" type="button" value="Run" /></td>
			<td style="text-align:center"><input name="getOrdersThatContainTheProduct" type="button" value="Run" /></td>
			<td style="text-align:center"><input name="getOrdersThatDoNotContainTheProductAndContainCurDate" type="button" value="Run" /></td>
			<td style="text-align:center"><input name="addNewOrderWithCurDate" type="button" value="Run" /></td>
			<td style="text-align:center"><input name="deleteOrdersThatContainTheProductWithQuantity" type="button" value="Run" /></td>
		</tr>
	</tbody>
</table>

<p>&nbsp; &nbsp;</p>
