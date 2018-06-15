<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Login/Registration</title>
	</head>
	<body>
		<h1>Welcome to Bright Ideas!</h1>
		<p>${log}</p>
		<fieldset><legend>Login</legend>
		    <form method="POST" action="/login">
		    	<p>Email: <input type="text" id="email" name="email"/></p>
		        <p>Password: <input type="password" id="password" name="password"/></p>
	
		        <input type="submit" value="Login"/>
		    </form>
	    </fieldset>
	    
	    <p>${reg}</p>
	    <fieldset><legend>Register</legend>
	    
		<form:form method="POST" action="/register" modelAttribute="user">
			<p> <form:label path="name"/>Name:
				<form:errors path="name"/>
				<form:input type="text" path="name"/></p>

	        <p> <form:label path="alias"/>Alias:
	            <form:errors path="alias"/>
	            <form:input type="text" path="alias"/></p>
	            
	        <p> <form:label path="email"/>Email:
	        	<form:errors path="email"/>
	            <form:input type="text" path="email"/></p>
	            
	        <p> <form:label path="password"/>Password:
				<form:errors path="password"/>
	            <form:input type="password" path="password"/></p>
	        <p>*Password should be at least 8 characters.</p>
	            
	        <p>  Confirm PW: <input type="password" name="confirmPassword"/></p>
	        
	        <p> <input type="submit" value="Register"/></p>
	    </form:form>
	    </fieldset>
	</body>
</html>