<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bye</title>
</head>
<body>

    Bye-bye!
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
                    <td><button onclick="location.href='/'">Delete</button></td>


                </tr>
            </c:forEach>
        </table>
    </div>
    <!--div>
    ${singleCars}
</div-->
</body>
</html>
