<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Smoochy Zoo</title>
<style>
body { 
	background-image: linear-gradient(rgba(255, 255, 255, 0.75), rgba(255, 255, 255, 0.75)),
                  url("images/SmoochyZoo.jpg");
}
</style>
</head>
<body>
	<h2>Welcome to the Smoochy Zoo</h2>

	<p>
	We are a small zoo that has a huge heart and is known for our Animals who love to Smooch!
	Please feel free to explore our zoo and meet out animals.
	<br>
	Our Zoo is a place where a number of wildlife species are housed in separate enclosures. 
	Habitats similar to the natural habitats of the animals are re-created for them to live in. 
	The animals are fed and are given water to drink by our wonderful staff. 
	They are kept in hygienic surroundings. 
	An animal that falls ill or develops a disease is given medical attention by our trained 
	veterinarians and nursed back to health.
	<br>
	Mammals, birds and reptiles as also aquatic animals are kept in zoos. 
	Our visitors are allowed to visit zoos and take a look at the animals. 
	Children love to visit our Smoochy Zoo.
	</p>
	
	<jsp:include page="animalhome.jsp" />


</body>
</html>