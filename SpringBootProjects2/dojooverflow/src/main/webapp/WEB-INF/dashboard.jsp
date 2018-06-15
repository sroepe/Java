<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Questions Dashboard</title>
	</head>
	<body>
		<h1>Questions Dashboard</h1>
		
		<table>
			<tr>
				<th>Question</th>
				
			</tr>
			<c:forEach items ="${questions}" var ="question">
				<tr>
					<td><a href="/questions/${question.id}"><c:out value="${question.questionText}"/></a></td>
					<c:forEach items="${question.tags}" var="tag" varStatus="loop">
						<td><c:out value="${tag.subject}"/></td>
					</c:forEach>
				</tr>
			</c:forEach>		
		</table>
		
		<a href="/questions/new">New Question</a>
	
		
	</body>
</html>