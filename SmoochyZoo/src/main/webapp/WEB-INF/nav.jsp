<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
.navbar {
	background-color: rgba(255, 255, 255, 0.85);
	/* Semi-transparent white */
	z-index: 1000; /* Ensures navbar is above the background */
	position: sticky; /* Navbar stays at the top during scroll */
	top: 0; /* Aligns navbar to the top of the viewport */
}

.custom-hover {
	color: #0d6efd; /* Bootstrap's primary color */
	text-decoration: none; /* Remove underline */
}

.custom-hover:hover {
	color: #70a1ff; /* Light blue color */
	background-color: transparent; /* No background highlight */
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">

			<a class="navbar-brand" href="index.do">Home</a>
			<c:if test="${not empty loggedInUser}">
				<a class="nav-link" href="logout.do">Logout</a>
			</c:if>

			<c:if test="${empty loggedInUser}">
				<a class="nav-link text-primary custom-hover"
					href="login.do?role=staff">Staff Login</a>
				<a class="nav-link text-primary custom-hover"
					href="login.do?role=member">Member Login</a>
			</c:if>
		</div>

		</div>

	</nav>

	<%@  include file="bootstrapfooter.jsp"%>

</body>
</html>