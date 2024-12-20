<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Staff Home - Smoochy Zoo</title>
<%@  include file="bootstraphead.jsp" %>
 <style>
 body { 
	background-image: linear-gradient(rgba(255, 255, 255, 0.75), rgba(255, 255, 255, 0.75)),
                  url("images/SmoochyZoo.jpg");
}
</style>
</head>
<body>
<jsp:include page="nav.jsp" />

<!-- starting code to get a base for these pages -->
<h1>Welcome, Staff Member!</h1>
    
    <p>You're logged in as a staff member. Here are your available options:</p>
    
    <!-- Staff-specific content -->
    <div>
        <h2>Animal Care Information</h2>
        <!-- Provide options for staff to manage animals, schedules, etc. -->
    </div>

    <!-- Logout Button -->
    <form action="logout.do" method="post">
        <button type="submit">Logout</button>
    </form>
    <%@  include file="bootstrapfooter.jsp" %>
</body>
</html>