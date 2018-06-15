<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<title>Secret Code</title>
	</head>
	<body>
		 <p class="error"><c:out value="${errors}"></c:out></p>
		 <p>What is the code?</p>
		 <form method="POST" action="/code">
			 <p><input type="text" name="code"></p>
			 <p><input type="submit" value="Try Code"></p>
		 </form>
	</body>
</html>