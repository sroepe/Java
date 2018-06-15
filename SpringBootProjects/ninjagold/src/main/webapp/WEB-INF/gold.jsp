<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Ninja Gold Game</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body>
		<div id="header">
			<h1>Your Gold: <span><c:out value="${gold}"/></span></h1>
			<img id="image" alt="" src="images/goldcoins.jpg">
		</div>
		<div id="boxes">
			<div class="building">
				<h1>Farm</h1><br>
				<h2>(earns 10-20 gold)</h2><br><br>
				<form method="post" action="/findgold">
					<button type="submit" value="farm" name="bldg">Find Gold!</button>
				</form>
			</div>
			<div class="building">
				<h1>Cave</h1><br>
				<h2>(earns 5-10 gold)</h2><br><br>
				<form method="post" action="/findgold">
					<button type="submit" value="cave" name="bldg">Find Gold!</button>
				</form>
			</div>
			<div class="building">
				<h1>House</h1><br>
				<h2>(earns 2-5 gold)</h2><br><br>
				<form method="post" action="/findgold">
					<button type="submit" value="house" name="bldg">Find Gold!</button>
				</form>
			</div>
			<div class="building">
				<h1>Casino!</h1><br>
				<h2 id="casinolinespc">(earns/takes 0-50 gold)</h2>
				<form method="post" action="/findgold">
					<button type="submit" value="casino" name="bldg">Find Gold!</button>
				</form>
			</div>
		</div>
		<h1>Activities:</h1>
		<div id="logbox">
			<c:forEach items = "${activityLog}" var = "activity"><p>${activity}</p>k</c:forEach>
		</div>
		<a href="/reset">Start New Game</a>
	</body>
</html>
