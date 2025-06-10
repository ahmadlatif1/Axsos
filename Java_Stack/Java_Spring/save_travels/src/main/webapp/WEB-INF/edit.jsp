<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/style.css">

</head>
<body>



<form:form action="/items/edit/${item.id}/add" method="post" modelAttribute="item">
 	<p>
        <form:label path="item_name">Item name</form:label>
        <form:errors path="item_name"/>
        <form:input path="item_name"/>
    </p>
    <p>
        <form:label path="vendor">vendor</form:label>
        <form:errors path="vendor"/>
        <form:input path="vendor"/>
    </p>
	<p>
        <form:label path="price">price</form:label>
        <form:errors path="price"/>
        <form:input path="price"/>
    </p>
    <p>
        <form:label path="description">description</form:label>
        <form:errors path="description"/>
        <form:input path="description"/>
    </p>

	<input class="submit" type="submit" value="submit">
	
	

</form:form>

</body>
</html>