<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@  include file="bootstraphead.jsp" %>
<style>
 .navbar-custom {
    background-color: #6C757D; /* A soft grayish-brown (charcoal) color */
  }
  .navbar-custom .navbar-brand, .navbar-custom .nav-link {
    color: #fff; /* White text for contrast */
  }
  .navbar-custom .nav-link:hover {
    color: #A1C6B0; /* Soft greenish hue for hover effect */
  }
</style>
</head>
<body>
	 <nav class="navbar navbar-expand-lg navbar-custom">
    <a class="navbar-brand" href="index.do">Smoochy Zoo</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">

        <!-- Check if user is logged in -->
        <c:if test="${not empty loggedInUser}">
          <li class="nav-item">
            <a class="nav-link" href="logout.do">Logout</a>
          </li>
        </c:if>

        <!-- If user is not logged in -->
        <c:if test="${empty loggedInUser}">
          <!-- Staff and Member Login Links -->
          <li class="nav-item">
            <a class="nav-link" href="login.do?role=staff">Staff Login</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="login.do?role=member">Member Login</a>
          </li>
        </c:if>

      </ul>
    </div>
  </nav>


	<%@  include file="bootstrapfooter.jsp" %>
</body>
</html>