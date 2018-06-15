<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Date</title>
		 <link rel="stylesheet" type="text/css" href="css/datetime.css">
	</head>
	<body>
		 <c:set var = "now" value = "<%= new java.util.Date()%>" />
		 <span id="date"><fmt:formatDate pattern="EEEE, 'the' dd 'of' MMMM, yyyy"  value="${now}" /></span>
		
	
	</body>
</html>