<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/17/2020
  Time: 3:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
    <title>List</title>
</head>
<body>

<sql:setDataSource var="myDatasource" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/fstore" user="root" password=""/>
<sql:query var="result"  dataSource="${myDatasource}">
    SELECT * FROM tbproducts;
</sql:query>
<table class="table table-active">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>CRUD</th>
    </tr>
    <tr>
        <c:forEach var="row" items="${result.rows}">
    <tr>
        <td><c:out value="${row.id}"/></td>
        <td><c:out value="${row.name}"/></td>
        <td><c:out value="${row.price}"/></td>
        <td><c:out value="${row.amount}"/></td>
        <td><c:out value="${row.details}"/></td>
    </tr>
    </c:forEach>
    <form action="logout" method="post">
        <input type="submit" value="Logout">
    </form>
    </tr>
</table>


</body>
</html>
