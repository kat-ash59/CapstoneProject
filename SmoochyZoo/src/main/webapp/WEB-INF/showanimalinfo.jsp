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
		<c:when test="${! empty animal }">
	 		<h5>
		  		<a href = "getAnimal.do?animalId=${animal.id}"> </a>
		  					Animal's species: ${animal.species.name}<br>
		  					Animal's name: ${animal.name }<br>
						 	<c:choose>
						 		<c:when test="${animal.birthday == null }">
						 			Birthday: No Information about the Animal's Birthday<br>
						 		</c:when>
						 		<c:otherwise>
						 			Birthday: ${animal.birthday }<br>
						 		</c:otherwise>
						 	</c:choose>
						 	Gender: ${animal.gender }<br>
						 	<c:choose>
						 		<c:when test="${animal.mom == null }">
						 			Mom: No Information about the Animal's Mom<br>
						 		</c:when>
						 		<c:otherwise>
						 			Mom: ${animal.mom.name }<br>
						 		</c:otherwise>
						 	</c:choose>
						 	<c:choose>
						 		<c:when test="${animal.dad == null }">
						 			Dad: No Information about the Animal's Dad<br>
						 		</c:when>
						 		<c:otherwise>
						 			Dad: ${animal.dad.name }<br>
						 		</c:otherwise>
						 	</c:choose>
		  		
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