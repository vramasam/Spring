<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- library to support spring tags starts -->  
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
   <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
   <!-- library to support spring tags ends -->  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="lb1.title"/></title>
<style>
	.error{
		color:red
	}
</style>
</head>
<body>

<!-- Spring Form tag -->
<!-- <h2>Please fill up the form Details</h2>
<form:form action="saveAccount" modelAttribute="account_data">
<table>
   <tr>
      <td><spring:message code="lb1.accountNo"/></td>
   	  <td><form:input path="accountNumber" size="30"/></td>
   	  <td><form:errors path="accountNumber" cssClass="error"/>
   	  <b><font color="red">${message}</font></b></td>
   	  
   </tr>
   
   <tr>
      <td><spring:message code="lb1.accountHolderName"/></td>
   	  <td><form:input path="accountName" size="30"/></td>
   	  <td><form:errors path="accountName" cssClass="error"/></td>
   </tr>
   
   <tr>
      <td><spring:message code="lb1.balance"/></td>
   	  <td><form:input path="balance" size="30"/></td>
   	  <td><form:errors path="balance" cssClass="error"/><td>
   </tr>
   
   <tr>
      <td><spring:message code="lb1.accountType"/>: </td>
   	  <td><form:select path="accountType">
   	  <form:option value="">Select Account Type</form:option>
   	     <form:option value="SAVINGS">Savings</form:option>
   	     <form:option value="CURRENT">Current</form:option>
   	   </form:select>
   	  </td>
   	  <td><form:errors path="accountType" cssClass="error"/></td>
   </tr>
   
   <tr>
      <td><spring:message code="lb1.dob"/></td>
   	  <td><form:input path="dateOfBirth" size="30"/></td>
   	   <td><form:errors path="dateOfBirth" cssClass="error"/></td>
   </tr>
   
   <tr>
      <td><spring:message code="lb1.pscode"/></td>
   	  <td><form:input path="psCode" size="30"/></td>
   	  <td><form:errors path="psCode" cssClass="error"/></td>
   </tr>
   
    <tr>
      <td colspan="2" align="center">
   	  <input type="submit" value="Save Account" name="btnSubmit"/>
   </tr>
</table>
</form:form>-->

<!-- Spring Form tag with bootstrap-->
<div class="container">
<%@ include file="header.jsp" %>

   <div class="row">
      <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-xs-12">
      		<h2 class="page-header">Please fill the form details</h2>
      </div>
   </div>
   
   <div class="row">
   		<div class="col-6">
   			<form:form action="saveAccount" modelAttribute="account_data" cssClass="form-horizontal" role="form">
   				<div class="form-group row">
   				  <Label for="accountNumber" class="col-6 col-form-label"><spring:message code="lb1.accountNo"/></Label>
   				  <div class="col-6">
   				  		<form:input path="accountNumber" cssClass="form-control"/>
   				  		<form:errors path="accountNumber" cssClass="alert-danger"/>
   				  		<text class="alert-danger">${message}</text>
   				  </div>	
   				</div>
   				
   				
   				<div class="form-group row">
   				  <Label for="accountName" class="col-6 col-form-label"><spring:message code="lb1.accountHolderName"/></Label>
   				  <div class="col-6">
   				  		<form:input path="accountName" cssClass="form-control"/>
   				  		<form:errors path="accountName" cssClass="alert-danger"/>
   				  </div>	
   				</div>
   				
   				<div class="form-group row">
   				  <Label for="balance" class="col-6 col-form-label"><spring:message code="lb1.balance"/></Label>
   				  <div class="col-6">
   				  		<form:input path="balance" cssClass="form-control"/>
   				  		<form:errors path="balance" cssClass="alert-danger"/>
   				  </div>	
   				</div>
   				
   				<div class="form-group row">
   				  <Label for="accountType" class="col-6 col-form-label"><spring:message code="lb1.accountType"/>:</Label>
   				  <div class="col-6">
   				  		<form:select path="accountType" cssClass="form-control">
   	  							<form:option value="">Select Account Type</form:option>
   	     						<form:option value="SAVINGS">Savings</form:option>
   	     						<form:option value="CURRENT">Current</form:option>
   	   					</form:select>
   	   					<form:errors path="balance" cssClass="alert-danger"/>
   				  </div>	
   				</div>
   				
   				<div class="form-group row">
   				  <Label for="dateOfBirth" class="col-6 col-form-label"><spring:message code="lb1.dob"/></Label>
   				  <div class="col-6">
   				  		<form:input path="dateOfBirth" cssClass="form-control"/>
   				  		<form:errors path="dateOfBirth" cssClass="alert-danger"/>
   				  </div>	
   				</div>
   				
   				<div class="form-group row">
   				  <Label for="psCode" class="col-6 col-form-label"><spring:message code="lb1.pscode"/></Label>
   				  <div class="col-6">
   				  		<form:input path="psCode" cssClass="form-control"/>
   				  		<form:errors path="psCode" cssClass="alert-danger"/>
   				  </div>	
   				</div>
   				
   				<div class="form-group row">
   					<div class="offset-6 col-6">
   					  <input type="submit" value="Save Account" name="btnSubmit" class="btn btn-primary"/>
   					</div>
   				</div>
   			
   			</form:form>
   		</div>
   </div>


<%@ include file="footer.jsp" %>

</div>

</body>
</html>