<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<% response.setHeader("Cache-Control","public");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Bright Ideas</title>
		<link rel="stylesheet" type="text/css" href="css/style_brightIdeas.css">

	</head>
	<body>
		<h2>Hi <c:out value="${sessionAttribute.name}"></c:out>!</h2>
		<a href="/logout">Logout</a>
		
		<form:form method="POST" action="/addIdea/${sessionAttribute.id}" modelAttribute="idea">
			<p> <form:label path="description"/>
				<form:errors path="description"/>
				<form:input type="text" path="description" placeholder="Post something witty here"/>
				
				<input type="submit" value="Idea!"/></p>
	    </form:form>
	    
	   	<p style="font-weight:bold; color:red">${log}</p>

	    <ul>

		    <c:forEach items="${ideas}" var = "idea">
				
				
				  
			    <li><a href="/users/${idea.user.id}">${idea.user.name}</a> says: <c:out value="${idea.description}"/> <c:if test= "${idea.user.id != sessionAttribute.id}">    <a href="/addLike/${idea.id}">Like</a> </c:if><a href="/bright_ideas/${idea.id}"><c:out value="${idea.likes.size()}"/> people</a> like this.
		
				<c:if test= "${idea.user.id == sessionAttribute.id}">
					<a href="/delete/${idea.id}">Delete</a>
			    </c:if>
			</c:forEach> 
		</ul>
	</body>
</html>