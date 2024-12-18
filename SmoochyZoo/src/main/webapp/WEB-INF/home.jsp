<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>The Smoochy Zoo</title>
</head>
<body>
	<h1>Welcome To Smoochy Zoo!</h1>

	<h3>Staff Login</h3>
	<!-- Check if there's an error message  -->
	<c:if test="${not empt error}">
		<p style="color: red">${error}</p>
	</c:if>

	<form action=${pageContext.request.contextPath}/login/authentication>
		<label for="username">Username:</label> <input type="text"
			id="username" name="username" required> <br> <br> <label
			for="password">Password:</label> <input type="password" id="password"
			name="password" required>

		<button type="submit">Login</button>
	</form>

</body>
</html>