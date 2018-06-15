<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Ninja Added!</title>
	</head>
	<body>
		<h1>A NINJA has successfully been added to the database.</h1>
		<p><a href="/dojos/${ninja.dojo.id}"><c:out value="${ninja.dojo.name}"/></a></p>
		<p><c:out value="${ninja.firstName}"/></p>
		<p><c:out value="${ninja.lastName}"/></p>
		<p><c:out value="${ninja.age}"/></p>
		
		
		<a href="/ninjas/new">Add Another Ninja</a> 
	</body>
</html>