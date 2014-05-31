<%--
  Created by IntelliJ IDEA.
  User: novy
  Date: 31.05.14
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h1>Edit task</h1>
<form:form method="POST" action="${pageContext.request.contextPath}/tasks/edit" modelAttribute="task">
    <fieldset>
        <table>
            <form:hidden path="id"/>
            <tr>
                <td><form:label path="name">Name:</form:label></td>
                <td>
                    <form:input path="name"/><br>
                    <form:errors path="name" cssClass=""/>
                </td>
            </tr>
            <tr>
                <td><form:label path="description">Description:</form:label></td>
                <td>
                    <form:input path="description"/> <br>
                    <form:errors path="description" cssClass=""/>
                </td>
            </tr>
            <tr>
                <td><form:label path="done">Status:</form:label></td>
                <td><form:checkbox path="done" label="Done" /></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Save"/>
                    <a href="${pageContext.request.contextPath}/tasks">Cancel</a>
                </td>
            </tr>
        </table>
    </fieldset>
</form:form>
<br/>
</body>
</html>