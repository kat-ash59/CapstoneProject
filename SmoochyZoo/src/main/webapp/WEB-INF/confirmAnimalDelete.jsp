<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Smoochy Zoo's Animal Information</title>
<%@  include file="bootstraphead.jsp" %>
<style>
body { 
	background-image: linear-gradient(rgba(255, 255, 255, 0.75), rgba(255, 255, 255, 0.75)),
                  url("images/confetti.jpg");
}
</style>
</head>
<body>
	<div class="container">
	<h1>Animal Information</h1>
	<div class="row">
	<c:choose>
		<c:when test="${isSuccess }">
			Successfully deleted the Animal!
		</c:when>
		<c:otherwise>
			Unable to delete the Animal!
		</c:otherwise>
	</c:choose>
	<form>
			<jsp:include page="animalhome.jsp"/>
			<input type="submit" value="Back to Animal Information"/>
	</form>
	</div>
	</div>
	
</body>
<head>
<%@  include file="bootstrapfooter.jsp" %>
</body>
</html>