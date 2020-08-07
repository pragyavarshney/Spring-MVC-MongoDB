<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="header.html"%>
<html>
<head>
<title>Get details</title>
</head>
<body bgcolor="#ccccff" leftmargin="10px" rightmargin="10px">
	<div align="center">
		<h3>Insert Id</h3>
		<form:form method="post" action="/MongoTest/processUser.do">
			<table cellpadding="5" cellspacing="" width="55%"
				style="margin-bottom: 10%;">
				<tr>
					<td style="padding-left: 40px;">Name</td>
					<td><input name="personid" /></td>
					<td><input type="submit" name="save" value="Get" /></td>
					<td width="201"><input type="reset" name="clear" value="Clear" />&nbsp;</td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>