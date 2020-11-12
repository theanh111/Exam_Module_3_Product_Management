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
    <title>Add New Product</title>
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
    <c:if test="${product != null}">
        <span>${message}</span>
    </c:if>
    <a href="/product" class="btn btn-success">Back</a>
    <hr>
    <form method="post">
        <table border="1" cellpadding="20">
            <tr>
                <th>Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Color</th>
                <th>Description</th>
                <th>Category</th>
            </tr>
            <tr>
                <td><input type="text" name="productName" id="productName" placeholder="iPhone.."></td>
                <td><input type="number" name="productPrice" id="productPrice" placeholder="54.99..."></td>
                <td><input type="number" name="productQuantity" id="productQuantity" placeholder="10..."></td>
                <td><input type="text" name="productColor" id="productColor" placeholder="Black, Pink,..."></td>
                <td><input type="text" name="productDesc" id="productDesc" placeholder="This is a description..."></td>
                <td>
                    <input type="text" name="categoryName" id="categoryName" placeholder="Phone...">
                </td>

            </tr>
        </table>
        <input type="submit" value="Add New">
    </form>
</center>
</body>
</html>
