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

<!-- Normal html tag, giving the data directly to showAccount.jsp -->
<!--<form name="accountForm" action="showAccount">
<table>
   <tr>
      <td><spring:message code="lb1.accountNo"/></td>
   	  <td><input type="text" name="accountNumber"/></td>
   </tr>
   
   <tr>
      <td><spring:message code="lb1.accountHolderName"/></td>
   	  <td><input type="text" name="accountName"/></td>
   </tr>
   
   <tr>
      <td><spring:message code="lb1.balance"/></td>
   	  <td><input type="text" name="balance"/></td>
   </tr>
   
    <tr>
      <td colspan="2" align="center">
   	  <input type="submit" value="Create Account" name="btnSubmit"/>
   </tr>
</table>
</form>-->

<!-- Normal html tag, giving the data to save account through HttpServletRequest using model and Account object -->
<!--<form name="accountForm" action="saveAccount" method="post">
<table>
   <tr>
      <td><spring:message code="lb1.accountNo"/></td>
   	  <td><input type="text" name="accountNumber"/></td>
   </tr>
   
   <tr>
      <td><spring:message code="lb1.accountHolderName"/></td>
   	  <td><input type="text" name="accountName"/></td>
   </tr>
   
   <tr>
      <td><spring:message code="lb1.balance"/></td>
   	  <td><input type="text" name="balance"/></td>
   </tr>
   
    <tr>
      <td colspan="2" align="center">
   	  <input type="submit" value="Create Account" name="btnSubmit"/>
   </tr>
</table>
</form>-->

<!-- Spring Form tag -->
<form:form action="saveAccount" modelAttribute="account_data">
<table>
   <tr>
      <td><spring:message code="lb1.accountNo"/></td>
   	  <td><form:input path="accountNumber" size="30"/></td>
   	  <td><form:errors path="accountNumber" cssClass="error"/></td>
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
   	  <input type="submit" value="Create Account" name="btnSubmit"/>
   </tr>
</table>
</form:form>


</body>
</html>