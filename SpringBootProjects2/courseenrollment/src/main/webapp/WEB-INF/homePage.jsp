<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>
	<form id="logoutForm" method="POST" action="/logout">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" /> <input type="submit" value="Logout" />
	</form>
	<h1>
		Welcome
		<c:out value="${currentUser.username}"></c:out>
	</h1>
	<p>This is your student sign-up portal. Check your class schedule
		and find courses for the next semester.</p>
	<p>
	<h3>My Schedule</h3>

	<table>
		<tr>
			<th>Course</th>
			<th>Instructor</th>
			<th>Days</th>
			<th>Times</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${coursesOfUser}" var="course">
			<tr>
				<td><c:out value="${course.name}" /></td>
				<td><c:out value="${course.instructor}" /></td>
				<td><c:out value="${course.days}" /></td>
				<td><c:out value="${course.times}" /></td>
				<td><a href="/dropClass">Drop</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<a href="/courses">Find Courses</a>
</body>
</html>