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

	<strong>Get a list of all the animals in the Zoo</strong>
		<br>
		<br>
		<form action="getAllAnimals.do" method="GET">
	  		<input type="submit" value="Show a list of all the Animals in the Zoo" />
		</form>
		<br>
		<br>
		<strong>Find the Animal by it's id</strong>
		<br>
			<form action="getAnimalById.do" method="GET">
	 		 Animal ID: <input type="number" name="animalId" />
	  		<input type="submit" value="Show Animal" />
		</form>
		<br>
		<br>
		<strong>Find the Animals by the name provided</strong>
		<br>
		<form action="getAllAnimalsByName.do" method="GET">
	 		 Animal Name: <input type="text" name="name" />
	  		<input type="submit" value="Show Animals with the name provided" />
		</form>
		<br>
		<br>
		<strong>Find the Animals by their species</strong>
		<br>
		<form action="getAllAnimalsBySpecies.do" method="GET">
			<select name="speciesId">
				<c:forEach items="${speciesList}" var="species">
				    <option value="${species.id}">${species.name }</option>
				 </c:forEach>
			</select>
	  		<input type="submit" value="Show Animals with the species provided" />
		</form>
		<br>
		<br>
		<strong>Find the Animals by their category</strong>
		<br>
		<br>
			<form action="getAllAnimalsByCategory.do" method="GET">
	 		<select name="categoryId">
				<c:forEach items="${categoryList}" var="category">
				    <option value="${category.id}">${category.name }</option>
				</c:forEach>
			</select>
	  		<input type="submit" value="Show Animals with the category provided" />
		</form>
		<br>
		<br>
</body>
</html>