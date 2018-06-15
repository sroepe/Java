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
    <p><c:if test="${logoutMessage != null}">
        <c:out value="${logoutMessage}"></c:out>
    </c:if></p>
    
    <fieldset><legend>Login</legend>
    <c:if test="${errorMessage != null}">
        <c:out value="${errorMessage}"></c:out>
    </c:if>
    <form method="POST" action="/login">
        <p>
            <label for="username">Username</label>
            <input type="text" id="username" name="username"/>
        </p>
        <p>
            <label for="password">Password</label>
            <input type="password" id="password" name="password"/>
        </p>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Login"/>
    </form>
    </fieldset>
    
    <fieldset><legend>Register</legend>
    
    <p><form:errors path="user.*"/></p>
    
    <form:form method="POST" action="/registration" modelAttribute="user">
        <p>
            <form:label path="username">Username</form:label>
            <form:input path="username" name="username"/>
        </p>
        <p>
            <form:label path="email">Email</form:label>
            <form:input path="email" name="email"/>
        </p>
        <p>
            <form:label path="password">Password</form:label>
            <form:password path="password" name="password"/>
        </p>
        <p>
            <form:label path="passwordConfirmation">Confirm Password</form:label>
            <form:password path="passwordConfirmation" name="passwordConfirmation"/>
        </p>
        <input type="submit" value="Register"/>
    </form:form>
    </fieldset>
</body>
</html>