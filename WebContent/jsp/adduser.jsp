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
		<form:form method="post" modelAttribute="user" action="/MongoTest/processAddUser.do">
			<table>
			
				<tr>
					<td>First Name:</td>
					<td><form:input path="firstName" /></td>
					
				</tr>
				<tr>
					<td>Middle Name:</td>
					<td><form:input path="middleName"  /></td>
				</tr>

				<tr>
					<td>Last Name:</td>
					<td><form:input path="lastName" /></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="Save Changes" /></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>
