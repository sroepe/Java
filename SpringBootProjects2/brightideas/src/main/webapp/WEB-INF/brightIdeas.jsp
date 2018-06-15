<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Bright Ideas</title>
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
	    
	    <c:forEach items="${ideas}" var = "idea">
		    <p>*<a href="/users/${idea.user.id}">${idea.user.name}</a> says: <c:out value="${idea.description}"/>  <c:if test= "${idea.user.id != sessionAttribute.id}">    <a href="/addLike/${idea.like.id}/${sessionAttribute.id}">Like</a> </c:if>       <a href="/bright_ideas/${idea.id}"><c:out value="${idea.like.count}"/> people</a> like this.
		
			<c:if test= "${idea.user.id == sessionAttribute.id}">
				<a href="/delete/${idea.id}">Delete</a>
		    </c:if>
		</c:forEach>
	</body>
</html>