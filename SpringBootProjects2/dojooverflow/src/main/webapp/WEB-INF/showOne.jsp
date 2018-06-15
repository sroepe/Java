<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Questions Profile</title>
	</head>
	<body>
		<h1><c:out value="${question.questionText}"/></h1>
		<p><span style="font-size: 16pt; font-weight: bold">Tags: </span><c:forEach items="${question.tags}" var="tag"> <c:out value="${tag.subject}"/> </c:forEach></p>
		
		<h4>Answers:</h4>
		<c:forEach items="${question.answers}" var="answer" >
			<p>- <c:out value="${answer.answerText}"/></p>
		</c:forEach>
		
		<h2>Add Your Answer:</h2>
		<form:form method="POST" action="/${question.id}/addAnswer" modelAttribute="answer">	
			<form:hidden path="id"/>	
			<p><form:label path="answerText">Answer:
			<form:errors path="answerText"/>
			<form:textarea path="answerText"/></form:label>
			</p>
			
			
			<p><input type="submit" value="Add Answer"></p>
		
			
		</form:form>
		

		

	</body>
</html>