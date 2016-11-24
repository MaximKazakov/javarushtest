<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Макс
  Date: 23.11.2016
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список</title>

    <style type="text/css">
        .cells {
            text-align: center;
        }


    </style>

</head>
<body>


<a href="<c:url value="/addPage"/>">Add new user</a>

<br>
<br>
<br>


<form:form action="/list" commandName="filter" method="get">
    <table>

        <tr>
            <td>Beginning of name:</td>
            <td><form:input path="name"/></td>
            <td><input type="submit" value="<spring:message text="Apply"/>"/></td>
        </tr>

    </table>


</form:form>

<br>

<c:if test="${listUsers.size() > 0}">
<h1>List of users:</h1>



<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Name</th>
        <th width="120">Age</th>
        <th width="60">IsAdmin</th>
        <th width="120">CreatedDate</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listUsers}" var="user">
        <tr>
            <td class="cells">${user.id}</td>
            <td class="cells"><a href="/bookdata/${user.id}" target="_blank">${user.name}</a></td>
            <td class="cells">${user.age}</td>
            <td class="cells">${user.admin}</td>
            <td class="cells">${user.createdDate}</td>


            <td class="cells"><a href="<c:url value='/editPage/${user.id}'/>">Edit</a></td>
            <td class="cells"><a href="<c:url value='/remove/${user.id}'/>">Delete</a></td>
        </tr>
    </c:forEach>
</table>

<c:forEach var="item" begin = "1" end = "${countPages}">
    <a href="<c:url value='/list/${item}'/>"> ${item} </a>&nbsp&nbsp

</c:forEach>
</c:if>
<c:if test="${listUsers.size() == 0}">
    <h1>No users</h1>
</c:if>

</body>
</html>
