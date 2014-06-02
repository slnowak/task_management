<%--
  Created by IntelliJ IDEA.
  User: novy
  Date: 02.06.14
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
    <title></title>
</head>
<body>
    <p>Register:</p>

    <form:form modelAttribute="user" action="${pageContext.request.contextPath}/register" method="POST">
        <fieldset>
            <table>
                <tr>
                    <td>
                        <form:label path="username">Username</form:label>
                    </td>
                    <td>
                       <form:input path="username" />
                       <form:errors path="username" cssClass=""/>
                    </td>
                </tr>

                <tr>
                    <td>
                        <form:label path="password">Password</form:label>
                    </td>
                    <td>
                        <form:password path="password" />
                        <form:errors path="password" cssClass=""/>
                    </td>
                </tr>

                <tr>
                    <td>
                        <form:label path="firstName">Fist Name:</form:label>
                    </td>
                    <td>
                        <form:input path="firstName" />
                        <form:errors path="firstName" cssClass=""/>
                    </td>
                </tr>

                <tr>
                    <td>
                        <form:label path="lastName">Last Name:</form:label>
                    </td>
                    <td>
                        <form:input path="lastName" />
                        <form:errors path="lastName" cssClass=""/>
                    </td>
                </tr>

                <tr>
                    <td>
                        <form:label path="email">Email</form:label>
                    </td>
                    <td>
                        <form:input path="email"/>
                        <form:errors path="email" cssClass=""/>
                    </td>
                </tr>

                <tr>
                    <td>
                        <button type="submit">Submit!</button>
                    </td>
                    <td>
                        <button type="reset">Reset!</button>
                    </td>
                </tr>
            </table>
        </fieldset>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form:form>

</body>
</html>
