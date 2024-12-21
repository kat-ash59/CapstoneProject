<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<%@ include file="bootstraphead.jsp"%>
<style>
body { 
	background-image: linear-gradient(rgba(255, 255, 255, 0.75), rgba(255, 255, 255, 0.75)),
                  url("images/SmoochyZoo.jpg");
}
</style>
</head>
<body>
<jsp:include page="nav.jsp" />
	<section class="vh-100">
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col col-xl-10">
					<div class="card" style="border-radius: 1rem;">
						<div class="row g-0">
							

							<!-- Login Form Section -->
							
								<div class="card-body p-4 p-lg-5 text-black">

									<form action="login.do" method="POST">

										<!-- Logo and Header Section -->
										<div class="d-flex align-items-center mb-3 pb-1">
											<i class="fas fa-cubes fa-2x me-3" style="color: #ff6219;"></i>
											<span class="h1 fw-bold mb-0">Smoochy Zoo</span>
										</div>

										<h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Sign
											into your account</h5>

										<!-- Username Field -->
										<div data-mdb-input-init class="form-outline mb-4">
											<input type="text" id="form2Example17" name="username"
												class="form-control form-control-lg" required /> <label
												class="form-label" for="form2Example17">Username</label>
										</div>

										<!-- Password Field -->
										<div data-mdb-input-init class="form-outline mb-4">
											<input type="password" id="form2Example27" name="password"
												class="form-control form-control-lg" required /> <label
												class="form-label" for="form2Example27">Password</label>
										</div>

										<!-- Role Hidden Field -->
										<c:choose>
											<c:when test="${param.role == 'staff'}">
												<input type="hidden" name="role" value="staff">
												<button type="submit" class="btn btn-dark btn-lg btn-block">Staff
													Login</button>
											</c:when>
											<c:when test="${param.role == 'member'}">
												<input type="hidden" name="role" value="member">
												<button type="submit" class="btn btn-dark btn-lg btn-block">Member
													Login</button>
											</c:when>
											<c:otherwise>
												<p class="text-danger">Invalid role</p>
											</c:otherwise>
										</c:choose>


									</form>

								</div>
	
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>


	<%@ include file="bootstrapfooter.jsp"%>

</body>
</html>