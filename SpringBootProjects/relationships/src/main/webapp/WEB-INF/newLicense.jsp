<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>New License</title>
	</head>
	<body>
		<h1>New License</h1>
		
		<form:form method="POST" action="/addLicense" modelAttribute="license">
			<form:hidden path="id"/>
			
			<p><form:label path="person">Person:
			<form:errors path="person"/>
			<form:select path="person" items="${persons}" itemValue="id" itemLabel="fullName"/></form:label></p>
			
			<p><form:label path="state">State:
			<form:errors path="state"/>
			<form:input path="state"/></form:label></p>
			
			<p><form:label path="expiration_date">Expiration Date:
			<form:errors path="expiration_date"/>
			<form:input type="date" path="expiration_date"/></form:label></p>
			
			<p><input type="submit" value="Create"></p>
		
		</form:form>
	</body>
</html>