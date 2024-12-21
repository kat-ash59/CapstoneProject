<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Staff Home - Smoochy Zoo</title>
</head>
<body>

	<!-- starting code to get a base for these pages -->
	<h1>Welcome, Staff Member!</h1>

	<p>You're logged in as a staff member. Here are your available
		options:</p>

	<!-- Staff-specific content -->
	<div>
		<h2>Animal Care Information</h2>
		<!-- Provide options for staff to manage animals, schedules, etc. -->
	</div>
	<jsp:include page="animalhome.jsp"></jsp:include>
	<jsp:include page="animalCRUD.jsp"></jsp:include>
	<!-- Logout Button -->
	<form action="logout.do" method="post">
		<button type="submit">Logout</button>
	</form>
</body>
</html>