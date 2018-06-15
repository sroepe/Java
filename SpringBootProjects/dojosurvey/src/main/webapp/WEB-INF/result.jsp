<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Dojo Survey Index</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body>
		<h5>Submitted Info</h5>
		<p>Name: <c:out value="${name}"/></p>
		<p>Dojo Location: <c:out value="${location}"/></p>
		<p>Favorite Language: <c:out value="${language}"/></p>
		<p>Comment: <c:out value="${comment}"/></p>
		<form method="GET" action="/">
			<button>Go Back</button>
		</form>
	</body>

</html>