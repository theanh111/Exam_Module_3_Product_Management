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
    <title>List Product</title>
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
    <h1>Product</h1>
    <a href="index.jsp" class="btn btn-success">Back</a>
    <hr>
    <form autocomplete="off">
        <input type="hidden" name="action" value="searchProductByName">
        <input type="text" name="searchProductByName" id="searchProductByName" placeholder="Product Name...">
        <input type="submit" class="btn btn-success" value="Search">
    </form>
    <hr>
    <a href="/product?action=add" class="btn btn-success">Add New Product</a>
    <table border="1" cellpadding="20">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Color</th>
            <th>Category</th>
            <th colspan="2">Action</th>
        </tr>

        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.getProductId()}</td>
                <td>${product.getProductName()}</td>
                <td>${product.getProductPrice()}</td>
                <td>${product.getProductQuantity()}</td>
                <td>${product.getProductColor()}</td>
                <td>${product.getCategory().categoryName}</td>
                <td><a href="/product?action=edit&productId=${product.getProductId()}"
                       class="btn btn-secondary">EDIT</a></td>
                <td><a href="/product?action=delete&productId=${product.getProductId()}"
                       class="btn btn-danger">DELETE</a></td>
            </tr>
        </c:forEach>
    </table>
</center>
</body>
</html>
