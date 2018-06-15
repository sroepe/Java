<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Dojo Added!</title>
	</head>
	<body>
		<h1>A DOJO has successfully been added to the database.</h1>
		<p><c:out value="${dojo.name}"/></p>
		
		<a href="/">Add Another Dojo</a> <a href="/ninjas/new">Add a Ninja</a>
	</body>
</html>