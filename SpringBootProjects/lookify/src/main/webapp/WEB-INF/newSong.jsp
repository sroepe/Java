<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<title>Add Song</title>
	</head>
	<body>
		<a href="/dashboard">Dashboard</a>

		<form:form method="POST" action="/addSong" modelAttribute="song">
			<p><form:label path="title">Title
			<form:errors path="title"/>
			<form:input path="title" placeholder="song title, e.g. 'Pretty Woman'"/></form:label></p>
			
			<p><form:label path="artist">Artist
			<form:errors path="artist"/>
			<form:input path="artist" placeholder="artist name, e.g. Ed Sheeran"/></form:label></p>
			
			<p><form:label path="rating">Rating (1-10)
			<form:errors path="rating"/>
			<form:select path="rating" placeholder="artist name, e.g. Ed Sheeran">
				<form:option type="number" value="1">1</form:option>
				<form:option type="number" value="2">2</form:option>
				<form:option type="number" value="3">3</form:option>
				<form:option type="number" value="4">4</form:option>
				<form:option type="number" value="5">5</form:option>
				<form:option type="number" value="6">6</form:option>
				<form:option type="number" value="7">7</form:option>
				<form:option type="number" value="8">8</form:option>
				<form:option type="number" value="9">9</form:option>
				<form:option type="number" value="10">10</form:option></form:select></form:label></p>
			
			<p><input type="submit" value="Add Song"/></p>
		</form:form>

	</body>
</html>