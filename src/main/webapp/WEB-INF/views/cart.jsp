<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!-- using JSTL -->
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <style>
      table{
        border-collapse: collapse;
      }
      .tr{
        text-align: right;
      }
      a{
        text-decoration: none;
        color: black;
        font-size: 22px;
        font-weight: bold;
      }
    </style>
  </head>
  <body>
    <h1 href ="home">Add Cart</h1>
    <table width="60%" border="1px">
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Total money</th>
        <th>Action</th>
      </tr>
      <c:set var="o" value="${requestScope.cart}"/>
      <c:set var="tt" value="0"/>
      <c:forEach items="${o.items}" var="i">
        <c:set var="tt" value="${tt+1}"/>
        <tr>
          <td>${tt}</td>
          <td>${i.product.name}</td>
          <td style ="text-align: center">
            <button><a href ="process?num=-1&id=${i.product.id}">-</a></button>
            ${i.quantity}
            <button><a href ="process?num=1&id=${i.product.id}">+</a></button>
          </td>
          <td>${i.price}</td>
          <td>${(i.price*i.quantity)}</td>
          <td style="text-align: center">
            <form action="process" method="post">
              <input type="hidden" name="id" value="${i.product.id}" />
              <input type="submit" value="return item" />
            </form>   
          </td>
        </tr>
      </c:forEach> 
    </table>
      <h3>Total money: ${o.sum}</h3>
  </body>

</html>

