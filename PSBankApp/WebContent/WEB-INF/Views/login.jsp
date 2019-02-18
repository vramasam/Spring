<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PS Bank: Login Form</title>
</head>
<body>
 <div class="container">
 	<%@ include file="header.jsp" %>
 	
 	<div class="col-6 offset-3 align-self-center">
 		<div class="card">
 			<div class="card-header bg-info text-white">
 				Existing Users can login here
 			</div>
 			
 			<div class="card-body">
 				<form role="form" method="post" action="<c:url value='/login'/>">
 					<div class="form-group">
 						<label for="Username"></label>
 						<input type="text" class="form-control placeholder="" name="username"/>
 					</div>
 					
 					<div class="form-group">
 						<label for="Password"></label>
 						<input type="password" class="form-control placeholder="Password" name="password"/>
 					</div>
 					
 					<!-- To avoid cross side scripting attack, this will generate a unique id for every request -->
 					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
 					<input type="submit" value="Login" name="submit" class="btn btn-primary"/>
 				</form>
 				
 				<div class="row">
 				   <div class="col-12">
 				      <c:if test="${not empty error}">
 				      		<p class="alert-danger">${error}</p>
 				      </c:if>
 				      
 				      <c:if test="${not empty msg}">
 				      		<p class="alert-warning">${msg}</p>
 				      </c:if>
 				   </div>
 				</div>
 			</div>
 		</div>
 	</div>
 		 
 	<%@ include file="footer.jsp" %>
 </div>
</body>
</html>