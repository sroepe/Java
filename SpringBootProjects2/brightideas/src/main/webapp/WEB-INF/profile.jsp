<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>User Profile</title>
	</head>
	<body>
		<a href="/bright_ideas">Bright Ideas</a>
		<a href="/logout">Logout</a>
		  
	    <p>Name: <c:out value="${user.name}"/> </p>
		<p>Alias: <c:out value="${user.alias}"/> </p>
		<p>Email: <c:out value="${user.email}"/> </p>



		<p>Total Number of Posts: <c:out value="${userPosts}"/></p>
		<p>Total Number of Likes: <c:out value="${userLikes}"/></p>
	</body>
</html>