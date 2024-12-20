<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@  include file="bootstraphead.jsp" %>
</head>
<body>
	<nav>
		<a href="index.do">Home</a>
		<c:if test="${not empty loggedInUser}">
			<a href="account.do">Account</a>
			<a href="logout.do">Logout</a>
		</c:if>

		<c:if test="${empty loggedInUser}">
			<a href="login.do?role=staff">Staff Login</a>
			<a href="login.do?role=member">Member Login</a>
		</c:if>

	</nav>
	
	<%@  include file="bootstrapfooter.jsp" %>
</body>
</html>