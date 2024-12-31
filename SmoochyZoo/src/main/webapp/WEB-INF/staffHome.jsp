<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Staff Home - Smoochy Zoo</title>
<%@  include file="bootstraphead.jsp"%>
<style>

</style>
</head>
<body>
	<jsp:include page="nav.jsp" />

	<!-- starting code to get a base for these pages -->
	<h1>Welcome, Staff Member!</h1>

	<p>You're logged in as a staff member. Here are your available
		options:</p>


	<!-- Staff-specific content -->
	<div>
		<h2>Animal Care Information</h2>
		<!-- Provide options for staff to manage animals, schedules, etc. -->

		<jsp:include page="animalhome.jsp" />
		<jsp:include page="animalCRUD.jsp" />
	</div>


	<!-- Logout Button -->
	<form action="logout.do" method="post">
		<button type="submit">Logout</button>
	</form>

	<%@  include file="bootstrapfooter.jsp"%>

</body>
</html>