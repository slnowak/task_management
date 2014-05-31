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
    <title>Tasks</title>
</head>
<body>
    <p>Tasks:</p>
    <table border="2">
        <thead>
            <tr>
                <td>Name</td>
                <td>Description</td>
                <td>Done</td>
                <td>Action</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="task" items="${tasks}">
                <tr>
                    <td>${task.name}</td>
                    <td>${task.description}</td>
                    <td>${task.done}</td>
                    <td>
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
