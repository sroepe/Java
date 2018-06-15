<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<title>Welcome Page</title>
</head>
<body>
	<h1>Course Dashboard</h1>




		<form:form method="POST" action="/courses" >		
			<select name="semester">
				<c:forEach items="${semesters}" var="semester" >
					<option><c:out value="${semester}"/></option>
				</c:forEach>
			</select>
			<input type="submit" value="Go">	
		
			
		</form:form>
		
		<h2>${semester}</h2>
	<table>
		<tr>
			<th>Course</th>
			<th>Instructor</th>
			<th>Days</th>
			<th>Start Time</th>
			<th>End Time
			<th>Capacity</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${semCourses}" var="semCourse" >
			<tr>
				<td><c:out value="${semCourse.name}" /></td>
				<td><c:out value="${semCourse.instructor}" /></td>
				<td><c:out value="${semCourse.days}" /></td>
				<td><c:out value="${semCourse.starttime}" /></td>
				<td><c:out value="${semCourse.endtime}" /></td>
				<td>TBD capacity/15</td>
				<td><a href="add/${semCourse.id}">Add</a></td>

			</tr>
		</c:forEach>
	</table>
	<a href="/goback">Return to My Schedule</a>
	</body>
</html>