<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<title>My Course Schedule</title>
	</head>
	<body>
		<h1>Welcome	<c:out value="${sessionAttribute.username}"></c:out> 
		</h1>
		<p>This is your student sign-up portal. Check your class schedule
			and find courses for the next semester.</p>
		<p>
			<form:form method="POST" action="/home" >		
				<select name="semester">
					<c:forEach items="${semesters}" var="semester" >
						<option><c:out value="${semester}"/></option>
					</c:forEach>
				</select>
				<input type="submit" value="Go">	
			</form:form>
		</p>
		<h3>My Schedule - ${semester}</h3>
	
		<table>
		<tr>
			<th>Course</th>
			<th>Instructor</th>
			<th>Days</th>
			<th>Start Time</th>
			<th>End Time</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${courseUsers}" var="course">
			<tr>
				<td><c:out value="${course.name}" /></td>
				<td><c:out value="${course.instructor}" /></td>
				<td><c:out value="${course.days}" /></td>
				<td><c:out value="${course.starttime}" /></td>
				<td><c:out value="${course.endtime}" /></td>
				<td><a href="drop/${course.id}">Drop</a></td>

			</tr>
		</c:forEach>
	</table>
		

	
	<a href="/courses">Find Courses</a>
		
		
	
	</body>
</html>