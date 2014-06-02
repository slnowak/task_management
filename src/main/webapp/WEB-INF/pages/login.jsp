<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
    <title>Login Page</title>
</head>
    <body>
		<form action="<c:url value='/login'/>" method='POST'>
			<table>
				<tr>
					<td>
                        <label for="username">Username</label>
                    </td>
					<td>
                        <input id="username" type='text' name='username'>
                    </td>
				</tr>

				<tr>
					<td>
                        <label for="password">Password:</label>
                    </td>
					<td>
                        <input id="password" type='password' name='password'/>
                    </td>
				</tr>

				<tr>
					<td>
                        <button type="submit">Login!</button>
					</td>
				</tr>
			</table>

			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

		</form>
    </body>
</html>