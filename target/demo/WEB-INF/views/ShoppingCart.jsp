<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="cart" scope="session"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title>Shopping Cart</title>
    </head>
    <body>
        <p><a href=home>Product List</a></p>
        <table width="100%" border="1">
            <tr bgcolor="#CCCCCC">
                <td>Model Description</td>   <td>Quantity</td>
                <td>Unit Price</td>     <td>Total</td>
            </tr>
            <c:if test="${cart.lineItemCount==0}">
                <tr>
                    <td colspan="4">Your Shopping cart is empty. <br />
                </tr>
            </c:if>
            <c:forEach var="cartItem" items="${cart.cartItems}"     varStatus="counter">
                <form name="item" method="post" action="cart">
                    <tr>
                        <td>
                            <c:out value="${cartItem.partNumber}" /></b><br />
                            <c:out value="${cartItem.modelDescription}" />
                        </td>
                        <td>
                            <input type="hidden" name="itemIndex" value='<c:out value="${counter.count}"/>'>
                            <input type="text" name="quantity" value='<c:out value="${cartItem.quantity}"/>' size="2">
                            <input type="submit" name="action" value="Update">
                            <input type="submit" name="action" value="Delete">
                        </td>
                        <td>$<c:out value="${cartItem.unitCost}" /></td>
                        <td>$<c:out value="${cartItem.totalCost}" /></td>
                    </tr>
                </form>
            </c:forEach>
            <tr>
                <td colspan="2"></td>
                <td></td>
                <td>Subtotal: $<c:out value="${cart.orderTotal}" /></td>
            </tr>
        </table>
    </body>
</html>
