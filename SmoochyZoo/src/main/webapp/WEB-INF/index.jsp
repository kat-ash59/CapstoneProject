<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome To Smoochy Zoo</title>
</head>
<body>

<!-- starting code to get a base for these pages -->
<h1>Welcome to Smoochy Zoo</h1>
    
    <!-- Login form for staff and members -->
    <div>
        <h2>Login</h2>

        <!-- Display error message if login fails -->
        <c:if test="${not empty errorMessage}">
            <div style="color: red; font-weight: bold;">
                ${errorMessage}
            </div>
        </c:if>
        
        <!-- Staff Login -->
        <h3>Staff Login</h3>
        <form action="login.do" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            <input type="hidden" name="role" value="staff">
            <button type="submit">Login as Staff</button>
        </form>

        <!-- Member Login -->
        <h3>Member Login</h3>
        <form action="login.do" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            <input type="hidden" name="role" value="member">
            <button type="submit">Login as Member</button>
        </form>
    </div>

    <div>
        <h2>All Animals</h2>
        <table>
            <thead>
                <tr>
                    <th>Species</th>
                    <th>Category</th>
                    <th>Name</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="animal" items="${animals}">
                    <tr>
                        <td>${animal.species}</td>
                        <td>${animal.category}</td>
                        <td>${animal.name}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <div>
        <a href="zooInfo.do">Click here for Zoo Information</a>
    </div>
</body>
</html>
</body>
</html>