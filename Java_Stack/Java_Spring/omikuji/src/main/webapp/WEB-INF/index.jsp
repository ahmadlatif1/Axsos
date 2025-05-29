<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

	<div class="formOuter">
		<h2>send an omikuji</h2>
		
		<form action="omikuji/show/" method="POST">
		
			<label for="number">Pick any number from 5 to 25<input type="number" name="number" min="5" max="25"></label>
			
			<label for="city">Enter the name of a city<input type="text" name="city"></label>
			<label for="person">Enter the name of a real person<input type="text" name="person"></label>
			<label for="hobby">Enter a professional endeavor/hobby<input type="text" name="hobby"></label>
			<label for="creature">Enter any type of living thing<input type="text" name="creature"></label>
			<label for="message">be nice<textarea name="message"></textarea></label>
			
			<label for="submit">Send and show a friend<input class="submit" type="submit" name="submit" value="Send"></label>
			
			

		
		
		</form>
		
	</div>
	

</body>
</html>