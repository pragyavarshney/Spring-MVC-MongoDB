<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.html"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Final page </title>
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
<body bgcolor="#ccccff">
<div align="center">
<form:form method="post" action="/MongoTest/processViewById.do">
	<h3 align="center">Following is the information requested.</h3>
	
	<table cellpadding="" cellspacing="" width="40%" align="center" style="border: 1px solid blue; margin-bottom:5%;">
		<tr>
			<td class="in">Id:</td>
			<td class="in">${user.id}</td>
		</tr>	
		<tr>
			<td class="in">First Name:</td>
			<td class="in">${user.firstName}</td>
		</tr>
		<tr>
			<td class="in">Last Name:</td>
			<td class="in">${user.lastName}</td>
		</tr>
		<tr>
			<td class="in">Middle Name:</td>
			<td class="in">${user.middleName}</td>
		</tr>
		
	</table>
</form:form>
</div>
</body>
</html>
