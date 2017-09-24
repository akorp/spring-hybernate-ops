<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<title>The moving agency</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
		  
	<script type="text/javascript">
		function validateForm() {
			var x = document.forms["customer_form"]["name"].value;
			if (x == "") {
		        alert("Name must be filled out");
		        return false;
			}			
		}
	</script>
		  
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Moving agency - Order placement system</h2>
		</div>
	</div>

	<div id="container" >
		<h3> Create/Edit a customer</h3>
	

		<form:form name="customer_form" action="actionSaveDelete" modelAttribute="customer" method="POST">
		
			<form:hidden path="id" />
		
			<table>
				<tbody>
							
					<tr>
						<td><label>Name (*):</label></td>
						<td><form:input path="name" class="wid"/></td>
					</tr>
					
					<tr>
						<td><label>Service: </label> </td>
						<td style="float:center;" class="checkbox"><form:checkboxes items="${all_services}" path="services" /></td>			
					</tr>					
					
					<tr>
						<td><label>Phone:</label></td>
						<td ><form:input path="phone" class="wid"/></td>
					</tr>
					<tr>
						<td><label>e-mail:</label></td>
						<td><form:input path="email" class="wid"/></td>
					</tr>
					<tr>
						<td><label>Address (moving from):</label></td>
						<td><form:input path="addr_from" class="wid"/></td>
					</tr>
					<tr>
						<td><label>Address (moving to):</label></td>
						<td><form:input path="addr_to" class="wid"/></td>
					</tr>
					<tr>
						<td><label>Note:</label></td>
						<td><form:textarea path="note" rows="5" class="wid"/></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="submit" name="action" value="Save" class="save" 
									onclick="return validateForm()"/>
		
							<input type="submit" name="action" value="Delete " class="save" 
									onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false"/>
									
						</td>
					</tr>																

				</tbody>
			</table>
		
			
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
		</p>
	
	</div>

	

</body>

</html>