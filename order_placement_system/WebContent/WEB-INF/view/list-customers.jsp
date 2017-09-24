<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
	<title>The moving agency</title>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>The moving agency - Order placemenet system</h2>

		</div>
	</div>

	
	<div id="container">
		<div id="content">
		
		<input type="button" value="Add Customer"
							onclick="window.location.href='showFormForAdd'; return false;"
							class="add-button"/>
	
		<form action="findCustomers" method="GET">
			<table>
				<tr>
					<td><label></label>
					<td><input type="text" name="searchQuery"></td>
					<td><input type="submit" name="action" value="Search"  /></td>
				</tr>
			</table>
		
		</form>
			
		<table>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Service</th>
				<th>Action</th>
			</tr>
			
			<c:forEach var="customer" items="${customers}">
				
				<c:url var="updateLink" value="/customer/showFormForUpdate">
					<c:param name="customerId" value="${customer.id}" />
				</c:url>
				
				<tr>
					<td> ${customer.id} </td>
 					<td> ${customer.name} </td>
 					<td> ${customer.services} </td>
					<td> <a href="${updateLink}">Open</a> </td>  					
				</tr>
				
			</c:forEach>
		</table>
		
		</div>
	</div>
		
</body>
</html>