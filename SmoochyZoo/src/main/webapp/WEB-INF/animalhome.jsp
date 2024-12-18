<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>The Smoochy Zoo</title>
</head>
<body>
	<h1>Welcome To Smoochy Zoo!</h1>

	<strong>Get a list of all the animals in the Zoo</strong>
		<br>
		<br>
		<form action="getAllAnimals.do" method="GET">
	  		<input type="submit" value="Show a list of all the Animals in the Zoo" />
		</form>
		<br>
		<br>
		<br>
		<strong>Find the Animal by it's id</strong>
		<br>
		<br>
			<form action="getAnimalById.do" method="GET">
	 		 Needle ID: <input type="number" name="needleOrHook" />
	  		<input type="submit" value="Show Needle, Hook or Cable" />
		</form>

</body>
</html>