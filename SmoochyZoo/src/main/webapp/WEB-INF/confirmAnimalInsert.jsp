<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kat's Knitting Stuff</title>
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
	<h1>Needle, Hook, or Cable Information</h1>
	<div class="row">
	<c:choose>
		
		<c:when test="${! empty needleOrHook }">
			<h5>You have successfully inserted your Needle's information in the Database</h5><br>
			The Needle, Hook or Cable Id is: ${needleOrHook.id}<br>
			The Material is: ${needleOrHook.material}<br>
			The Type is: ${needleOrHook.type}<br>
			The Length is: ${needleOrHook.length}<br>
			The Us Size is: ${needleOrHook.usSize}<br>
			The Metric Size is: ${needleOrHook.metricSize}<br>
			The Quantity is: ${needleOrHook.quantity}<br>
		</c:when>
		<c:otherwise>
			Unable to add the new Needle, Hook or Cable into the database!
		</c:otherwise>
	</c:choose>
	<br>
	<br>
	<form action="index.do">
		<input type="submit" value="Home"/><br>
	</form>
	</div>
	</div>
</body>	
<head>

	
<%@  include file="bootstrapfooter.jsp" %>
</body>
</html>