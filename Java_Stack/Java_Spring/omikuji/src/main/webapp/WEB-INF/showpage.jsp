<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/style.css">
</head>
<body>
	
	<div class="formOuter">
		<h2>here's your omikuji:</h2>
		<div class="omikuji">
		<span><%= session.getAttribute("result") %></span>
		</div>
		<a href="/omikuji">go back</a>
		
	</div>

</body>
</html>