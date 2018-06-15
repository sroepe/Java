<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>

<html>
	<head>
		<title>Current visit count</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body id="counter">
		<h3>You have visited this page because you clicked on the double link.  The counter adds 2 each time you visit the page.  You have visited <a href="/">http://localhost:8080 </a> <c:out value="${counter}"/> times.</h3>
		<a href="/reset">Test Another Visit?</a>
	</body>
</html>