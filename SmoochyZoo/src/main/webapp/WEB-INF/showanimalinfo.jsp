<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Smoochy Zoo's Animal</title>
<style>
body { 
	background-image: linear-gradient(rgba(255, 255, 255, 0.75), rgba(255, 255, 255, 0.75)),
                  url("images/MaleandFemaleLions.png");
}
</style>
</head>
<body>
<div class="container">
<div class="row">
	<a href="index.do"> Home</a>
</div>
<div class="row">
	<c:choose>
		<c:when test="${! empty animal } && ${animal.active != false }">
	 		<h5>
		  		Name: ${animal.name} <br>
		  		Birthday: (${animal.birthday}) <br> 
		  		Gender: ${animal.gender } <br>
		  		Mom: ${animal.getMom().getName()} <br>
		  		Dad: ${animal.getDad().getName()} 
		  		
		  	</h5>
	 	</c:when>
	 	<c:otherwise>
	 			<h3>Animal not found!</h3>
	 	</c:otherwise>
	 </c:choose>
</div>
</div>

</body>
</html>