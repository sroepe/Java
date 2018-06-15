<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<title>Search Results</title>
	</head>
	<body>
		<div id="header">
			<a href="/dashboard">Dashboard</a>
			<h3>Songs by Artist: ${artist}</h3> 
			<form method="POST" action="/search/">
				<input type="text" name="artist" placeholder="artist name">
				<input type="submit" value="Search Artists">
			</form>
		</div>
		<div id="list">
			<table>
				<tr>
					<th>Artist</th>
					<th>Song Title</th>
					<th>Rating</th>
					<th>Actions</th>
				</tr>
				<c:forEach items="${songs}" var="song" varStatus="loop">
					<tr>
						<td><c:out value="${song.artist}"/></td>
						<td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
						<td><c:out value="${song.rating}"/></td>
						<td><a href="/delete/${song.id}">Delete</a></td>
					</tr>
				</c:forEach>
			
			</table>
	
		</div>
	</body>
</html>