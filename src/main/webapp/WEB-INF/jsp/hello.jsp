<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>System Users</title>
</head>
<body>
<div>
    <h1>System Users</h1>
</div>
<div>
    <table>
        <tr>
            <td>User Id</td>
            <td>User Name</td>
            <td>User Surname</td>
            <td>Birth date</td>
            <td>Gender</td>
            <td>Created</td>
            <td>Changed</td>
            <td>Weight</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.surname}</td>
                <td>${user.birthDate}</td>
                <td>${user.gender}</td>
                <td>${user.created}</td>
                <td>${user.changed}</td>
                <td>${user.weight}</td>
                <td><button>Edit</button></td>
                <td><button>Delete</button></td>
            </tr>
        </c:forEach>
    </table>
</div>
<!--div>
    ${singleUser}
</div-->
</body>
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
                <td>${cars.creation_year}</td>
                <td>${cars.user_id}</td>
                <td>${cars.price}</td>
                <td>${cars.color}</td>


            </tr>
        </c:forEach>
    </table>
</div>
<!--div>
    ${singleCars}
</div-->
</body>
</html>
