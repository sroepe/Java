<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<title>Fortran Dashboard</title>
	</head>
	<body>
		<div id="header">
			<h1>Fortran!</h1>
			<a href="/m/38/0553/0733">Set up</a>
			<a href="/m/38/0483/0345">Forms</a>
			<a href="/m/38/0553/0342">Cards</a>
			<a href="/m/26/0553/0348">Advanced</a>
			<a href="/m/26/0483/2342">Binary</a>
			<br>
			<textarea rows=10, cols=50 id="descBox"><c:out value="${content}"></c:out></textarea>
		</div>
	</body>
</html>