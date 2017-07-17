<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List</title>
</head>
<body>
	<center>
	<h1>List......</h1>
		<table border="10" bordercolor="blue">
			<tr>
				<th width="5%">Id</th>
				<th width="5%">Name</th>
				<th width="5%">Date</th>

			</tr>
			<c:forEach var="list" items="${getlist}">
				<tr>
					<td><c:out value="${list.getId()}" /></td>
					<td><c:out value="${list.getName()}" /></td>
					<td><c:out value="${list.getStartDate()}" /></td>
				</tr>
			</c:forEach>
		</table>
	</center>
</body>
</html>