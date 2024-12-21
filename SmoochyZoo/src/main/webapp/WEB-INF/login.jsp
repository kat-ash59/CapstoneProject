<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<%@ include file="bootstraphead.jsp"%>
<style>
body {
	background-image: linear-gradient(rgba(255, 255, 255, 0.75),
		rgba(255, 255, 255, 0.75)), url("images/SmoochyZoo.jpg");
}
</style>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<h2>Login to Smoochy Zoo</h2>

		<c:if test="${not empty errorMessage}">
			<div class="alert alert-danger">${errorMessage}</div>
		</c:if>

		<!-- Form for login -->

		<form action="login.do" method="POST">
			<div class="form-group">
				<label for="username">Username:</label> <input type="text"
					name="username" class="form-control" required>
			</div>
			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					name="password" class="form-control" required>
			</div>
			<c:choose>
				<c:when test="${param.role == 'staff'}">
					<input type="hidden" name="role" value="staff">
					<button type="submit" class="btn btn-primary">Staff Login</button>
				</c:when>

				<c:when test="${param.role == 'member'}">
					<input type="hidden" name="role" value="member">
					<button type="submit" class="btn btn-primary">Member Login</button>

				</c:when>
				<c:otherwise>
					<p>Invalid role</p>
				</c:otherwise>
			</c:choose>
		</form>

	</div>

	<%@ include file="bootstrapfooter.jsp"%>

</body>
</html>