<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Макс
  Date: 23.11.2016
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление пользователя</title>
</head>
<body>



<c:url var="addAction" value="/add"/>

<form:form action="${addAction}" commandName="user" method="post">
    <table>
        <c:if test="${!empty user.name}">
        <tr>
            <td>Id:</td>
            <td>
                <form:input path="id" readonly="true" size="8" disabled="true"/>
                <form:hidden path="id"/>
            </td>
        </tr>
        </c:if>


        <tr>
            <td>Name:</td>
            <td><form:input path="name"/></td>
        </tr>

        <tr>
            <td>Age:</td>
            <td><form:input path="age"/></td>
        </tr>

        <tr>
            <td>Admin:</td>
            <td><form:checkbox path="admin"/></td>
        </tr>

    </table>
    <c:if test="${empty user.name}">
        <input type="submit" value="<spring:message text="Add user"/>"/>
    </c:if>
    <c:if test="${!empty user.name}">
        <input type="submit" value="<spring:message text="Update user"/>"/>
    </c:if>

</form:form>


</body>
</html>
