<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Languages</title>
	</head>
	<body>
		<table class="table">
			<tr>
				<th>Name</th>
				<th>Creator</th>
				<th>Version</th>
				<th>action</th>
			</tr>
			<c:forEach items="${languages}" var="language" >
			    <tr>    
				    <td><a href="/languages/${language.id}"><c:out value="${language.name}"/></a></td>
				    <td><c:out value="${language.creator}"/></td>
				    <td><c:out value="${language.currentVersion}"/></td>
				    <td><a href="/languages/delete/${language.id}">Delete</a> <a href="/languages/update/${language.id}">Edit</a></td>
			    </tr>
			</c:forEach>
		</table>
		<form:form method="POST" action="/newLanguage" modelAttribute="language">
			<form:hidden path ="id"/>
		    <p><form:label path="name">Name
		    <form:errors path="name"/>
		    <form:input path="name"/></form:label></p>
		    
		    <p><form:label path="creator">Creator
		    <form:errors path="creator"/>
		    <form:textarea path="creator"/></form:label></p>
		    
		    <p><form:label path="currentVersion">Version
		    <form:errors path="currentVersion"/>
		    <form:input path="currentVersion"/></form:label></p>
		    
		    <p><input type="submit" value="Submit"/></p>
		</form:form>
		

	</body>
</html>