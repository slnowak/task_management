<%--
  Created by IntelliJ IDEA.
  User: novy
  Date: 31.05.14
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
    <title>Tasks</title>
</head>
<body>
    <p>List of all tasks:</p>
    <table border="2">
        <thead>
            <tr>
                <td>Name</td>
                <td>Actions</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="task" items="${tasks}">
                <tr>
                    <td>${task.name}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/tasks/${task.id}">Details</a>
                        <a href="${pageContext.request.contextPath}/tasks/edit/${task.id}">Edit!</a>
                        <a href="${pageContext.request.contextPath}/tasks/delete/${task.id}">Delete!</a>
                    </td>
                    <%--TODO: change to js or xml req--%>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <br><br>
    <a href="${pageContext.request.contextPath}/tasks/add">Add new task</a>

</body>
</html>
