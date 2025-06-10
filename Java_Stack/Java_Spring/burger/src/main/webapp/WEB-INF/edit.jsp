<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>edit burger</title>
<link rel="stylesheet" href="/style.css">

</head>
<body>

<form:form action="/burgers/edit/${burger.id}/add" method="post" modelAttribute="burger">
 	<p>
        <form:label path="burger_name">Burger name</form:label>
        <form:errors path="burger_name"/>
        <form:input path="burger_name"/>
    </p>
    <p>
        <form:label path="restaurant">restaurant</form:label>
        <form:errors path="restaurant"/>
        <form:input path="restaurant"/>
    </p>
	<p>
        <form:label path="rating">rating</form:label>
        <form:errors path="rating"/>
        <form:input path="rating"/>
    </p>
    <p>
        <form:label path="notes">notes</form:label>
        <form:errors path="notes"/>
        <form:input path="notes"/>
    </p>

	<input class="submit" type="submit" value="submit">
	
	

</form:form>
</body>
</html>