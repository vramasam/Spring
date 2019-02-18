<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- library to support spring tags starts --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!-- library to support spring tags ends --> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PS Bank account Details</title>
</head>
<body>
<div class="container">

<%@ include file="header.jsp" %>

        <!-- From Spring 4 version, logout and logoutUrl must be same name -->
        <div class="row">
           <div class="col-12">
           		<c:url value="/logout" var="logoutUrl"/>
           		
           		<form action="${logoutUrl}" method="post" id="logoutForm">
           			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
           		</form>
           		
           		<script>
           			function formSubmit() {
           				document.getElementById("logoutForm").submit();
           			}
           		</script>
           		
           		<p class="dispaly-5">
           		   Welcome : ${username}, <a href="javascript:formSubmit()">Logout</a>
           		</p>
           </div>
        </div>

		<div class="row">
			<div class="col-12">
				<a href="<c:url value='/new'/>" class="btn btn-lg btn-primary">Add new Account</a>
			</div>
		</div>	

		<div class="row">
			<div class="col-12">
 
				 <table class="table table-bordered table-hover">
				    <thead class="bg-success">
				    	<tr>
				    	  <th><spring:message code="lb1.accountNo"/></th>
				    	  <th><spring:message code="lb1.accountHolderName"/></th>
				    	  <th><spring:message code="lb1.balance"/></th>
				    	  <th> &nbsp; </th>
				    	</tr>
				    </thead>
				    <tbody>
				    	<c:forEach var="account" items="${accounts}">
				    	    <c:url var="updateLink" value="/edit">
				    	       <c:param name="accountNumber" value="${account.accountNumber}"></c:param>
				    	    </c:url>
				    	    
				    	    <c:url var="deleteLink" value="/delete">
				    	       <c:param name="accountNumber" value="${account.accountNumber}"></c:param>
				    	    </c:url>
				    		<tr>
				    			<td>${account.accountNumber}</td>
				    			<td>${account.accountName}</td>
				    			<td>${account.balance}</td>
				    			<td><a href="${updateLink}" class="btn btn-warning">Edit</a></td>
				    			<td><a href="${deleteLink}" class="btn btn-danger" onClick="if(!(confirm('Are you sure to delete'))) return false">Delete</a></td>
				    		</tr>
				    	</c:forEach>
				    </tbody>
				    
				</table>
 
 			</div>
		</div>


<%@ include file="footer.jsp" %>

</div>

</body>
</html>