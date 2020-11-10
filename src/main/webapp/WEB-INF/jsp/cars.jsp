<%--
  Created by IntelliJ IDEA.
  User: andrewkashpar
  Date: 09.11.2020
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Cars</title>
</head>
<body>
<div>
    <table>
        <tr>
            <td>Cars Id</td>
            <td>Model</td>
            <td>Creation_year</td>
            <td>User_Id</td>
            <td>Price</td>
            <td>Color</td>

        </tr>
        <c:forEach var="cars" items="${cars}">
            <tr>
                <td>${cars.id}</td>
                <td>${cars.model}</td>
                <td>${cars.creationYear}</td>
                <td>${cars.userId}</td>
                <td>${cars.price}</td>
                <td>${cars.color}</td>
                <td><button onclick="location.href='/'">Delete</button></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>

