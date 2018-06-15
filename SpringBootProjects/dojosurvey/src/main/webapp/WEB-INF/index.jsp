<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Dojo Survey Index</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
	</head>
	<body>
		<form method="POST" action="/login">
			<p><label>Your Name: <input type="text" name="name"> </label></p>
			<p><label>Dojo Location: 
				<select name="location">
					<option value="Seattle">Seattle</option>
					<option value="San Jose">San Jose</option>
					<option value="Burbank">Burbank</option>
					<option value="Chicago">Chicago</option>
					<option value="Washington DC">Washington DC</option>
				</select>
			</label></p>
			<p><label>Favorite Language: 
				<select name="language">
					<option value="Python">Python</option>
					<option value="C #">C#</option>
					<option value="MEAN">MEAN</option>
					<option value="Java">Java</option>
				</select>
			</label></p>
			<p><label>Comment (optional) <textarea name="comment"></textarea>  </label></p>
			<p><button type="submit">Button</button></p>
		</form>
	</body>

</html>