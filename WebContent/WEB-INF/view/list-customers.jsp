<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer List</title>

<link type=text/css
      rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/style.css"/>
     
</head>
<body>

	<div id="wrapper">
		<div id="header">
		
		<h2>CRM - Customer Relationship Management</h2>
		</div>
		<div id="container">
		   <div id="content">
		   
		   <!--  Add Customer button -->
		<input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;"
		class="add-button">
		   
		   	<!-- add table here -->
		   	<table>
		   	<tr>
		   	<th>First Name</th>
		   	<th>Last Name</th>
		   	<th>Email</th>
		   	<th>Action</th>
		   	</tr>
		   	<!--  loop over and print customer list -->
		   	
		   <c:forEach var="tempCustomer" items="${customers}">
		   
		   <!--  construct an update link with customer id -->
		   <c:url var="updateLink" value="/customer/showFormForUpdate">
		     <c:param name="customerId" value="${tempCustomer.id }"/>
		     </c:url>
		     
		    <!--  construct an delete link with customer id -->
		   <c:url var="deleteLink" value="/customer/deleteCustomer">
		     <c:param name="customerId" value="${tempCustomer.id }"/>
		     </c:url>
		   <tr>
		   <td> ${tempCustomer.firstName}</td>
		    <td> ${tempCustomer.lastName}</td>
		     <td> ${tempCustomer.email}</td>
		     <td>
		        <!-- Display update link -->
		        <a href="${updateLink}">Update</a>
		        |
		         <!-- Display delete link -->
		        <a href="${deleteLink}"
		            onclick="if (!(confirm('Are you sure want to delete this customer?'))) return false">Delete</a>
		     </td>

		   </tr>
		   	</c:forEach>
		   	 
		   	</table>
		   </div>
		</div>
	</div>

</body>
</html>