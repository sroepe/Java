<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>New Ninja</title>
	</head>
	<body>
		<h1>New Ninja</h1>
	
		<form:form method="POST" action="/ninjas/new" modelAttribute="ninja">
			<form:hidden path="id"/>
			
			<p><form:label path="dojo">Dojo Location:
			<form:errors path="dojo"/>
			<form:select path="dojo" items="${dojos}" itemValue="id" itemLabel="name"/></form:label></p>
			
			<p><form:label path="firstName">First Name:
			<form:errors path="firstName"/>
			<form:input path="firstName"/></form:label></p>
			
			<p><form:label path="lastName">Last Name:
			<form:errors path="lastName"/>
			<form:input path="lastName"/></form:label></p>
			
			<p><form:label path="age">Age:
			<form:errors path="age"/>
			<form:input type="number" path="age"/></form:label></p>
			
			<p><input type="submit" value="Create"></p>
		
		</form:form>
		<a href="/dojos/new">Add a Dojo</a>
	</body>
</html>