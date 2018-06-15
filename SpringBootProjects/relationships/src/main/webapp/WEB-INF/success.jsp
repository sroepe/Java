<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Person Added!</title>
	</head>
	<body>
		<h1>You have successfully been added to the database.</h1>
		<p><c:out value="${person.firstName}"/></p>
		<p><c:out value="${person.lastName}"/></p>
		
		<a href="/">Add Another Person</a> <a href="/licenses/new">Add a License</a>
	</body>
</html>