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
		  	 <div id="outer">
				<div class="inner">
				<form action="deleteHookOrNeedle.do">
					<input type="hidden" id="id" name="id" value="${needleOrHook.id}" />
					<input type="submit" value="Delete the Needle, Hook or Cable"/>
				</form>
				</div>
				<br>
				<div class="inner">
					<form action="updateNeedleOrHookGetInfo.do">
						<input type="hidden" id="id" name="id" value="${needleOrHook.id}" />
						<input type="submit" value="Update the Needle's, Hook's or Cable's information"/><br>
					</form>
				</div>
				<br>
	 		</div>
		</div>
	</div>
</div>
</body>
</html>