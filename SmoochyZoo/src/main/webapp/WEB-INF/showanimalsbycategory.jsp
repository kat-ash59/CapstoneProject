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
				<h3>Animals who are ${animalList.getFirst().getCategory() }</h3>
				<table class="table-bordered">
						<tr>
						<th>Name</th>
						<th>Birthday</th>
						<th>Gender</th>
						<th>Mom</th>
						<th>Dad</th>
					</tr>
					<c:forEach items="${animalList}" var="animal">
						 <tr>
						 	<td><a href = "getAnimal.do?animalId=${animal.id}">  ${film.name }</a></td>
						 	<td>${animal.birthday }</td>
						 	<td>${animal.gender }</td>
						 	<td>${animal.mom }</td>
						 	<td>${animal.dad }</td>
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