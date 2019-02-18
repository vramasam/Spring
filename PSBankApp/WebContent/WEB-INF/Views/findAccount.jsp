<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- library to support spring tags starts -->  
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
   <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
   <!-- library to support spring tags ends -->  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PS Bank Search Account Holder</title>
</head>
<body>

<div class="container">
	<%@ include file="header.jsp" %>
	<div class="row">
	  <div class="col-12">
	  		<p class="h1">Search Form</p>
	  </div>
	</div>
	
	<div class="row">
		<div class="col-8">
		  <form:form cssClass="form-horizantal" role="form" id="accForm">
		   <div class="form-group row">
		     <Label for="accountNumber" class="col-2 col-form-label">Account No:</Label>
		     
		     <div class="col-8">
		     	<input type="text" class="form-control" placeholder="Enter account number" 
		     	name="accountNumber" id="accountNumber"/>
		     </div>
		     
		     <div class="col-2">
		     	<button type="submit" id="btn-search" class="btn btn-primary">Search</button>
		     </div>
		    </div>
		  </form:form>
		</div>
	</div>
	
	<div class="row" id="divResults">
	  <div class="col-8">
	    <div class="card">
	      
	      <div class="card-header bg-success text-white">
	      	<h3> Search Results </h3>
	      	<div class="card-body">
	      		<div id="accountNumber"></div>
	      		<div id="accountHolderName"></div>
	      		<div id="balance"></div>
	      		<div id="accountType"></div>
	      		<div id="psCode"></div>
	      	</div>
	      </div>
	  </div>
	 </div>
	</div>
	
	<div class="row" id="divError">
	  <div class="col-8">
	     <p class="alert alert-danger">Requested Account Holder Details Not Found</p>
	  </div>
	</div>
	
	<%@ include file="footer.jsp" %>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>

  $(document).ready(function($) {
	 $('#divResults').hide();
     $('#divError').hide();	
     
     $("#accForm").submit(function(event){
    	 enableSearchButton(false);
    	 event.preventDefault();
    	 searchViaAjax();
     }) 
  });
  
  function enableSearchButton(flag) {
	  $('#btn-search').prop("disabled", flag);
  }
  
  function searchViaAjax() {
	  var accnt = {}
	  accnt["accountNumber"] = $("#accountNumber").val();
	  $.ajax({
		  type : "POST",
		  contentType : "application/json",
		  url : "http://localhost:8080/PSBankApp/account",
		  data : JSON.stringify(accnt),
		  dataType : 'json',
		  timeout : 100000,
		  success : function(data) {
			  display(data);  
		  },
		  error : function(e) {
			  $('#divResults').hide();
			  $('#divError').show();
		  },
		  done : function(e) {
			  enableSearchButton(true);
		  }
	  });
  }
  
  function display(data) {
	  $('#accountNumber').html("Account Number :" + data["accountNumber"]);
	  $('#accountHolderName').html("Account Number :" + data["accountName"]);
	  $('#balance').html("Account Number :" + data["balance"]);
	  $('#accountType').html("Account Number :" + data["accountType"]);
	  $('#psCode').html("Account Number :" + data["psCode"]);
	  $('#divError').hide();
	  $('#divResults').show();
  }

</script>

</body>
</html>