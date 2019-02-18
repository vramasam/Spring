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
</head>
<body>

<h2>PS : Bank Account Details</h2>

<!-- Getting the data from request param -->
<!--  <p><spring:message code="lb1.accountNo"/> : ${param.accountNumber} </p>
<p><spring:message code="lb1.accountHolderName"/> : ${param.accountName} </p>
<p>${param.balance} </p>-->

<!-- Getting the data from model attribute -->
<%-- <p>Account # : ${accountNo} </p>
<p>Account Holder Name : ${accountName} </p>
<p><spring:message code="lb1.balance"/>: ${balance} </p> --%>

<!-- Getting the data from account object -->
<%-- <p><spring:message code="lb1.accountNo"/> : ${account.accountNumber} </p>
<p><spring:message code="lb1.accountHolderName"/> : ${account.accountName} </p>
<p><spring:message code="lb1.balance"/>: ${account.balance}
<p><spring:message code="lb1.balance"/>: ${account.accountType}
<p><spring:message code="lb1.balance"/>: ${account.dateOfBirth}
<p><spring:message code="lb1.balance"/>: ${account.psCode} --%>

<!-- Getting the data from ModelAttribute -->
<p><spring:message code="lb1.accountNo"/> : ${account_data.accountNumber} </p>
<p><spring:message code="lb1.accountHolderName"/> : ${account_data.accountName} </p>
<p><spring:message code="lb1.balance"/>: ${account_data.balance}
<p><spring:message code="lb1.balance"/>: ${account_data.accountType}
<p><spring:message code="lb1.balance"/>: ${account_data.dateOfBirth}
<p><spring:message code="lb1.balance"/>: ${account_data.psCode}

</body>
</html>