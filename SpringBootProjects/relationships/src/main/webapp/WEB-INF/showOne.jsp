<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Profile Page</title>
	</head>
	<body>
		<p>
			<h1><c:out value="${person.fullName}"></c:out></h1> 
		</p>
		<p><c:out value="${person.license.number}"/></p>
		<p><c:out value="${person.license.state}"/></p>
		<p><c:out value="${person.license.expiration_date}"/></p>
		
		<a href="/">Add Another Person</a> 
	</body>
</html>