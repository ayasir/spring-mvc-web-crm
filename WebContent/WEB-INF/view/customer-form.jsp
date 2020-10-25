<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Add Form</title>
<link type="text/css"
      rel="stylesheet"
      href="${pageContext.request.contextPath }/resources/css/style.css">
      
<link type="text/css"
      rel="stylesheet"
      href="${pageContext.request.contextPath }/resources/css/add-customer-style.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
		   CRM - Customer Relationship Management
		</div>
		
		<div id="container">
		<h3> Add Customer</h3>
		
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
		
		<!-- need to associate this data with the customer id -->
		<form:hidden path="id"/>
		
			<table>
			  <tbody>
					<tr>
					
						<td><label>First Name:</label></td>
						<td><form:input path="firstName"/></td>
					</tr>	
					<tr>
					
						<td><label>Last Name:</label></td>
						<td><form:input path="lastName"/></td>
					</tr>	
					<tr>
					
						<td><label>Email:</label></td>
						<td><form:input path="email"/></td>
					</tr>
					<tr>
					
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"></td>
					</tr>	
							  
			  </tbody>
			</table>
		</form:form>
		
		<div style="clear; both;"></div>
		<p>
		<a href="${pageContext.request.contextPath }/customer/list">Back to List</a>
		</p>
		</div>
	</div>
</body>
</html>