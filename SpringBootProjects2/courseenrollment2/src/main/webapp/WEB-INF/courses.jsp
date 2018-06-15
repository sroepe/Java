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
	<h1>Course Dashboard</h1>
	

	<table>
		<tr>
			<th>Course</th>
			<th>Instructor</th>
			<th>Days</th>
			<th>Times</th>
			<th>Capacity</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${courses}" var="course" >
			<tr>
				<td><c:out value="${course.name}" /></td>
				<td><c:out value="${course.instructor}" /></td>
				<td><c:out value="${course.days}" /></td>
				<td><c:out value="${course.startTime}" /> - <c:out value="${course.endTime}"/></td>
				<td><c:out value="${course.capacity}" />/15</td>
				<td><a href="/add/${course.id}">Add</a></td>

			</tr>
		</c:forEach>
	</table>
	<a href="/goback">Return to My Schedule</a>
	</body>
</html>