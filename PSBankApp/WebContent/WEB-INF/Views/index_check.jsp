<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PS Bank</title>
</head>
<body>
<!-- <h1>Welcome to PSbank Web application</h1>
<a href="new">New</a> -->

<div class="container">
   <%@ include file="header.jsp" %>
   
   		<div class="row">
   			<div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-sm-12 col-12">
   				<div class="jumbotron">
   					<p class="lead">
   						Happiness = A Good Bank Account, A Good Coook and a good Digestion - Jean
   					</p>
   					<a href="new" class="btn btn-lg btn-success">Register Here</a>
   					<p><br /> Existing Users: <a href="user/login">Login Here</a>
   				</div>
   			</div>
   		</div>
   		
   		<div class="row">
   			<div class="colr-xl-3 col-lg-3 col-md-3 col-sm-6 col-12"> 
   				<div class="card" style="height: 200px">
   				  <div class="card-header">Online</div>
   					<img src="<spring:url value='/resources/images/laptop.png'/>"
   					  class="card-img-top" alt="Online"/>
   				  <div class="card-body">
   				  		<p class="card-text">200+ Transaction via Netbanking</p>
   				  </div>	  
   				</div>
   			</div>
   			
   			<div class="colr-xl-3 col-lg-3 col-md-3 col-sm-6 col-12"> 
   				<div class="card" style="height: 200px">
   				  <div class="card-header">Online</div>
   					<img src="<spring:url value='/resources/images/laptop.png'/>"
   					  class="card-img-top" alt="Online"/>
   				  <div class="card-body">
   				  		<p class="card-text">200+ Transaction via Netbanking</p>
   				  </div>	  
   				</div>
   			</div>
   			
   			<div class="colr-xl-3 col-lg-3 col-md-3 col-sm-6 col-12"> 
   				<div class="card" style="height: 200px">
   				  <div class="card-header">Online</div>
   					<img src="<spring:url value='/resources/images/laptop.png'/>"
   					  class="card-img-top" alt="Online"/>
   				  <div class="card-body">
   				  		<p class="card-text">200+ Transaction via Netbanking</p>
   				  </div>	  
   				</div>
   			</div>
   			
   			<div class="colr-xl-3 col-lg-3 col-md-3 col-sm-6 col-12"> 
   				<div class="card" style="height: 200px">
   				  <div class="card-header">Online</div>
   					<img src="<spring:url value='/resources/images/laptop.png'/>"
   					  class="card-img-top" alt="Online"/>
   				  <div class="card-body">
   				  		<p class="card-text">200+ Transaction via Netbanking</p>
   				  </div>	  
   				</div>
   			</div>
   		</div>
   		
   		
   
    <%@ include file="footer.jsp" %>
   </div>

</body>
</html>


