<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="jakarta.tags.core" prefix="c" %>    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Smoochy Zoo's Animals</title>
<%@  include file="bootstraphead.jsp" %>
</head>
<body>
<div class="container">
	<div class="row">
		<a href="index.do"> Home</a>
		<br>
		<br>
	</div>
	<div class="row">
		<c:choose>
			<c:when test="${! empty animalList }">
				<table class="table-bordered">
					<tr>
						<th>Species</th>
						<th>Name</th>
						<th>Birthday</th>
						<th>Gender</th>
						<th>Mom</th>
						<th>Dad</th>
					</tr>
					<c:forEach items="${animalList}" var="animal">
						 <tr>
						 	<td>${animal.species.name }</td>
						 	<td>${animal.name }</td>
						 	<c:choose>
						 		<c:when test="${animal.birthday == null }">
						 			<td>No Information about the Animal's Birthday</td>
						 		</c:when>
						 		<c:otherwise>
						 			<td>${animal.birthday }</td>
						 		</c:otherwise>
						 	</c:choose>
						 	<td>${animal.gender }</td>
						 	<c:choose>
						 		<c:when test="${animal.mom == null }">
						 			<td>No Information about the Animal's Mom</td>
						 		</c:when>
						 		<c:otherwise>
						 			<td>${animal.mom.name }</td>
						 		</c:otherwise>
						 	</c:choose>
						 	<c:choose>
						 		<c:when test="${animal.dad == null }">
						 			<td>No Information about the Animal's Dad</td>
						 		</c:when>
						 		<c:otherwise>
						 			<td>${animal.dad.name }</td>
						 		</c:otherwise>
						 	</c:choose>
						</tr>
					</c:forEach>
				</table>
		 	</c:when>
		 	<c:otherwise>
		 			<h3>No animals were found!</h3>
		 	</c:otherwise>
		 </c:choose>
	</div>
</div>
</body>
</html>