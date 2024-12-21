<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Zoo Animal Database</title>
    <%@ include file="bootstraphead.jsp"%> <!-- Including Bootstrap -->
    <style>
        /* Custom Styles for Sidebar, Table, Buttons */
        /* (Your styles from the previous code go here) */
    </style>
</head>
<body>
    <!-- Sidebar Navigation -->
    <div class="sidebar">
        <a href="staffManagement.jsp">Staff Management</a>
        <a href="animalManagement.jsp">Animal Management</a>
    </div>

    <!-- Content Area -->
    <div class="content">
        <div class="section-header">
            Zoo Animal Database Overview
        </div>
        <div class="section-body mt-4">
            <!-- Staff Management Section -->
            <h2>Staff Information</h2>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Sample Staff Row -->
                        <tr>
                            <td>1</td>
                            <td>John Doe</td>
                            <td>johndoe@example.com</td>
                            <td>
                                <a href="updateStaff.jsp?staff_id=1" class="btn btn-warning">Update</a>
                                <a href="deleteStaff.jsp?staff_id=1" class="btn btn-danger">Delete</a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>

            <div class="mt-5">
                <a href="addStaff.jsp" class="btn btn-primary">Add New Staff</a>
            </div>

            <!-- Animal Management Section -->
            <h2>Animal Information</h2>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Species</th>
                            <th>Category</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <!-- Sample Animal Row -->
                        <tr>
                            <td>1</td>
                            <td>Lion</td>
                            <td>Mammal</td>
                            <td>Carnivore</td>
                            <td>
                                <a href="updateAnimal.jsp?animal_id=1" class="btn btn-warning">Update</a>
                                <a href="deleteAnimal.jsp?animal_id=1" class="btn btn-danger">Delete</a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>

            <div class="mt-5">
                <a href="addAnimal.jsp" class="btn btn-primary">Add New Animal</a>
            </div>
        </div>
    </div>

    <!-- Footer Section -->
    <div class="footer">
        <p>&copy; 2024 Zoo Animal Database | All Rights Reserved</p>
    </div>

    <%@ include file="bootstrapfooter.jsp"%> <!-- Including Bootstrap Footer -->
</body>
</html>
