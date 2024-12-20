<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Zoo Information</title>
<%@  include file="bootstraphead.jsp"%>
<style>
body {
	background-image: linear-gradient(rgba(255, 255, 255, 0.75),
		rgba(255, 255, 255, 0.75)), url("images/SmoochyZoo.jpg");
}
</style>
</head>
<body>

	<jsp:include page="nav.jsp" />



	<div class="container mt-5">
		<h2 class="text-center">About Smoochy Zoo</h2>
		<p class="lead text-center">Smoochy Zoo is a sanctuary for a wide
			variety of animals, where each species is given a comfortable,
			secure, and environmentally appropriate space.</p>
		<div class="text-center">
			<h3>Our Wildlife</h3>
			<ul>
				<p>Endangered species from the Amazon rainforest.</p>
				<p>Birds of prey native to North America.</p>
				<p>Reptiles and amphibians from the African savanna.</p>
			</ul>

			<h3>Zoo Programs</h3>

			<p>Animal Caretaker for a Day</p>
			<p>Wildpfe Conservation Talks</p>
			<p>Zoo Tours for Schools</p>

			<h3>Come Give us a visit!</h3>
			<p>121 Main Street Denver, Colorado 80120</p>

		</div>
		<!-- Button to go back to home page -->
		<a href="index.do" class="btn btn-secondary">Back to Home</a>
	</div>
	<%@  include file="bootstrapfooter.jsp"%>
</body>
</html>