<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Time</title>
		 <link rel="stylesheet" type="text/css" href="css/datetime.css">
	</head>
	<body>
		 <c:set var = "now" value = "<%= new java.util.Date()%>" />
		 <span id="time"><fmt:formatDate pattern="hh:mm a"  value="${now}" /></span>
	
	
	</body>
</html>