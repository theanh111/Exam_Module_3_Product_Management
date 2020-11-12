<%--
  Created by IntelliJ IDEA.
  User: xxtyo
  Date: 11/12/2020
  Time: 9:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete Product</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</head>
<body>
<center>
    <h1>Product Information</h1>
    <h3>Are You Sure???</h3>
    <a href="/product" class="btn btn-success">Back</a>
    <c:if test='${message!= null}'>
        <span>${message}</span>
    </c:if>
    <hr>
    <form method="post">
        <table border="1" cellpadding="20">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Color</th>
                <th>Description</th>
                <th>Category</th>
            </tr>
            <tr>
                <td>${product.getProductId()}</td>
                <td>${product.getProductName()}</td>
                <td>${product.getProductPrice()}</td>
                <td>${product.getProductQuantity()}</td>
                <td>${product.getProductColor()}</td>
                <td>${product.getProductDesc()}"</td>
                <td>${product.getCategory().categoryName}</td>
            </tr>
        </table>
        <input type="submit" value="DELETE">
    </form>
</center>
</body>
</html>
