<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<html>
	<head>
		<title>Hello... Human</title>
		<link rel="stylesheet" type="text/css" href="css/style_about.css">
    	<script type="text/javascript" src="js/app.js"></script>
	</head>
	<body>
		<h1>Hello <c:out value="${firstName}"/> <c:out value="${lastName}"/> !!</h1>
		<h1></h1>
		<h4>Welcome to SpringBoot</h4>

	</body>
</html>

