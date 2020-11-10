<%--
  Created by IntelliJ IDEA.
  User: andrewkashpar
  Date: 10.11.2020
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
</head>
<body>
<h3>Welcome, Enter The Cars Details</h3>
<form:form method="POST"
           action="/cars" modelAttribute="carsCreateRequest">
    <table>
        <tr>
            <td><form:label path="model">Model</form:label></td>
            <td><form:input path="model"/>${carsCreateRequest.model}</td>
        </tr>
        <tr>
            <td><form:label path="creationYear">Creation Yaer</form:label></td>
            <td><form:input path="creationYear"/></td>
        </tr>
        <tr>
            <td><form:label path="userId">
                User ID</form:label></td>
            <td><form:input path="userId"/></td>
        </tr>
        <tr>
            <td><form:label path="price">
                Price</form:label></td>
            <td><form:input path="price"/></td>
        </tr>
        <tr>
            <td><form:label path="color">
                Color</form:label></td>
            <td><form:input path="color"/></td>
        </tr>


        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
