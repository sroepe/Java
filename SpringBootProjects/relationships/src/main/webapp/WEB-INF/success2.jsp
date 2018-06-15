<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>License Added!</title>
	</head>
	<body>
		<h1>You have successfully added your license to the database.</h1>
		<p><c:out value="${person.firstName}"/></p>
		<p><c:out value="${person.lastName}"/></p>
		<p><c:out value="${license.state}"/></p>
		<p><c:out value="${license.expiration_date}"/></p>
		
		
		<a href="/">Add Another Person</a> 
	</body>
</html>