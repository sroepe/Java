<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

		<title>Like Status</title>
	</head>
	<body>
		<a href="/bright_ideas">Bright Ideas</a>
		<a href="/logout">Logout</a>
		
		<p><a href="/users/${idea.user.id}">${idea.user.name}</a> says: <c:out value="${idea.description}"/> 
		 
	    <h3>People who liked this post:</h3>
	    <table>
	    	<tr>
	    		<th>Alias</th>
	    		<th>Name</th>
	    	</tr>
	    	
	    	<c:forEach items="${idea.likes}" var = "user" >
	    		
				
					<tr>
						<td><a href="/users/${user.id}">${user.alias}</a> </td>
						<td>${user.name}</td>
					</tr>

			
			</c:forEach>
	    
	    </table>

	</body>
</html>