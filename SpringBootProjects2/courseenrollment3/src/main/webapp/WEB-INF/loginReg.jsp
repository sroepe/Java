<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Student Sign Up</title>
	</head>
	<body>
		<p>${log}</p>
		<fieldset><legend>Login</legend>
	    <form method="POST" action="/login">
	        <p>Username: <input type="text" id="username" name="username"/></p>
	        <p>Password: <input type="password" id="password" name="password"/></p>

	        <input type="submit" value="Login"/>
	    </form>
	    </fieldset>
	    
	    <p>${reg}</p>
	    <fieldset><legend>Register</legend>
	    
	    <form:form method="POST" action="/register" modelAttribute="user">
	        <p> <form:label path="username"/>Username:
	            <form:errors path="username"/>
	            <form:input type="text" path="username"/></p>
	            
	        <p> <form:label path="email"/>Email:
	        	<form:errors path="email"/>
	            <form:input type="text" path="email"/></p>
	            
	        <p> <form:label path="password"/>Password:
				<form:errors path="password"/>
	            <form:input type="password" path="password"/></p>
	            
	        <p> Password Confirmation: <input type="password" name="confirmPassword"/></p>
	        
	        <p> <input type="submit" value="Register"/></p>
	    </form:form>
	    </fieldset>
	</body>
</html>