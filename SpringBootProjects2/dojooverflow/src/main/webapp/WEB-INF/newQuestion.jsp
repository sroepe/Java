<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>New Question</title>
	</head>
	<body>
		<h1>What is your question?</h1>
	
		<form:form method="POST" action="/questions/new" modelAttribute="question">
			<form:hidden path="id"/>
			
			<p><form:label path="questionText">Question:
			<form:errors path="questionText"/>
			<form:input path="questionText"/></form:label></p>
			
			<p>Tags:<input type="text" name="tagStr"/></p>
			<p>${error}</p>
			
			<p><input type="submit" value="Submit"></p>
		
		</form:form>
		
	</body>
</html>