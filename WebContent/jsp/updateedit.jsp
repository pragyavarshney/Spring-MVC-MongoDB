<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="header.html"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Info Page</title>
</head>
<body>
	<div align="center">
		<h1>User Details</h1>
		<form:form method="post" modelAttribute="user" action="/MongoTest/updateUser.do">
			<table>
			<tr>
			<td class="in">Id:</td>
			<td class="in">${user.id}</td>
		</tr>	
				<tr>
					<td class="in">First Name:</td>
					<td class="in"><form:input path="firstName" /></td>
			
			
					
				</tr>
				<tr>
					<td class="in">Middle Name:</td>
					<td class="in"><form:input path="middleName" /></td>
					
				</tr>

				<tr>
					<td class="in">Last Name:</td>
					<td class="in"><form:input path="lastName" /></td>
					
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="Update Changes" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>
