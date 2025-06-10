<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Burgers</title>
<link rel="stylesheet" href="/style.css">
</head>
<body>


<h1>Burger Tracker</h1>
<table>
    <thead>
        <tr>
            <th>Burger Name</th>
            <th>Restaurant Name</th>
            <th>Rating (/5)</th>
            <th>edit</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="burger" items="${burgers}">
    	<tr>
 	    	<td><c:out value="${burger.burger_name}" /></td>
    		<td><c:out value="${burger.restaurant}" /></td>
    		<td><c:out value="${burger.rating}" /></td>
    		<td><a href="burgers/edit/${burger.id}">edit</a></td>
    	</tr>
    </c:forEach>
    
    </tbody>
</table>

<h2>Add a burger</h2>
<form:form action="/add" method="POST" modelAttribute="burger">
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