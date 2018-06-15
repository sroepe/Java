<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Product Page</title>
	</head>
	<body>
		<p>
			<h1><c:out value="${course.name}"/></h1> 
		</p>
		<h3>Users:</h3>
		<ul>
			<c:forEach items="${course.users}" var="user" >
				<li><c:out value="${user.username}"/></li>	
				
			</c:forEach>
		</ul>
		
		<form action="/add/${id}" method="POST">
			<select>
				
				<option><c:out value="${currentUser.username}"/>
				</option>
			</select>
		
		</form>
		<form:form method="POST" action="/add/${id}" modelAttribute="user" >	
			<p><form:label path="username">Add User:
			<form:errors path="username"/>
			<form:select path="username" items="${notCourseUsers}" itemValue="id" itemName="username"/></form:label>
			</p>
			
			
			<p><input type="submit" value="Add"></p>
		
			
		</form:form>
		

		
		<a href="/courses">Return to Course List</a> 
	</body>
</html>