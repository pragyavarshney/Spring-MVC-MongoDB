<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="java.awt.List"%>
<%@include file="header.html"%>
<html>
<head>
<title>View All Contacts</title>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 50%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body bgcolor="#ccccff" leftmargin="10px" rightmargin="10px">
	<div align="center">
		<h3>All User details</h3>
		<form method="post" action="/MongoTest/processViewAll.do">
			<div align="center">
				<table cellpadding="3%" cellspacing="" width="80%"
					style="border: 2px solid black; margin-bottom: 5%;">
					<h4>User Detail</h4>
					<tr>
						<th>Id</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Middle Name</th>
					</tr>
					<c:forEach items='${pinfo}' var="item">
						<tr>
							<th>${item.id}</th>
							<th>${item.firstName}</th>
							<th>${item.lastName}</th>
							<th>${item.middleName}</th>
						</tr>
					</c:forEach>
				</table>
			</div>
		</form>
	</div>

</body>
</html>
