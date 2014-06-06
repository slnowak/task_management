<%--
  Created by IntelliJ IDEA.
  User: novy
  Date: 06.06.14
  Time: 18:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
</head>
<body>
    <h3>
        Task ${task.name}
        <c:choose>
            <c:when test="${task.done}">(Done)</c:when>
            <c:otherwise>(Undone)</c:otherwise>
        </c:choose>
    </h3>

    <table border="2">
        <thead>
        <tr>
            <td>Name</td>
            <td>Description</td>
            <td>Done</td>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td>${task.name}</td>
                <td>${task.description}</td>
                <td>${task.done}</td>
            </tr>
        </tbody>
    </table>

    <a href="${pageContext.request.contextPath}/tasks">Go back!</a>


</body>
</html>
