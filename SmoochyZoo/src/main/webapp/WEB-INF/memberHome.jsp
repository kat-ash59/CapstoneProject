<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Login Screen</title>
<%@  include file="bootstraphead.jsp"%>
<style>
body {
	background-image: linear-gradient(rgba(255, 255, 255, 0.75),
		rgba(255, 255, 255, 0.75)), url("images/SmoochyZoo.jpg");
}
</style>
</head>
<body>
<jsp:include page="nav.jsp" />
<h1>Member Home - Smoochy Zoo</h1>
    <p>You're logged in as a member. Here are your available options:</p>
    <div>
        <h2>You're login in as a member!</h2>
        <jsp:include page="animalhome.jsp" />
    </div>

    <!-- Logout Button -->
    <form action="logout.do" method="post">
        <button type="submit">Logout</button>
    </form>
    <%@  include file="bootstrapfooter.jsp"%>

</body>
</html>